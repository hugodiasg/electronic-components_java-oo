package pkgmain;

public class Capacitor extends Basic implements Datasheet{

	// Capacitance and max. Voltage
	private float C, Vmax;
	
	public Capacitor(float C,float Vmax) {
		this.name = "Capacitor";
		this.setC(C);
		this.setVmax(Vmax);
		
		
	}
	
	public Capacitor() {
		this.name = "Capacitor";
	}

	public float getVmax() {
		return Vmax;
	}

	public void setVmax(float vmax) {
		Vmax = vmax;
	}

	public float getC() {
		return C;
	}

	public void setC(float c) {
		C = c;
	}
	
	@Override
	public String getInformation() {
		return "Type: "+this.getName()+
				", C: "+this.getC()+
				" F, Vmax: "+this.getVmax()+" V.";
	}
}
