package sistemaasistencias

import grails.gorm.services.Service

@Service(CalendarioAcademico)
interface CalendarioAcademicoService {

    CalendarioAcademico get(Serializable id)

    List<CalendarioAcademico> list(Map args)

    Long count()

    void delete(Serializable id)

    CalendarioAcademico save(CalendarioAcademico calendarioAcademico)

}