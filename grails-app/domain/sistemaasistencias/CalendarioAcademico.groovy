package sistemaasistencias

class CalendarioAcademico {
	long anio
	Set<Semana> semanas

	public CalendarioAcademico() {
		semanas = []
		anio = 0
	}
	static hasMany = [
		semanas: Semana
	]

    static constraints = {
    }
}
