package sistemaasistencias

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory
import java.time.LocalDate

@Integration
@Rollback
class SemanaServiceSpec extends Specification {

    SemanaService semanaService
    SessionFactory sessionFactory

    private Long setupData() {
        def fechaInicio = LocalDate.now()
        new Semana(fechaInicio.minusDays(7) ,Cuatrimestre.PrimerCuatrimestre).save(flush: true, failOnError: true)
        new Semana(fechaInicio.minusDays(14),Cuatrimestre.PrimerCuatrimestre).save(flush: true, failOnError: true)
        Semana semana = new Semana(fechaInicio.minusDays(21), Cuatrimestre.CursoDeVerano).save(flush: true, failOnError: true)
        new Semana(fechaInicio.minusDays(28), Cuatrimestre.SegundoCuatrimestre).save(flush: true, failOnError: true)
        new Semana(fechaInicio.minusDays(35), Cuatrimestre.SegundoCuatrimestre).save(flush: true, failOnError: true)
        semana.id
    }

    void "test get"() {
        setupData()

        expect:
        semanaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Semana> semanaList = semanaService.list(max: 2, offset: 2)

        then:
        semanaList.size() == 2
    }

    void "test count"() {
        setupData()

        expect:
        semanaService.count() == 5
    }

    void "test delete"() {
        Long semanaId = setupData()

        expect:
        semanaService.count() == 5

        when:
        semanaService.delete(semanaId)
        sessionFactory.currentSession.flush()

        then:
        semanaService.count() == 4
    }

    void "test save"() {
        when:
        Semana semana = new Semana(LocalDate.now(), Cuatrimestre.PrimerCuatrimestre)
        semanaService.save(semana)

        then:
        semana.id != null
    }
}
