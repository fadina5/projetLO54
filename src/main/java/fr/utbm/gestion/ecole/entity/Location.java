package fr.utbm.gestion.ecole.entity;


public class Location {
	
	private Integer idLocation;
	private String city;
	
	public Location() {
		super();
	}

	public Location(Integer idLocation, String city) {
		super();
		this.idLocation = idLocation;
		this.city = city;
	}

	public Integer getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(Integer idLocation) {
		this.idLocation = idLocation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

}
