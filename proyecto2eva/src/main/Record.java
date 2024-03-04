package main;

public class Record {
	private int cont = 0;;
	private int MAX_JUGADORES = 10;

	private jugador[] jugadores = new jugador[MAX_JUGADORES];
	jugador jugador;
	int puntuacion;

	public Record(jugador nombre, int puntuacion) {
		engine engine = new engine();
		this.jugador = nombre;
		this.puntuacion = engine.puntuacion;
	}

	public void buscarjugador(String jugador) {

		for (int i = 0; i < jugadores.length; i++) {
			System.out.println(jugadores[i]);

		}

	}

	public void anadirjugador(jugador jugador) {

		jugadores[cont] = jugador;
		// System.out.println(jugadores[cont].getNombre());
		this.cont++;

	}
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

	public void showranking() {
		ordenarranking();
	    for (int i = 0; i < cont; i++) {
	        System.out.println(jugadores[i].getNombre() + " " + jugadores[i].getPuntuacion());
	    }
	}

	public void showbestplay() {
		ordenarranking();
		System.out.println(jugadores[0].getNombre() + " " + jugadores[0].getPuntuacion());
		for(int i = 0; i < cont - 1;i++) {
		if(jugadores[0].getPuntuacion() == jugadores[i + 1].getPuntuacion()) {
		System.out.println(jugadores[i + 1].getNombre() + " " + jugadores[i + 1].getPuntuacion());
		}
			
		}
		
			
		

	}

}// metodo start, primero se añade el jugador al array jugadores y luego se elige
	// el modo