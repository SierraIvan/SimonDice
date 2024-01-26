package main;

import java.util.Random;
import java.util.Scanner;

/**
 * Simon dice, proyecto 2ªEVA
 * 
 * @author Ivan Sierra Perez
 */

public class engine {

	/**
	 * enum inicial de los colores con los que se va ha jugar
	 */
	enum tColores {
		Rojo, Verde, Azul, Dorado, Blanco, Marron, Naranja
	}

	enum tModo {
		Facil, Dificil
	}

	/**
	 * array donde se guardan los colores y numero fijo de numero maximo de
	 * secuencia
	 */
	static int MAX_COLORES_SEQ = 15;
	static final int MAX_COLORES_FACIL = 4;
	static final int MAX_COLORES_DIFICIL = 7;

	static tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];

	/**
	 * metodo que proporcionamos la primera letra de cada color y nos devuelve un
	 * color del enum tColores
	 * 
	 * @param _colores
	 * @return
	 */
	private tColores charToColores(char _colores) {
		tColores eleccion = null;
		char letraColores = Character.toLowerCase(_colores);
		switch (letraColores) {
		case 'r':
			eleccion = tColores.Rojo;
			break;
		case 'v':
			eleccion = tColores.Verde;
			break;
		case 'a':
			eleccion = tColores.Azul;
			break;
		case 'd':
			eleccion = tColores.Dorado;
			break;
		case 'b':
			eleccion = tColores.Blanco;
			break;
		case 'm':
			eleccion = tColores.Marron;
			break;
		case 'n':
			eleccion = tColores.Naranja;
			break;
		default:

		}
		return eleccion;
	}

	/**
	 * metodo que proporcionamos un numero (aleatorio) de 0 a 3 incuidos, y nos
	 * devuleve un color del enum tColores
	 * 
	 * @param _numero
	 * @return
	 */
	private tColores intToColor(int _numero) {
		tColores numeros = null;
		switch (_numero) {
		case 0:
			numeros = tColores.Rojo;
			break;
		case 1:
			numeros = tColores.Verde;
			break;
		case 2:
			numeros = tColores.Azul;
			break;
		case 3:
			numeros = tColores.Dorado;
			break;
		case 4:
			numeros = tColores.Blanco;
			break;
		case 5:
			numeros = tColores.Marron;
			break;
		case 6:
			numeros = tColores.Naranja;
			break;
		}

		return numeros;
	}

	private tModo intToModo(int _modos) {
		tModo modos = null;
		switch (_modos) {
		case 1:
			modos = tModo.Facil;
			break;
		case 2:
			modos = tModo.Dificil;
			break;
		}
		return modos;
	}

	/**
	 * metodo para generar un array con numeros aleatorios que funciona con el
	 * metodo anterior
	 * 
	 * @param _numColores
	 */
	private void generarSecuencia(int _numColores) {

		for (int i = 0; i < secuenciaColores.length; i++) {
			Random random = new Random();
			int aleatorio = random.nextInt(0, _numColores);
			secuenciaColores[i] = intToColor(aleatorio);
		}
	}

	/**
	 * metodo para comprobar si el usuario ha acertado el color
	 * 
	 * @param _index sirve para comprobar el array de color
	 * @param _color
	 * @return
	 */
	private boolean comprobarColor(int _index, tColores _color) {

		return secuenciaColores[_index] == _color;

	}

	/**
	 * metodo para mostar la secuencia
	 * 
	 * @param _numero
	 */
	private void mostrarSecuencia(int _numero) {

		for (int i = 0; i < _numero; i++) {
			System.out.print(secuenciaColores[i] + " ");
		}
	}

	/**
	 * metodo para mostrar el menu de inicio
	 */
	
	
	public void menu() {

		char menu;
	    do {
	        System.out.println("1 - Salir || 2 - jugar modo facil || 3 - jugar modo dificil");
	        menu = new Scanner(System.in).next().charAt(0);

	        tModo modos = null;
			switch (menu) {
			case '1':
				System.out.println("Saliste con exito");
				System.exit(0);
				break;
			case '2':
				//modos = MAX_COLORES_FACIL;
				generarSecuencia(MAX_COLORES_FACIL);
				play();
				break;
			case '3':
				//modos = MAX_COLORES_DIFICIL;
				generarSecuencia(MAX_COLORES_DIFICIL);
				play();
				break;
			default:
				System.out.println("Opcion no disponible");
			}
	        

	    } while (menu != '1' && menu != '2' && menu != '3');
	}

	/**
	 * metodo de inicio del juego
	 */
	public void start() {
		Scanner nombre = new Scanner(System.in);
		System.out.println("Bienvenido a Simon dice");
		System.out.println("Como te llamas ");
		jugador nombrejugador = new jugador(nombre.nextLine());
		System.out.println(nombrejugador.getNombre());
		menu();
		nombre.close();

	}

	/**
	 * metodo de funcionamiento del juego
	 */
	private void play() {
		int pistas = 3;
		int i = 0;
		while (i < secuenciaColores.length - 2) {
			 i++;
			System.out.println("Presiona ENTER jugar...	");
			new Scanner(System.in).nextLine();
			for (int k = 0; k < 30; k++) {
				System.out.println();
			}
			mostrarSecuencia(2 + i);
			System.out.println();

			System.out.println("Presiona ENTER cuando memorices la secuencia " + i);
			new Scanner(System.in).nextLine();

			for (int k = 0; k < 30; k++) {
				System.out.println();
			}

			System.out.println("Introduce la secuencia");

			int j = -1;
			while(j < 1 + i) {
				j++;
				System.out.println("Introduce el color en la posición " + (j + 1) + ": ");
				System.out.println("Introduce 'X' para tener una pista (tienes " + pistas + " pistas)");
				char ColorUsuario = new Scanner(System.in).next().charAt(0);
				tColores colorSeleccionado = charToColores(ColorUsuario);

				do {
				if (ColorUsuario != 'x') {

					if (comprobarColor(j, colorSeleccionado)) {
						System.out.println("¡Correcto!");
					} else {
						System.out.println("Incorrecto");
						menu();
					}
				} else if (pistas > 0) {
					
					System.out.println(secuenciaColores[j]);
					pistas--;
				}else if(pistas == 0) {
					System.out.println("no tienes mas pistas");
					j--;
				}
				
				}while(pistas < 0);

			
			if (i == secuenciaColores.length - 3) {
				System.out.println("Has ganado, eres una fiera");
			}
			
		}
	}

	}
}
