package at.ac.tuwien.infosys.aic11.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CustomerRating")
public enum CustomerRating {
	AAA, AAPlus, AA, AAMinus, APlus, A, AMinus, Defaulting
}
