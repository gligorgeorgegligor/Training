package autovehicul;

public class Roti {

	private double razaJantei;
	private double latimeaJantei;
	private double presiuneaAnvelopa;
	private double presiuneaIdeala;
	private String tipAnvelopa;
	private String modelAnvelopa;

	public Roti(double razaJantei, double latimeaJantei, double presiuneaAnvelopa, double presiuneaIdeala, String tipAnvelopa, String modelAnvelopa) {
		this.razaJantei = razaJantei;
		this.latimeaJantei = latimeaJantei;
		this.presiuneaAnvelopa = presiuneaAnvelopa;
		this.presiuneaIdeala = presiuneaIdeala;
		this.tipAnvelopa = tipAnvelopa;
		this.modelAnvelopa = modelAnvelopa;
}

	public double getRazaJantei() {
		return razaJantei;
	}

	public void setRazaJantei(double razaJantei) {
		this.razaJantei = razaJantei;
	}

	public double getLatimeaJantei() {
		return latimeaJantei;
	}

	public void setLatimeaJantei(double latimeaJantei) {
		this.latimeaJantei = latimeaJantei;
	}

	public double getPresiuneaAnvelopa() {
		return presiuneaAnvelopa;
	}

	public void setPresiuneaAnvelopa(double presiuneaAnvelopa) {
		this.presiuneaAnvelopa = presiuneaAnvelopa;
	}

	public double getPresiuneaIdeala() {
		return presiuneaIdeala;
	}

	public void setPresiuneaIdeala(double presiuneaIdeala) {
		this.presiuneaIdeala = presiuneaIdeala;
	}

	public String getTipAnvelopa() {
		return tipAnvelopa;
	}

	public void setTipAnvelopa(String tipAnvelopa) {
		this.tipAnvelopa = tipAnvelopa;
	}

	public String getModelAnvelopa() {
		return modelAnvelopa;
	}

	public void setModelAnvelopa(String modelAnvelopa) {
		this.modelAnvelopa = modelAnvelopa;
	}
}