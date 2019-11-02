package sistemaasistencias
import java.time.LocalDate

class Semana {
	LocalDate fechaInicial
	LocalDate fechaFinal
	Cuatrimestre cuatrimestre

	public Semana() {}
	public Semana(LocalDate fechaInicial, Cuatrimestre cuatrimestre) {
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaInicial.plusDays(6);
		this.cuatrimestre = cuatrimestre;
	}

    static constraints = {
    }
}
