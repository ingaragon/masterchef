package cocina



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class IngredienteController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Ingrediente.list(params), model:[ingredienteInstanceCount: Ingrediente.count()]
    }

    def show(Ingrediente ingredienteInstance) {
        respond ingredienteInstance
    }

    def create() {
        respond new Ingrediente(params)
    }

    @Transactional
    def save(Ingrediente ingredienteInstance) {
        if (ingredienteInstance == null) {
            notFound()
            return
        }

        if (ingredienteInstance.hasErrors()) {
            respond ingredienteInstance.errors, view:'create'
            return
        }

        ingredienteInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ingrediente.label', default: 'Ingrediente'), ingredienteInstance.id])
                redirect ingredienteInstance
            }
            '*' { respond ingredienteInstance, [status: CREATED] }
        }
    }

    def edit(Ingrediente ingredienteInstance) {
        respond ingredienteInstance
    }

    @Transactional
    def update(Ingrediente ingredienteInstance) {
        if (ingredienteInstance == null) {
            notFound()
            return
        }

        if (ingredienteInstance.hasErrors()) {
            respond ingredienteInstance.errors, view:'edit'
            return
        }

        ingredienteInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Ingrediente.label', default: 'Ingrediente'), ingredienteInstance.id])
                redirect ingredienteInstance
            }
            '*'{ respond ingredienteInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Ingrediente ingredienteInstance) {

        if (ingredienteInstance == null) {
            notFound()
            return
        }

        ingredienteInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Ingrediente.label', default: 'Ingrediente'), ingredienteInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ingrediente.label', default: 'Ingrediente'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
