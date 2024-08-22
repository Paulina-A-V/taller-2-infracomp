import java.util.Random;

public class Pastelero extends Thread {
    private static final Random random = new Random();
    private final Pastel pastel;

    public Pastelero(Pastel pastel) {
        this.pastel = pastel;
    }

    @Override
    public void run() {
        revisarPastelPedido();
        hacerPastel();
    }

    private void revisarPastelPedido() {
        while (!pastel.consultarEstadoPedido()) {
            System.out.println("Esperando a que se haga pedido pastel");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
            }
        }
    }

	private void hacerPastel() {
		System.out.println("Haciendo pastel: ");
		pastel.consultarDetallesPedido();
		try {
			Thread.sleep(random.nextInt(10000) + 5000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		synchronized (pastel) {
			pastel.notify();
			System.out.println("El pastel está listo");
		}
	}
	
}
