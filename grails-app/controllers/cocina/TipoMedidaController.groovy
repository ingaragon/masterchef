package cocina



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TipoMedidaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TipoMedida.list(params), model:[tipoMedidaInstanceCount: TipoMedida.count()]
    }

    def show(TipoMedida tipoMedidaInstance) {
        respond tipoMedidaInstance
    }

    def create() {
        respond new TipoMedida(params)
    }

    @Transactional
    def save(TipoMedida tipoMedidaInstance) {
        if (tipoMedidaInstance == null) {
            notFound()
            return
        }

        if (tipoMedidaInstance.hasErrors()) {
            respond tipoMedidaInstance.errors, view:'create'
            return
        }

        tipoMedidaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoMedida.label', default: 'TipoMedida'), tipoMedidaInstance.id])
                redirect tipoMedidaInstance
            }
            '*' { respond tipoMedidaInstance, [status: CREATED] }
        }
    }

    def edit(TipoMedida tipoMedidaInstance) {
        respond tipoMedidaInstance
    }

    @Transactional
    def update(TipoMedida tipoMedidaInstance) {
        if (tipoMedidaInstance == null) {
            notFound()
            return
        }

        if (tipoMedidaInstance.hasErrors()) {
            respond tipoMedidaInstance.errors, view:'edit'
            return
        }

        tipoMedidaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TipoMedida.label', default: 'TipoMedida'), tipoMedidaInstance.id])
                redirect tipoMedidaInstance
            }
            '*'{ respond tipoMedidaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TipoMedida tipoMedidaInstance) {

        if (tipoMedidaInstance == null) {
            notFound()
            return
        }

        tipoMedidaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TipoMedida.label', default: 'TipoMedida'), tipoMedidaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoMedida.label', default: 'TipoMedida'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
