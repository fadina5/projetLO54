package fr.utbm.gestion.ecole.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	private Integer idLocation;

	@Id
	@Column(name = "LOC_CITY")
	@NotNull
	private String city;
	
	@OneToMany(mappedBy ="Course")
    private List<CourseSession> courseSessions = new ArrayList<>();


	public Location() {
		super();
	}

	public Location(String city) {
		super();
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

	public List<CourseSession> getCourseSessions() {
		return courseSessions;
	}

	public void setCourseSessions(List<CourseSession> courseSessions) {
		this.courseSessions = courseSessions;
	}

}
