package sistemaasistencias

@grails.gorm.dirty.checking.DirtyCheck
@groovy.transform.EqualsAndHashCode
public class Periodo {
	short semanaInicio
	short semanasDuracion

	public Periodo() {
		semanaInicio = 0
		semanasDuracion = 0
	}
	public Periodo(short inicio, short duracion) {
		semanaInicio = inicio
		semanasDuracion = duracion
	}

	public static Periodo vacio()
	{
		new Periodo()
	}
}