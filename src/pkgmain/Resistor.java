package pkgmain;

public class Resistor extends Basic implements Datasheet{
	
	//Resistance in ohms, tolerance in % and potency in watts
	private float R, tolerance_percent, W;
	
	public Resistor(float R,float tolerance_percent,float W) {
		this.name = "Resistor";
		this.setR(R);
		this.setTolerance_percent(tolerance_percent);
		this.setW(W);		
	}
	
	public Resistor() {
		this.name = "Resistor";
	}
	
	public float getR() {
		return R;
	}

	public void setR(float r) {
		R = r;
	}

	public float getW() {
		return W;
	}

	public void setW(float w) {
		W = w;
	}

	public float getTolerance_percent() {
		return tolerance_percent;
	}

	public void setTolerance_percent(float tolerance_percent) {
		this.tolerance_percent = tolerance_percent;
	}

	@Override
	public String getInformation() {
		return "Type: "+this.getName()+", R: "+this.getR()
		+ " Ohms, Tolerancy: "+this.getTolerance_percent()
		+"%, Potency: "+this.getW()+" W.";
	}
	

}
