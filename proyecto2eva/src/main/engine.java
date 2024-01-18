package main;

import java.util.Random;
import java.util.Scanner;

/**
 * Simon dice, proyecto 2ªEVA
 * @author Iván Sierra Pérez
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
	static int MAX_COLORES_SEQ = 12;
	static tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];

	/**
	 * metodo que proporcionamos la primera letra de cada color y nos devuelve un
	 * color del enum tColores
	 * 
	 * @param _colores
	 * @return
	 */
	public tColores charToColores(char _colores) {
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
	public void generarSecuencia(int _numColores) {

		int limite = MAX_COLORES_SEQ - 1;
		for (int i = 0; i < secuenciaColores.length; i++) {
			Random random = new Random();
			int aleatorio = random.nextInt(0, 4);
			secuenciaColores[i] = intToColor(aleatorio);
		}
	}

	/**
	 * metodo para comprobar si el usuario ha acertado el color
	 * 
	 * @param _index
	 * @param _color
	 * @return
	 */
	public boolean comprobarColor(int _index, tColores _color) {

		return secuenciaColores[_index] == _color;

	}

	/**
	 * metodo para mostar la secuencia
	 * 
	 * @param _numero
	 */
	public void mostrarSecuencia(int _numero) {

		for (int i = 0; i < _numero; i++) {
			System.out.print(secuenciaColores[i] + " ");
		}
	}

	/**
	 * metodo para mostrar el menu de inicio
	 */
	public void menu() {
		System.out.println("1 - Salir || 2 - jugar");
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

		play();
	}
	/**
	 * metodo de funcionamiento del juego
	 */
	public void play() {
		menu();

		Scanner menu = new Scanner(System.in);
		int menus = menu.nextInt();

		if (menus == 1) {
			System.out.println("saliste");
		} else if (menus == 2) {

			generarSecuencia(12);

			for (int i = 0; i < MAX_COLORES_SEQ - 2; i++) {

				System.out.println("Presiona ENTER jugar...	");
				new Scanner(System.in).nextLine();

				for (int k = 0; k < 30; k++) {
					System.out.println();
				}
				mostrarSecuencia(3 + i);
				System.out.println();

				int numsecuencia = i + 1;

				System.out.println("Presiona ENTER cuando memorices la secuencia " + numsecuencia);
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
						System.out.println("Incorrecto. El juego termina.");
						play();
						return;
					}
				}
			}
		} else {
			System.out.println("Opcion no disponible");
		}

	}

}
