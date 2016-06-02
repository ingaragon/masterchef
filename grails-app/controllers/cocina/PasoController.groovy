package cocina



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PasoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Paso.list(params), model:[pasoInstanceCount: Paso.count()]
    }

    def show(Paso pasoInstance) {
        respond pasoInstance
    }

    def create() {
        respond new Paso(params)
    }

    @Transactional
    def save(Paso pasoInstance) {
        if (pasoInstance == null) {
            notFound()
            return
        }

        if (pasoInstance.hasErrors()) {
            respond pasoInstance.errors, view:'create'
            return
        }

        pasoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'paso.label', default: 'Paso'), pasoInstance.id])
                redirect pasoInstance
            }
            '*' { respond pasoInstance, [status: CREATED] }
        }
    }

    def edit(Paso pasoInstance) {
        respond pasoInstance
    }

    @Transactional
    def update(Paso pasoInstance) {
        if (pasoInstance == null) {
            notFound()
            return
        }

        if (pasoInstance.hasErrors()) {
            respond pasoInstance.errors, view:'edit'
            return
        }

        pasoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Paso.label', default: 'Paso'), pasoInstance.id])
                redirect pasoInstance
            }
            '*'{ respond pasoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Paso pasoInstance) {

        if (pasoInstance == null) {
            notFound()
            return
        }

        pasoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Paso.label', default: 'Paso'), pasoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'paso.label', default: 'Paso'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
