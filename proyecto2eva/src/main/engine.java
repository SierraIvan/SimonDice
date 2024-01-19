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
		Rojo, Verde, Azul, Dorado
	}

	/**
	 * array donde se guardan los colores y numero fijo de numero maximo de
	 * secuencia
	 */
	static int MAX_COLORES_SEQ = 4;
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
		default:
			System.out.println("Color incorrecto");
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
		}

		return numeros;
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
			int aleatorio = random.nextInt(0, 4);
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
	private void menu() {
		System.out.println("1 - Salir || 2 - jugar");

		char menu = new Scanner(System.in).next().charAt(0);

		if (menu == '1') {
			System.out.println("Saliste con exito");
			System.exit(0);
		} else if (menu == '2') {
			play();
		} else {
			System.out.println("Opcion no disponible");
			menu();
		}
	}

	/**
	 * metodo de inicio del juego
	 */
	public void start() {

		System.out.println("Welcome to Simon dice");
		System.out.println("What is you name? ");
		Scanner nombrejugador = new Scanner(System.in);
		String nombre = nombrejugador.nextLine();
		System.out.println("Hello " + nombre);
		menu();
	}
	
		
	/**
	 * metodo de funcionamiento del juego
	 */
	private void play() {

		generarSecuencia(12);

		for (int i = 0; i < MAX_COLORES_SEQ - 2; i++) {

			System.out.println("Presiona ENTER jugar...	");
			new Scanner(System.in).nextLine();
			for (int k = 0; k < 30; k++) {
				System.out.println();
			}
			mostrarSecuencia(3 + i);
			System.out.println();

			int numerosecuencia = i + 1;

			System.out.println("Presiona ENTER cuando memorices la secuencia " + numerosecuencia);
			new Scanner(System.in).nextLine();

			for (int k = 0; k < 30; k++) {
				System.out.println();
			}

			System.out.println("Introduce la secuencia");

			for (int j = 0; j < 3 + i; j++) {
				System.out.println("Introduce el color en la posición " + (j + 1) + ": ");
				char ColorUsuario = new Scanner(System.in).next().charAt(0);
				tColores colorSeleccionado = charToColores(ColorUsuario);

				if (comprobarColor(j, colorSeleccionado)) {
					System.out.println("¡Correcto!");
				} else {
					System.out.println("Incorrecto");
					menu();
				}
				
			}
			if (i == MAX_COLORES_SEQ - 3) {
				System.out.println("Has ganado, eres una fiera");
			}
		}

	}
}