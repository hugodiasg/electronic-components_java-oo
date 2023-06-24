package pkgmain;

public class Diode extends Basic implements Datasheet{

	// Max. reverse voltage and max. direct current
	private float Vmax_reverse, Idirect;
	
	public Diode(float Vmax_reverse,float Idirect) {
		this.name = "Diode";
		this.setVmax_reverse(Vmax_reverse);
		this.setIdirect(Idirect);
		
		
	}
	
	public Diode() {
		this.name = "Diode";
	}

	public float getVmax_reverse() {
		return Vmax_reverse;
	}

	public void setVmax_reverse(float vmax_reverse) {
		Vmax_reverse = vmax_reverse;
	}

	public float getIdirect() {
		return Idirect;
	}

	public void setIdirect(float idirect) {
		Idirect = idirect;
	}
	
	@Override
	public String getInformation() {
		return "Type: "+this.getName()+ 
				", Vmax_reverse: "+this.getVmax_reverse()+ 
				" V, Idirect: "+this.getIdirect()+" A";
	}
}
