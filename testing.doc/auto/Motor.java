package autovehicul;

public class Motor {
	
	private int cilindree;
	private String serieMotor;
	private int turatiiCurente;
	private String tipCombustibil;
	private boolean stare;

	public Motor(int cilindree, String serieMotor, int turatiiCurente, String tipCombustibil, boolean stare) {
		this.cilindree = cilindree;
		this.serieMotor = serieMotor;
		this.turatiiCurente = turatiiCurente;
		this.tipCombustibil = tipCombustibil;
		this.stare = stare;
	}

	public int getCilindree() {
		return cilindree;
	}

	public void setCilindree(int cilindree) {
		this.cilindree = cilindree;
	}

	public String getSerieMotor() {
		return serieMotor;
	}

	public void setSerieMotor(String serieMotor) {
		this.serieMotor = serieMotor;
	}

	public int getTuratiiCurente() {
		return turatiiCurente;
	}

	public void setTuratiiCurente(int turatiiCurente) {
		this.turatiiCurente = turatiiCurente;
	}

	public String getTipCombustibil() {
		return tipCombustibil;
	}

	public void setTipCombustibil(String tipCombustibil) {
		this.tipCombustibil = tipCombustibil;
	}

	public boolean isStare() {
		return stare;
	}

	public void setStare(boolean stare) {
		this.stare = stare;
	}
}
