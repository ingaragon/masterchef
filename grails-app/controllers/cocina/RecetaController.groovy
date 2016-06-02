package cocina



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RecetaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Receta.list(params), model:[recetaInstanceCount: Receta.count()]
    }

    def show(Receta recetaInstance) {
        respond recetaInstance
    }

    def create() {
        respond new Receta(params)
    }

    @Transactional
    def save(Receta recetaInstance) {
        if (recetaInstance == null) {
            notFound()
            return
        }

        if (recetaInstance.hasErrors()) {
            respond recetaInstance.errors, view:'create'
            return
        }

        recetaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'receta.label', default: 'Receta'), recetaInstance.id])
                redirect recetaInstance
            }
            '*' { respond recetaInstance, [status: CREATED] }
        }
    }

    def edit(Receta recetaInstance) {
        respond recetaInstance
    }

    @Transactional
    def update(Receta recetaInstance) {
        if (recetaInstance == null) {
            notFound()
            return
        }

        if (recetaInstance.hasErrors()) {
            respond recetaInstance.errors, view:'edit'
            return
        }

        recetaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Receta.label', default: 'Receta'), recetaInstance.id])
                redirect recetaInstance
            }
            '*'{ respond recetaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Receta recetaInstance) {

        if (recetaInstance == null) {
            notFound()
            return
        }

        recetaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Receta.label', default: 'Receta'), recetaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'receta.label', default: 'Receta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
