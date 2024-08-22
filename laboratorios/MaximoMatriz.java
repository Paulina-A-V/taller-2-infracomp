package laboratorios;

import java.util.concurrent.ThreadLocalRandom;

public class MaximoMatriz extends Thread {
	private final static int INT_MAX = 1053345;
	
	private final static int DIM = 3;
	
	//Matriz
	private static int[][] matriz = new int[DIM][DIM];
	
	//Mayor global 
	private static int mayor = -1;
	
	//mayor local 
	private int mayorFila = -1;
	
	//ID Thread
	private int idThread;
	
	//Fila a registrar
	private int fila;
	
	//contructor
	public MaximoMatriz(int pIdThread, int pFila) {
		this.idThread = pIdThread;
		this.fila = pFila;
	}
	
	//Generar la matriz con números aleatorios
	public static void crearMatriz() {
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
					matriz[i][j] = ThreadLocalRandom.current().nextInt(0, INT_MAX);
				}
			}
			//Imprimir la Matriz
			System.out.println("Matriz:");
			System.out.println("======================");
			imprimirMatriz();
			
		}
		
	//Imprimir la matriz en consola
	private static void imprimirMatriz() {
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	@Override
	public void run() {
		for (int j = 0; j < DIM; j++) {
			if (this.mayorFila < matriz[this.fila][j]) {
				this.mayorFila = matriz[this.fila][j];
			}
		}
		if (this.mayorFila > mayor) {
			try {
				Thread.sleep(250);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		mayor = this.mayorFila;
		String warn = String.format(
				"=======Nuevo maximo encontrado======= \n" +
				"ID Thread: %d - Maximo local actual: %d - maximo global: %d \n" +
				"\n",
				this.idThread,
				mayor,
				this.mayorFila);
		System.out.println(warn);
		
		//resultados
		String msg = String.format("ID Thread: %d - Maximo local actual: %d - maximo global: %d", 
					this.idThread,
					this.mayorFila,
					mayor);
		System.out.println(msg);
	}
	
	//Main
	public static void main(String[] args) {
		System.out.println("Busqueda concurrente por una matriz");
		
		//Iniciar la matriz
		MaximoMatriz.crearMatriz();
		System.out.println();
		System.out.println("Iniciando la busqueda por la matriz \n");
		
		//Iniciar busqueda
		MaximoMatriz[] bThreads = new MaximoMatriz[DIM];
		for (int i = 0; i < DIM; i++) {
			bThreads[i] = new MaximoMatriz(i, i);
			bThreads[i].start();
		}
		
	}
	
}
