package autovehicul;



public class Autovehicul {
	
	private String color;
	private double serieSasiu;
	private double km;
	private String marca;
	private double vitezaCurenta;

	public Autovehicul(String color, double serieSasiu, double km, String marca, double vitezaCurenta) {
		this.color = color;
		this.serieSasiu = serieSasiu;
		this.km = km;
		this.marca = marca;
		this.vitezaCurenta = vitezaCurenta;
	}
	
	public boolean verificareRoti(){
		
		if (getPresiuneaAnvelope() == getPresiuneaIdeala()){
			
				return true;
			else
				return false;
		}
		
	}
	
	public double alimenteaza (double x){
		Rezervor r =  new Rezervor(10, 2);
		x =	r.getCapacitMax() - r.getCombustibilDisp();
		return x;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getSerieSasiu() {
		return serieSasiu;
	}

	public void setSerieSasiu(double serieSasiu) {
		this.serieSasiu = serieSasiu;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getVitezaCurenta() {
		return vitezaCurenta;
	}

	public void setVitezaCurenta(double vitezaCurenta) {
		this.vitezaCurenta = vitezaCurenta;
	}
	
}
