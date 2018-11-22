package fr.utbm.gestion.ecole.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="COURSE")
public class Course implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="COURS_CODE")
	private String code;
	@NotNull
	@Column(name="COURS_TITLE")
	private String titre;
	
	@OneToMany(mappedBy ="course",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private List<CourseSession> courseSessions = new ArrayList<>();

	public Course() {
		super();
	}
	
	public Course(String code, String titre) {
		super();
		
		this.code = code;
		this.titre = titre;
	}
 

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<CourseSession> getCourseSessions() {
		return courseSessions;
	}

	public void setCourseSessions(List<CourseSession> courseSessions) {
		this.courseSessions = courseSessions;
	}
	
	
	

}
