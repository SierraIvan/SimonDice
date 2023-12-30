package main;


import java.util.Scanner;

public class main {

	
	enum tColores{Rojo,Verde,Azul,Dorado}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 tColores[] SecuenciaColores = new tColores[12];
		 
		 tColores R = tColores.Rojo;
		 tColores V = tColores.Verde;
		 tColores A = tColores.Azul;
		 tColores D = tColores.Dorado;
		 
		 
		
		System.out.println("Welcome to Simon dice");
		System.out.println("What is you name? ");
		Scanner nombrejugador = new Scanner(System.in);
		String nombre = nombrejugador.nextLine();
		System.out.println("Hello " + nombre + ", press ENTER to start playing");
		
		
		int aleatorio = 0;
		aleatorio = (int) (Math.random() * 3);

		System.out.println(R + " " + D);
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
