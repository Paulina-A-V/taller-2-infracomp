import java.util.Scanner;

public class Cliente extends Thread {
	private Pastel pastel;

	public Cliente(Pastel pastel) {
		this.pastel = pastel;
	}

	public void run() {
		this.hacerPedido();
		this.esperarPastel();
	}

	private void hacerPedido() {
		System.out.println("Haciendo pedido");
		Scanner scanner = new Scanner(System.in);
		
		int alto, radio;
		
		String sabor,color;
		
		System.out.println("Introdusca el alto del pastel: ");
		alto = scanner.nextInt();
		
		System.out.println("Introdusca el radio del pastel: ");
		radio = scanner.nextInt();
		
		System.out.println("Introdusca el sabor del pastel: ");
		sabor = scanner.next();
		
		System.out.println("Introdusca el color del pastel: ");
		color = scanner.next();
		
		pastel.hacerPedido(alto, radio, sabor, color);
	}

	private void esperarPastel() {
		System.out.println("Esperando pastel");
		synchronized (pastel) {
			try {
				pastel.wait();
			} catch (InterruptedException e) {}
		}
	}


}