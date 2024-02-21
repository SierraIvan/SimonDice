package main;

public class Record {
	private int cont = 0;;
	private int MAX_JUGADORES = 10;

	private jugador[] jugadores = new jugador[MAX_JUGADORES];
	jugador jugador;
	int puntuacion;

	public Record(jugador nombre, int puntuacion) {
		this.jugador = nombre;
		this.puntuacion = puntuacion;
	}

	public void buscarjugador(String jugador) {

		for (int i = 0; i < jugadores.length; i++) {
			System.out.println(jugadores[i]);

		}

	}

	public void anadirjugador(jugador jugador) {		
		jugadores[cont] = jugador;
		System.out.println(jugadores[cont].getNombre());
		cont++;
//		
	}

	/*		public void ordenarranking() {
	int maximo = 0;
		for (int i = 0; i < jugadores.length; i++) {
			if(jugadores[i] > maximo) {
				maximo = jugadores[i];
			}
			

		}
		System.out.println(maximo);
		
	}
*/
	public void showranking() {

	}

	public void showbestplay() {

		
	}

}// metodo start, primero se añade el jugador al array jugadores y luego se elige
	// el modo