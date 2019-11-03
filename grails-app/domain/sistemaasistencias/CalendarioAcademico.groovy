package sistemaasistencias

class CalendarioAcademico {
	long anio
	Periodo primerCuatrimestre
	Periodo segundoCuatrimestre
	
	public CalendarioAcademico() {
		anio = 0
		primerCuatrimestre  = Periodo.vacio()
		segundoCuatrimestre = Periodo.vacio()
	}

	static embedded = [
		'primerCuatrimestre',
		'segundoCuatrimestre',
	]

    static constraints = {
    	anio nullable:false
    }
}
