public class Main {
	private static Pastelero pastelero;
	private static Cliente cliente;
	private static Pastel pastel;

	public static void main(String[] args) {
		pastel = new Pastel();
		pastelero = new Pastelero(pastel);
		cliente = new Cliente(pastel);
		pastelero.start();
		cliente.start();
	}
}