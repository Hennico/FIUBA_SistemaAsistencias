package sistemaasistencias

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CalendarioAcademicoController {

    CalendarioAcademicoService calendarioAcademicoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond calendarioAcademicoService.list(params), model:[calendarioAcademicoCount: calendarioAcademicoService.count()]
    }

    def show(Long id) {
        respond calendarioAcademicoService.get(id)
    }

    def create() {
        respond new CalendarioAcademico(params)
    }

    def save(CalendarioAcademico calendarioAcademico) {
        if (calendarioAcademico == null) {
            notFound()
            return
        }

        try {
            calendarioAcademicoService.save(calendarioAcademico)
        } catch (ValidationException e) {
            respond calendarioAcademico.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'calendarioAcademico.label', default: 'CalendarioAcademico'), calendarioAcademico.id])
                redirect calendarioAcademico
            }
            '*' { respond calendarioAcademico, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond calendarioAcademicoService.get(id)
    }

    def update(CalendarioAcademico calendarioAcademico) {
        if (calendarioAcademico == null) {
            notFound()
            return
        }

        try {
            calendarioAcademicoService.save(calendarioAcademico)
        } catch (ValidationException e) {
            respond calendarioAcademico.errors, view:'edit'
            return
        }

        showValues(calendarioAcademico)

        //request.withFormat {
        //    form multipartForm {
        //        flash.message = message(code: 'default.updated.message', args: [message(code: 'calendarioAcademico.label', default: 'CalendarioAcademico'), calendarioAcademico.id])
        //        redirect calendarioAcademico
        //    }
        //    '*'{ respond calendarioAcademico, [status: OK] }
        //}
    }

    def showValues(CalendarioAcademico calendarioAcademico) {
        redirect action:"calendarioAcademico/show", params: calendarioAcademico
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        calendarioAcademicoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'calendarioAcademico.label', default: 'CalendarioAcademico'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'calendarioAcademico.label', default: 'CalendarioAcademico'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
