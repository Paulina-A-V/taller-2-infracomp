package laboratorios;

import java.util.concurrent.ThreadLocalRandom;

import java.util.Scanner;

public class VectorMax extends Thread {
	
	private final static int INT_MAX = 1053345;
	
	private final static int LENGTH= 40;
	
	private static int [] vector = new int[LENGTH];
	
	private static Maximo max = new Maximo();
	
	private static int threads;
	
	private static int n;
	
	private int id;
	
	private int maxl = -1;
	
	public VectorMax(int id) {
		
		this.id = id;
	}
	
	public static void crearVector() {
		for (int i = 0; i < LENGTH; i++) {
			vector[i] = ThreadLocalRandom.current().nextInt(0, INT_MAX);
			}
		
	}
	
	public static void printVector() {
		for (int i = 0; i < LENGTH; i++) {
				System.out.print(vector[i]+ "\t");
		}
			System.out.println();
	}
	
	public void run() {
		if ((id+1)*n <= LENGTH) {
			for (int i = id*(n); i < (id+1)*n;i++) {
				if (vector[i] > maxl) {
					maxl = vector[i];
				}
			}
		}else {
			for (int i = id*(n); i < LENGTH;i++) {
				if (vector[i] > maxl) {
					maxl = vector[i];
				}
			}
		}
		
		max.anotar(maxl);
	}
	
	public static void main(String[] args) {
		System.out.println("Busqueda concurrente por vector");
		
		//iniciar vector
		crearVector();
		printVector();
		
		 Scanner scanner = new Scanner(System.in);
		
		if (args.length < 1) {
			System.out.println("Please provide the number of threads as a parameter.");
			threads = scanner.nextInt();
		}
		
		
		n = LENGTH/threads;
		
		VectorMax[] threadArray = new VectorMax[threads];
		
		for (int id=0; id<threads;id++) {
			threadArray[id] = new VectorMax(id);
			threadArray[id].start();
		}
		
		for (int id = 0; id < threads; id++) {
			try {
				threadArray[id].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Max value found: " + max.darmax());
	}

}
