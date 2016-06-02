package cocina



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TipoComidaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TipoComida.list(params), model:[tipoComidaInstanceCount: TipoComida.count()]
    }

    def show(TipoComida tipoComidaInstance) {
        respond tipoComidaInstance
    }

    def create() {
        respond new TipoComida(params)
    }

    @Transactional
    def save(TipoComida tipoComidaInstance) {
        if (tipoComidaInstance == null) {
            notFound()
            return
        }

        if (tipoComidaInstance.hasErrors()) {
            respond tipoComidaInstance.errors, view:'create'
            return
        }

        tipoComidaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoComida.label', default: 'TipoComida'), tipoComidaInstance.id])
                redirect tipoComidaInstance
            }
            '*' { respond tipoComidaInstance, [status: CREATED] }
        }
    }

    def edit(TipoComida tipoComidaInstance) {
        respond tipoComidaInstance
    }

    @Transactional
    def update(TipoComida tipoComidaInstance) {
        if (tipoComidaInstance == null) {
            notFound()
            return
        }

        if (tipoComidaInstance.hasErrors()) {
            respond tipoComidaInstance.errors, view:'edit'
            return
        }

        tipoComidaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TipoComida.label', default: 'TipoComida'), tipoComidaInstance.id])
                redirect tipoComidaInstance
            }
            '*'{ respond tipoComidaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TipoComida tipoComidaInstance) {

        if (tipoComidaInstance == null) {
            notFound()
            return
        }

        tipoComidaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TipoComida.label', default: 'TipoComida'), tipoComidaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoComida.label', default: 'TipoComida'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
