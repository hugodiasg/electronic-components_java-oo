package pkgmain;

public class Transistor extends Basic implements Datasheet{
	
	//Ex.: category= BJT and polarity=NPN
	private String category, polarity;

	
	public Transistor(String Category,String Polarity) {
		this.name = "Transistor";
		this.setCategory(Category);
		this.setPolarity(Polarity);
		
		
	}

	public Transistor() {
		this.name = "Transistor";	
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String Category) {
		this.category = Category;
	}

	public String getPolarity() {
		return this.polarity;
	}

	public void setPolarity(String polarity) {
		this.polarity = polarity;
	}

	@Override
	public String getInformation() {
		return "Type: "+this.getName()
		+", Category: "+this.getCategory()
		+", Polarity: "+this.getPolarity()+".";
	}
}
