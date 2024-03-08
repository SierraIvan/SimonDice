package main;

/**
 * Simon dice, proyecto 2ªEVA
 * 
 * @author Ivan Sierra Perez
 */

public class Record {
	int cont;
	int MAX_JUGADORES;
	Jugador[] jugadores;

	public Record() {
		this.cont = 0;
		this.MAX_JUGADORES = 10;
		this.jugadores = new Jugador[MAX_JUGADORES];
	}

	/**
	 * metodo para añadir un jugador al array jugadores
	 * 
	 * @param jugador
	 */
	public void anadirjugador(Jugador jugador) {

		// se muestran los primeros jugadores leidos, depediendo de MAX_JUGADORES
		if(this.cont < this.MAX_JUGADORES) {
			this.jugadores[cont] = jugador;
			this.cont++;
		} 
		

//se sustituye el jugador con menos puntuacion por un jugador nuevo
		/*
		 * if(cont == MAX_JUGADORES) { ordenarranking(); jugadores[cont - 1] = jugador;
		 * }else {
		 * 
		 * jugadores[cont] = jugador;
		 * 
		 * this.cont++; }
		 */
	}

	/**
	 * metodo para ordenar el ranking de forma descendiente
	 */
	public void ordenarranking() {
		for (int i = 0; i < this.cont; i++) {
			for (int j = 0; j < (this.cont - i - 1); j++) {
				if (this.jugadores[j].getPuntuacion() < this.jugadores[j + 1].getPuntuacion()) {
					Jugador temp = this.jugadores[j + 1];
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
		if (this.cont > this.MAX_JUGADORES) {
			this.cont = this.MAX_JUGADORES;
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
		do {
			if (jugadores[0].getPuntuacion() == jugadores[i + 1].getPuntuacion()) {
				System.out.println(jugadores[i + 1].getNombre() + " " + jugadores[i + 1].getPuntuacion());
			}
			i++;
		} while (jugadores[0].getPuntuacion() <= jugadores[i + 1].getPuntuacion());
	}
}
