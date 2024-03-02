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
	    jugador temp;
	    for (int i = 0; i < jugadores.length; i++) {
	        for (int j = 0; j < jugadores.length - i - 1; j++) {
	            if (jugadores[j].getPuntuacion(puntuacion) >= jugadores[j + 1].getPuntuacion(puntuacion)) {
	                temp = jugadores[j + 1];
	                jugadores[j + 1] = jugadores[j];
	                jugadores[j] = temp;
	            }
	        }
	    }
	}

	public void showranking() {
	    for (int i = 0; i < cont; i++) {
	        System.out.println(jugadores[i].getNombre() + " " + jugadores[i].getPuntuacion(puntuacion));
	    }
	}

	public void showbestplay() {

		System.out.println(jugadores[0].getNombre() + " " + jugadores[0].getPuntuacion(puntuacion));
			
		

	}

}// metodo start, primero se añade el jugador al array jugadores y luego se elige
	// el modo