package main;

public class jugador {
	/**
	 * Simon dice, proyecto 2ªEVA
	 * @author Ivan Sierra Perez
	 */

		
		public String nombre;
		public int puntuacion;
		
		public jugador(String nombre) {
			this.nombre= nombre;
		}


		public String getNombre() {
			return "Bienvenido " + this.nombre;
		}
		
		public int getPuntuacion() {
			return this.puntuacion;
		}
	
	
}
