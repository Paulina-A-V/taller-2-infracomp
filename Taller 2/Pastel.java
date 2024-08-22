public class Pastel {
	private int alto;
	private int radio;
	private String sabor;
	private String color;
	private boolean listo = false;

	public synchronized void hacerPedido(int alto, int radio, String sabor, String color) {
		this.alto = alto;
		this.radio = radio;
		this.sabor = sabor;
		this.color = color;
		this.listo = true;
	}

	public synchronized String consultarDetallesPedido() {
		return this.alto + " " + this.radio + " " + this.sabor +  " " + this.color;
	}

	public synchronized boolean consultarEstadoPedido() {
		return listo;
	}
}