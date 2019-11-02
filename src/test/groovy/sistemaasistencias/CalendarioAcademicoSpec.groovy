package sistemaasistencias

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CalendarioAcademicoSpec extends Specification implements DomainUnitTest<CalendarioAcademico> {

    def setup() {
    }

    def cleanup() {
    }

    def "Al crear un calendario academico este se crea vacio"() {
    	when: "se crea un calendario"
    		def calendario = new CalendarioAcademico()
    	then: "no tiene semanas asociadas"
    		calendario.semanas.size() == 0
    }

}
