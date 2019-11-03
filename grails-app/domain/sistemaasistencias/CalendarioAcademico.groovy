package sistemaasistencias

class CalendarioAcademico {
	long anio
	Periodo primerCuatrimestre
	Periodo segundoCuatrimestre


	public CalendarioAcademico() {
		anio = 0
		primerCuatrimestre = Periodo.vacio()
		primerCuatrimestre = Periodo.vacio()
	}


    static constraints = {
    }
}
