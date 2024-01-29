package main;

public class jugador {
	/**
	 * Simon dice, proyecto 2ªEVA
	 * @author Ivan Sierra Perez
	 */

		
		public String nombre;
		public static int puntuacion;
		
		public jugador(String nombre) {
			this.nombre = nombre;
		}


		public String getNombre() {
			return "Bienvenido " + this.nombre;
		}
		
		public static String getPuntuacion() {
			return "tienes un total de " + jugador.puntuacion + " puntos";
		}
	
	
}
