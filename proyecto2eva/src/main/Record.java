package main;

/**
 * Simon dice, proyecto 2ªEVA
 * 
 * @author Ivan Sierra Perez
 */

public class Record {
	private int cont = 0;
	private int MAX_JUGADORES = 10;

	private jugador[] jugadores = new jugador[MAX_JUGADORES];
	jugador jugador;
	int puntuacion;

	public Record(jugador nombre, int puntuacion) {
		engine engine = new engine();
		this.jugador = nombre;
		this.puntuacion = engine.puntuacion;
	}

	/**
	 * metodo para añadir un jugador al array jugadores
	 * 
	 * @param jugador
	 */
	public void anadirjugador(jugador jugador) {

		jugadores[cont] = jugador;
		// System.out.println(jugadores[cont].getNombre());

		this.cont++;

	}

	/**
	 * metodo para ordenar el ranking de forma descendiente
	 */
	public void ordenarranking() {
		for (int i = 0; i < this.cont; i++) {
			for (int j = 0; j < (this.cont - i - 1); j++) {
				if (this.jugadores[j].getPuntuacion() < this.jugadores[j + 1].getPuntuacion()) {
					jugador temp = this.jugadores[j + 1];
					this.jugadores[j + 1] = this.jugadores[j];
					this.jugadores[j] = temp;
				}
			}
		}
	}

	/**
	 * metodo para mostrar el ranking de los jugadores
	 */
	public void showranking() {
		if (cont > 10) {
			cont = 10;
		}
		ordenarranking();
		for (int i = 0; i < cont; i++) {
			System.out.println(jugadores[i].getNombre() + " " + jugadores[i].getPuntuacion());
		}
	}
	/**
	 * metodo para mostrar el mejor o los mejores jugadores
	 */
	public void showbestplay() {
		ordenarranking();
		int i = 0;
		System.out.println(jugadores[0].getNombre() + " " + jugadores[0].getPuntuacion());
		while (i < cont - 1) {
			if (jugadores[0].getPuntuacion() == jugadores[i + 1].getPuntuacion()) {
				System.out.println(jugadores[i + 1].getNombre() + " " + jugadores[i + 1].getPuntuacion());

			}
			i++;
		}
	}
}