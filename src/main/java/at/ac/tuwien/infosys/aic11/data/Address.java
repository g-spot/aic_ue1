package at.ac.tuwien.infosys.aic11.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "address")
public class Address {
	
	private long id; //due to the paper, it should be string, but i think this is a typo
	private String street;
	private String city;
	private String house;
	private String door;
	private String zipcode;
	
	@XmlAttribute
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getHouse() {
		return house;
	}
	
	public void setHouse(String house) {
		this.house = house;
	}
	
	public String getDoor() {
		return door;
	}
	
	public void setDoor(String door) {
		this.door = door;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public at.ac.tuwien.infosys.aic11.services.Address toAddress() {
		at.ac.tuwien.infosys.aic11.services.Address a = new at.ac.tuwien.infosys.aic11.services.Address();
		a.setCity( this.city );
		a.setCountryCode( "" );
		a.setDoor( this.door );
		a.setHouse( this.house );
		a.setPostalCode( this.zipcode );
		a.setStreet( this.street );
		return a;
	}
}
