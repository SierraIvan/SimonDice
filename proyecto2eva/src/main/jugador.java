package main;

/**
 * Simon dice, proyecto 2ªEVA
 * 
 * @author Ivan Sierra Perez
 */
public class jugador {

	public static String nombre;
	public static int puntuacion;

	public jugador(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Nos devuelve un mensaje junto al nombre del jugador
	 * @return
	 */
	public String getNombre() {
		return "Bienvenido " + this.nombre;
	}

	/**
	 * Nos devuelve un mensaje junto a la puntuacion del jugador
	 * @return
	 */
	public static String getPuntuacion(String nombre) {
		return nombre + " has conseguido un total de " + jugador.puntuacion + " puntos\n";
	}

}
