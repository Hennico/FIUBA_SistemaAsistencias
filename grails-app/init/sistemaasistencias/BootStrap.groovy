package sistemaasistencias

class BootStrap {

    def init = { servletContext ->
    	new CalendarioAcademico([ anio: 2019, primerCuatrimestre: new Periodo((short)11,(short)16), segundoCuatrimestre: new Periodo((short)35, (short)16)]).save()
    }
    def destroy = {
    }
}
