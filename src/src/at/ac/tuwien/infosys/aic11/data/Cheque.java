package src.at.ac.tuwien.infosys.aic11.data;

public class Cheque implements DisbursementRating {

	private String name;

	
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
