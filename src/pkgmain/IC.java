package pkgmain;

public class IC implements Datasheet{

	// Example series_name=741, category=Amp Op
	private String name="IC",series_name, category;
	
	public IC(String series_name, String category) {
		this.setSeries_name(series_name);
		this.setCategory(category);		
	}
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSeries_name() {
		return series_name;
	}

	public void setSeries_name(String serie_name) {
		this.series_name = serie_name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String getInformation() {
		return "Type: "+this.getName()
		+", Series: "+this.getSeries_name()
		+", Category: "+this.getCategory()+".";
	}


}
