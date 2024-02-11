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

	/**
	 * enum de los modos que se usa
	 */
	enum tModo {
		Facil, Dificil
	}

	/**
	 * variables inicializadas ya que se usan en mas de 1 metodo
	 */
	static int MAX_COLORES_SEQ = 15;
	static final int MAX_COLORES_FACIL = 4;
	static final int MAX_COLORES_DIFICIL = 7;
	static int puntuacion = 0;
	static int pistas = 3;
	static int puntuar;

	/**
	 * array donde se guardan los colores y numero fijo de numero maximo de
	 * secuencia
	 */

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
	public tColores intToColor(int _numero) {
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

	/**
	 * metodo para elegir el modo que esta activo en el juego
	 * 
	 * @param _modos
	 * @return
	 */
	public tModo intToModo(int _modos) {
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
	public void generarSecuencia(int _numColores) {

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

		char menu;

		do {
			System.out.println("\n1 - Salir || 2 - jugar modo facil || 3 - jugar modo dificil");

			menu = new Scanner(System.in).next().charAt(0);

			tModo modos = null;
			switch (menu) {
			case '1':
				System.out.println("Saliste con exito");
				break;
			case '2':
				// modos = MAX_COLORES_FACIL;
				generarSecuencia(MAX_COLORES_FACIL);
				puntuar = 1;
				System.out.println("Estas en el Modo Facil");
				play(puntuar);
				break;
			case '3':
				// modos = MAX_COLORES_DIFICIL;
				generarSecuencia(MAX_COLORES_DIFICIL);
				puntuar = 2;
				System.out.println("Estas en el Modo Dificil");
				play(puntuar);
				break;
			default:
				System.out.println("Opcion no disponible, introduce un numero valido (1-3)");
			}

		} while (menu != '1' && menu != '2' && menu != '3');

	}

	/**
	 * metodo que nos devuelve true si pistas es mayor que 0 y false si es lo
	 * contrario
	 * 
	 * @param _index
	 * @return
	 */

	public boolean usarAyuda(int _index) {

		_index = pistas;
		if (_index > 0) 
			return true;
		
		return false;

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
	public void play(int puntuar) {

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
			while (j < 1 + i) {
				j++;
				System.out.println("Introduce el color en la posición " + (j + 1) + ": ");
				System.out.println("Introduce 'X' para tener una pista (tienes " + pistas + " pistas)");
				char ColorUsuario = new Scanner(System.in).next().charAt(0);
				tColores colorSeleccionado = charToColores(ColorUsuario);

				do {
					if (ColorUsuario != 'x' && ColorUsuario != 'X') {

						if (comprobarColor(j, colorSeleccionado)) {
							System.out.println("¡Correcto!");
							puntuacion = puntuacion + (2 * puntuar);
						} else {
							jugador.puntuacion = puntuacion;
							System.out.println("Incorrecto, has perdido, mas suerte la proxima vez");
							System.out.println("\n" + jugador.getPuntuacion(jugador.nombre));
							menu();
						}
					} else {
						usarAyuda(pistas);
						if (usarAyuda(0) == true) {
							System.out.println("El color es: " + secuenciaColores[j]);
							pistas--;
							if (puntuacion < (8 * puntuar)) {
								puntuacion = 0;
							} else {
								puntuacion = puntuacion - (8 * puntuar);
							}
						} else if (usarAyuda(0) == false) {
							System.out.println("no tienes mas pistas");
							j--;
						}
					}
				} while (pistas < 0);

				if (j == i + 1) {
					puntuacion = puntuacion + (5 * puntuar);
				}
				if (i == secuenciaColores.length - 3) {
					System.out.println("Has ganado, eres una fiera");
					puntuacion = puntuacion + (40 * puntuar);
					jugador.puntuacion = puntuacion;
					System.out.println(jugador.getPuntuacion(jugador.nombre));
				}

			}
		}

	}
}
