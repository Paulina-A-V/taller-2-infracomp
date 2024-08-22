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
		pastel.hacerPedido(1, 1, "fresa", "rojo");
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