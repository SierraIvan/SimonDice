package main;

import java.util.Random;
import java.util.Scanner;

public class main {

	
	enum tColores{Rojo,Verde,Azul,Dorado}
	int MAX_COLORES_SEQ = 12;
	tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];
	
	

	public static tColores charColores (char _colores) {
		tColores eleccion = null;
		char letraColores;
		switch (letraColores){
		case 'R':
			eleccion=tColores.Rojo;
			break;
		case 'V':
			eleccion=tColores.Verde;
			break;
		case 'A':
			eleccion=tColores.Azul;
			break;
		case 'D':
			eleccion=tColores.Dorado;
			break;
		default:
			System.out.println("Color incorrecto");
		}
		return eleccion;
	}
	
	
	/*Para generar la secuencia de colores aleatoria*/
	public void generarSecuencia(int _numColores) {
		Random aleatorio = new Random();
		int i = secuenciaColores[aleatorio];
		
		
	}
	
	
	
	public void mostrarSecuencia (){
		
	}
	
	public boolean comprobarColor() {
		
	}
	

	public void play() {
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		

		
	
		
		
		System.out.println("Welcome to Simon dice");
		System.out.println("What is you name? ");
		Scanner nombrejugador = new Scanner(System.in);
		String nombre = nombrejugador.nextLine();
		System.out.println("Hello " + nombre + ", press ENTER to start playing");
		
		
		
	}
	
	

}
