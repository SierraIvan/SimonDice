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
	private enum tColores {
		Rojo, Verde, Azul, Dorado, Blanco, Marron, Naranja
	}

	/**
	 * enum de los modos que se usa
	 */
	private enum tModo {
		Facil, Dificil
	}

	/**
	 * variables inicializadas ya que se usan en mas de 1 metodo
	 */
	private int MAX_COLORES_SEQ = 4;
	private final int MAX_COLORES_FACIL = 4;
	private final int MAX_COLORES_DIFICIL = 7;
	private int puntuacion = 0;
	private int pistas = 3;
	private int puntuar;
	private tModo modo;
	private boolean fallo = true;

	/**
	 * array donde se guardan los colores y numero fijo de numero maximo de
	 * secuencia
	 */

	private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];

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

		for (int i = 0; i < this.secuenciaColores.length; i++) {
			Random random = new Random();
			int aleatorio = random.nextInt(0, _numColores);
			this.secuenciaColores[i] = intToColor(aleatorio);
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

		return this.secuenciaColores[_index] == _color;

	}

	/**
	 * metodo para mostar la secuencia
	 * 
	 * @param _numero
	 */
	public void mostrarSecuencia(int _numero) {

		for (int i = 0; i < _numero; i++) {
			System.out.print(this.secuenciaColores[i] + " ");
		}
	}

	/**
	 * metodo para mostrar el menu de inicio
	 */

	public void menu() {

		System.out.println(
				"\n1 - Salir || 2 - jugar modo facil || 3 - jugar modo dificil\n4 - Ver 10 mejores jugadores || 5 - Ver jugador con la puntuacion mas alta.");

	}

	/**
	 * metodo que nos devuelve true si pistas es mayor que 0 y false si es lo
	 * contrario
	 * 
	 * @param _index
	 * @return
	 */

	public boolean usarAyuda(int _index) {

		if (_index > 0)
			return true;
		return false;

	}

	/**
	 * metodo de inicio del juego
	 */
	public void start() {
		char menu;
		//do {
		
		Scanner nombre = new Scanner(System.in);
		System.out.println("Bienvenido a Simon dice");
		System.out.println("Como te llamas ");
		jugador jugador = new jugador(nombre.nextLine(), 0);
		System.out.println(jugador.getNombre());
		Record record = new Record(jugador,puntuacion);
		record.anadirjugador(jugador);

		

		 do {
		
			menu();
			menu = new Scanner(System.in).next().charAt(0);

			switch (menu) {
			case '1':
				System.out.println("Saliste con exito");
				break;

			case '2':
				this.modo = tModo.Facil;
				this.puntuar = 1;
				jugador.setPuntuacion(play(tModo.Facil));
				break;
			case '3':
				this.modo = tModo.Dificil;
				this.puntuar = 2;
				jugador.setPuntuacion(play(tModo.Dificil));
				break;
			default:
				System.out.println("introduce un numero valido, 1-3");

			}
		} while (menu != '1');

		// } while (menu != '1' && menu != '2' && menu != '3');

	}

	/**
	 * metodo de funcionamiento del juego
	 */
	public int play(tModo modo) {

		if (this.modo == tModo.Facil) {
			System.out.println("Estas en el Modo Facil");
			generarSecuencia(this.MAX_COLORES_FACIL);
		} else {
			System.out.println("Estas en el Modo Dificil");
			generarSecuencia(this.MAX_COLORES_DIFICIL);
		}
		int i = 0;
		while (i < this.secuenciaColores.length - 2 && this.fallo == true) {
			i++;
			System.out.println("Presiona ENTER jugar...	");
			new Scanner(System.in).nextLine();
			for (int k = 0; k < 1; k++) {
				System.out.println();
			}
			mostrarSecuencia(2 + i);
			System.out.println();

			System.out.println("Presiona ENTER cuando memorices la secuencia " + i);
			new Scanner(System.in).nextLine();

			for (int k = 0; k < 1; k++) {
				System.out.println();
			}

			System.out.println("Introduce la secuencia");

			int j = -1;
			while (j < 1 + i && this.fallo == true) {
				j++;
				System.out.println("Introduce el color en la posición " + (j + 1) + ": ");
				System.out.println("Introduce 'X' para tener una pista (tienes " + this.pistas + " pistas)");
				char ColorUsuario = new Scanner(System.in).next().charAt(0);
				tColores colorSeleccionado = charToColores(ColorUsuario);

				do {
					if (ColorUsuario != 'x' && ColorUsuario != 'X') {

						if (comprobarColor(j, colorSeleccionado)) {
							System.out.println("¡Correcto!");
							this.puntuacion = this.puntuacion + (2 * puntuar);
						} else {
							jugador.puntuacion = this.puntuacion;
							System.out.println("Incorrecto, has perdido, mas suerte la proxima vez");
							System.out.println("\n" + jugador.getPuntuacion(jugador.nombre));
							this.fallo = false;

						}
					} else {
						if (usarAyuda(this.pistas) == true) {
							System.out.println("El color es: " + this.secuenciaColores[j]);
							this.pistas--;
							if (this.puntuacion < (8 * puntuar)) {
								this.puntuacion = 0;
							} else {
								this.puntuacion = this.puntuacion - (8 * puntuar);
							}
						} else if (usarAyuda(pistas) == false) {
							System.out.println("no tienes mas pistas");
							j--;
						}
					}
				} while (pistas < 0);

				if (j == i + 1) {
					this.puntuacion = this.puntuacion + (5 * puntuar);
				}

			}
			if (i == this.secuenciaColores.length - 2) {
				System.out.println("Has ganado, eres una fiera\n ");
				this.puntuacion = this.puntuacion + (40 * puntuar);
				jugador.puntuacion = this.puntuacion;
				System.out.println(jugador.getPuntuacion(jugador.nombre));

			}

		}
		return this.puntuacion;
	}
}
//hacer en la puntuacion algo raro que no tengo muy claro, si hay 2 jugadores con la misma puntuacion maxima, se mostraran los 2 jugadores
//record
//cont va a decir cuantos jugadores tiene el juego
//metodo buscarjugador, que busque en el array de jugadores el jugador con ese nombre, si lo encuentra, retorna un jugador
//metodo ordenarranking tiene que ordenar de forma descendente a la puntuacion
//metodo showranking muestra los n mejores jugadores
//metodo showbestplay muestra el jugador con mas puntos, si hay n con la misma putuacion maxima, muestra los n
