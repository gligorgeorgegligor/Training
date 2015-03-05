package autovehicul;

public class Rezervor {
	
	public double capacitMax;
	public double combustibilDisp;


	public Rezervor (double capacitMax, double combustibilDisp) {
		this.capacitMax = capacitMax;
		this.combustibilDisp = combustibilDisp;
		
}

	public double getCapacitMax() {
		return capacitMax;
	}

	public void setCapacitMax(double capacitMax) {
		this.capacitMax = capacitMax;
	}

	public double getCombustibilDisp() {
		return combustibilDisp;
	}

	public void setCombustibilDisp(double combustibilDisp) {
		this.combustibilDisp = combustibilDisp;
	}
}