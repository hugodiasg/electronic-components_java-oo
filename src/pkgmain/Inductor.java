package pkgmain;

public class Inductor extends Basic implements Datasheet{
	
	// Inductance and potency in watts
	private float L, W;

	
	public Inductor(float L,float W) {
		this.name = "Resistor";
		this.setL(L);
		this.setW(W);
		
		
	}
	
	public Inductor() {
		this.name = "Inductor";
	}

	public float getL() {
		return L;
	}

	public void setL(float l) {
		L = l;
	}

	public float getW() {
		return W;
	}

	public void setW(float w) {
		W = w;
	}

	@Override
	public String getInformation() {
		return "Type: "+this.getName()
		+", L: "+this.getL()
		+" H, Potency: "+this.getW()+" W.";
	}
}
