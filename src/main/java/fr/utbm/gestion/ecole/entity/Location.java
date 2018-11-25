package fr.utbm.gestion.ecole.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATION")
public class Location implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOC_ID")
	private Integer id;

	
	@Column(name = "LOC_CITY")
	private String city;


	public Location() {
		super();
	}

	public Location(String city) {
		super();
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + "]";
	}

	
}
