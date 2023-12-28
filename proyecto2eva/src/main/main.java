package main;

import java.util.Scanner;

public class main {

	
	enum Colores{Rojo,Verde,Azul,Dorado}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Colores[] n = new Colores[4];
		 
		 n[0] = Colores.Rojo;
		 n[1] = Colores.Verde;
		 n[2] = Colores.Azul;
		 n[3] = Colores.Dorado;

		
		System.out.println("Welcome to Simon dice");
		System.out.println("What is you name? ");
		Scanner nombrejugador = new Scanner(System.in);
		String nombre = nombrejugador.nextLine();
		System.out.println("Hello " + nombre + ", press ENTER to start playing");
		
		
		int aleatorio = 0;
		aleatorio = (int) (Math.random() * 3);

		System.out.println(n[aleatorio] + " " + n[aleatorio]);

	}
	
	

}
