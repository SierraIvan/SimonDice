package main;

/**
 * Simon dice, proyecto 2ªEVA
 * 
 * @author Ivan Sierra Perez
 */
public class jugador {

	public static String nombre;
	public static int puntuacion;

	public jugador(String nombre, int puntuacion) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
	}


	/**
	 * Nos devuelve un mensaje junto al nombre del jugador
	 * 
	 * @return
	 */
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String setNombre() {
		return "Bienvenido " + this.nombre;
	}

	public int setPuntuacion(int puntuacion) {
		return this.puntuacion;
	}
	
	/**
	 * Nos devuelve un mensaje junto a la puntuacion del jugador
	 * 
	 * @return
	 */
	public static String getPuntuacion(String nombre) {
		return nombre + " consiguió un total de " + jugador.puntuacion + " puntos\n";
	}
	
}