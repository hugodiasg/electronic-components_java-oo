package pkgmain;

public class LED extends Basic implements Datasheet{

	// Max. reverse voltage and max. direct current
	private float Vmax_reverse, Idirect;
	//Code to choose a color
	private int color_code;
	//Color name attached to the code color
	private String color_name;
	
	public LED(float Vmax_reverse,float Idirect,int color_code) {
		this.name = "LED";
		this.setVmax_reverse(Vmax_reverse);
		this.setIdirect(Idirect);
		this.setColor_code(color_code);
		
		
	}
	
	public LED() {
		this.name = "LED";
	}
	
	//List the color codes
	public void listColorCode() {
		System.out.println("===== Colors Code\n"
				+ "1 - Red\n"
				+ "2 - Blue\n"
				+ "3 - Green\n"
				+ "4 - Yellow\n"
				+ "5 - White");
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

	public int getColor_code() {
		return color_code;
	}


	public void setColor_code(int color_code) {
		// There's only 5 options of colors
		if (color_code>5 || color_code<1){
			throw new IllegalArgumentException("Invalid color option try listcolorCode() method.");
		}else {
			this.color_code = color_code;
			attachColor(color_code);
		}
		
	}
	
	//Attach a color name by the color code
	private void attachColor(int color_code) {
		switch (color_code) {
		case 1:
			this.color_name="Red";
			break;
		case 2:
			this.color_name="Blue";
			break;
		case 3:
			this.color_name="Green";
			break;
		case 4:
			this.color_name="Yellow";
			break;
		case 5:
			this.color_name="White";
			break;
		default:
			this.color_name="Color invalid";
		}
		
	}

	public String getColor_name() {
		return color_name;
	}
	
	@Override
	public String getInformation() {
		return "Type: "+this.getName()+", Color: "
				+this.getColor_name()+", Vmax_reverse: "
				+this.getVmax_reverse()+" V, Idirect: "
				+this.getIdirect()+" A.";
	}
}
