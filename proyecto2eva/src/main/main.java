package main;

import java.util.Random;
import java.util.Scanner;

public class main {

	
	enum tColores{Rojo,Verde,Azul,Dorado}
	
	tColores[] secuenciaColores = new tColores[12];
	

	/*Para generar la secuencia de colores aleatoria*/
	public void generarSecuencia(int _numColores) {
		Random aleatorio = new Random();
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 tColores R = tColores.Rojo;
		 tColores V = tColores.Verde;
		 tColores A = tColores.Azul;
		 tColores D = tColores.Dorado;
		
		

		
		System.out.println("Welcome to Simon dice");
		System.out.println("What is you name? ");
		Scanner nombrejugador = new Scanner(System.in);
		String nombre = nombrejugador.nextLine();
		System.out.println("Hello " + nombre + ", press ENTER to start playing");
		
		

		System.out.println(R + " --- " + D);
		Scanner colores = new Scanner(System.in);
		char color = colores.next().charAt(0);
		char color2= colores.next().charAt(0);
		
		if(color == 'R') {
			if(color2 == 'D') {
				System.out.println("Ganaste");
			}else {
				System.out.println("Perdiste");
			}
		}else {
			System.out.println("Perdiste");
		}
		
	}
	
	

}
