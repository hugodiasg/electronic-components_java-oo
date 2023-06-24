package pkgmain;

public abstract class Basic implements Datasheet{
	protected String name;

	
	public Basic() {
		this.name = "Basic";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getInformation() {
		return "";
	}
}
