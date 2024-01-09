package main;

import java.util.Random;
import java.util.Scanner;

public class main {

	public static final String ROJO = "\u001B[31m";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
	
		play();
	}
	
	enum tColores{Rojo,Verde,Azul,Dorado}
	static int MAX_COLORES_SEQ = 12;
	static tColores[] secuenciaColores = new tColores[4];
	
	

	public static tColores charColores (char _colores) {
		tColores eleccion = null;
		char letraColores = _colores;
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
	
	
	private static tColores intToColor (int _numero) {
		tColores numeros = null;
			switch (_numero) {
			case 0:
				numeros	= tColores.Rojo;
				break;
			case 1:
				numeros = tColores.Verde;
				break;
			case 2:
				numeros	= tColores.Azul;
				break;
			case 3:
				numeros = tColores.Dorado;
				break;
			default:
				System.out.println("ERROR");
			}
			
			return numeros;
	}
	
	
	public static void generarSecuencia(int _numColores) {
		
		int limite = MAX_COLORES_SEQ - 1;
		for (int i = 0; i < secuenciaColores.length; i++) {
			Random random = new Random();
			int aleatorio = random.nextInt(0,3);
            secuenciaColores[i] = intToColor(aleatorio);
        }
		}
			
	
	public boolean comprobarColor(int _index, tColores _color) {
		
		return secuenciaColores[_index] == _color;
		
		
	}
	public static void mostrarSecuencia (int _numero){
	
		for(int i = 0; i < _numero; i++) {
			System.out.print(secuenciaColores[i] + "-");
		}
	}
	

	public static void play() {
		
	
	
		System.out.println("Welcome to Simon dice");
		System.out.println("What is you name? ");
		Scanner nombrejugador = new Scanner(System.in);
		String nombre = nombrejugador.nextLine();
		System.out.println("Hello " + nombre + ", press ENTER to start playing");
		
        
		generarSecuencia(12);
		
		mostrarSecuencia(4);
		
		
		
		
	}
	
	

}
