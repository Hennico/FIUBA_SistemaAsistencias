package sistemaasistencias

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CalendarioAcademicoServiceSpec extends Specification {

    CalendarioAcademicoService calendarioAcademicoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        new CalendarioAcademico().save(flush: true, failOnError: true)
        new CalendarioAcademico().save(flush: true, failOnError: true)
        CalendarioAcademico calendarioAcademico = new CalendarioAcademico().save(flush: true, failOnError: true)
        new CalendarioAcademico().save(flush: true, failOnError: true)
        new CalendarioAcademico().save(flush: true, failOnError: true)
        calendarioAcademico.id
    }

    void "test get"() {
        setupData()

        expect:
        calendarioAcademicoService.get(1) != null
    }

    void "test list"() {
        def id = setupData()

        when:
        List<CalendarioAcademico> calendarioAcademicoList = calendarioAcademicoService.list(max: 2, offset: 2)

        then:
        calendarioAcademicoList.size() == 2
    }

    void "test count"() {
        setupData()

        expect:
        calendarioAcademicoService.count() == 5
    }

    void "test delete"() {
        Long calendarioAcademicoId = setupData()

        expect:
        calendarioAcademicoService.count() == 5

        when:
        calendarioAcademicoService.delete(calendarioAcademicoId)
        sessionFactory.currentSession.flush()

        then:
        calendarioAcademicoService.count() == 4
    }

    void "test save"() {
        when:
        CalendarioAcademico calendarioAcademico = new CalendarioAcademico()
        calendarioAcademicoService.save(calendarioAcademico)

        then:
        calendarioAcademico.id != null
    }
}
