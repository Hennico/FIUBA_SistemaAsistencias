package sistemaasistencias

@groovy.transform.EqualsAndHashCode
public class Periodo {
	short semanaInicio
	short semanasDuracion

	public Periodo(short inicio, short duracion) {
		this.semanaInicio = inicio
		this.semanasDuracion = duracion
	}

	public static Periodo vacio()
	{
		new Periodo((short)0, (short)0)
	}
}