package sistemaasistencias

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import java.time.LocalDate

class SemanaSpec extends Specification implements DomainUnitTest<Semana> {

    def setup() {
    }

    def cleanup() {
    }

    def "al dar de alta la semana con una fecha inicial, la fecha fin se llena con la fecha correspondiente a 6 dias en el futuro"() {
    	given: "una semana inicializada con fecha"
    		def semana = new Semana(LocalDate.of(2019, 01, 01), Cuatrimestre.CursoDeVerano)

    	when: ""

    	then: "la fecha final es seis dias despues"
    		semana.fechaInicial.dayOfMonth + 6 == semana.fechaFinal.dayOfMonth
    }
}
