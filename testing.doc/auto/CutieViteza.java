package autovehicul;

public class CutieViteza {

	private int nrViteze;
	private int treaptaCurenta;
	private String producator;
	private double serie;

	
	public CutieViteza(int nrViteze, int treaptaCurenta, String producator, double serie) {
		this.nrViteze = nrViteze;
		this.treaptaCurenta = treaptaCurenta;
		this.producator = producator;
		this.serie = serie;
}

	public int getNrViteze() {
		return nrViteze;
	}

	public void setNrViteze(int nrViteze) {
		this.nrViteze = nrViteze;
	}

	public int getTreaptaCurenta() {
		return treaptaCurenta;
	}

	public void setTreaptaCurenta(int treaptaCurenta) {
		this.treaptaCurenta = treaptaCurenta;
	}

	public String getProducator() {
		return producator;
	}

	public void setProducator(String producator) {
		this.producator = producator;
	}

	public double getSerie() {
		return serie;
	}

	public void setSerie(double serie) {
		this.serie = serie;
	}
}