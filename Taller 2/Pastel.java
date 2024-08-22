public class Pastel {
	private int alto;
	private int radio;
	private String sabor;
	private String color;
	private boolean listo = false;
	
	public Pastel () {
		
	}

	public synchronized void hacerPedido(int alto, int radio, String sabor, String color) {
		this.alto = alto;
		this.radio = radio;
		this.sabor = sabor;
		this.color = color;
		this.listo = true;
	}

	public synchronized void consultarDetallesPedido() {
		System.out.println("Alto: " + this.alto);
		System.out.println("Radio: " + this.radio);
		System.out.println("Sabor: " + this.sabor);
		System.out.println("Color: " + this.color);
	}

	public synchronized boolean consultarEstadoPedido() {
		return listo;
	}
}