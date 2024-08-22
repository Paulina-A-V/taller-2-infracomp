package laboratorios;

public class Maximo {
	
	private int max = -1;
	
	public Maximo() {
		
	}
	
	public synchronized void anotar(int m) {
		if (m > max) {
			max = m;
		}
	}
	
	public synchronized int darmax() {
		return this.max;
	}

}
