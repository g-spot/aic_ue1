package at.ac.tuwien.infosys.aic11.data;

public class Cheque implements DisbursementPreference {

	private String name;
	
	public Cheque()
	{
		
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Checque: " + name;
	}
}
