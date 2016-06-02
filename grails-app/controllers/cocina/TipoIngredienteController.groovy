package cocina



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TipoIngredienteController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TipoIngrediente.list(params), model:[tipoIngredienteInstanceCount: TipoIngrediente.count()]
    }

    def show(TipoIngrediente tipoIngredienteInstance) {
        respond tipoIngredienteInstance
    }

    def create() {
        respond new TipoIngrediente(params)
    }

    @Transactional
    def save(TipoIngrediente tipoIngredienteInstance) {
        if (tipoIngredienteInstance == null) {
            notFound()
            return
        }

        if (tipoIngredienteInstance.hasErrors()) {
            respond tipoIngredienteInstance.errors, view:'create'
            return
        }

        tipoIngredienteInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoIngrediente.label', default: 'TipoIngrediente'), tipoIngredienteInstance.id])
                redirect tipoIngredienteInstance
            }
            '*' { respond tipoIngredienteInstance, [status: CREATED] }
        }
    }

    def edit(TipoIngrediente tipoIngredienteInstance) {
        respond tipoIngredienteInstance
    }

    @Transactional
    def update(TipoIngrediente tipoIngredienteInstance) {
        if (tipoIngredienteInstance == null) {
            notFound()
            return
        }

        if (tipoIngredienteInstance.hasErrors()) {
            respond tipoIngredienteInstance.errors, view:'edit'
            return
        }

        tipoIngredienteInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TipoIngrediente.label', default: 'TipoIngrediente'), tipoIngredienteInstance.id])
                redirect tipoIngredienteInstance
            }
            '*'{ respond tipoIngredienteInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TipoIngrediente tipoIngredienteInstance) {

        if (tipoIngredienteInstance == null) {
            notFound()
            return
        }

        tipoIngredienteInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TipoIngrediente.label', default: 'TipoIngrediente'), tipoIngredienteInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoIngrediente.label', default: 'TipoIngrediente'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
