package main;

public class jugador {
	/**
	 * Simon dice, proyecto 2ªEVA
	 * @author Ivan Sierra Perez
	 */

		
		public String nombre;
		public int puntuacion;
		
		public jugador(String nombre, int puntuacion) {
			this.nombre= nombre;
			this.puntuacion = puntuacion;
		}


		public String getNombre() {
			return "Bienvenido " + this.nombre;
		}
		
		public int getPuntuacion() {
			return this.puntuacion;
		}
	
	
}
