package fr.utbm.gestion.ecole.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Course")
public class Course {
	@Id
	private Integer idCourse;
	
	@NotNull
	@Column(name="COURS_CODE")
	private String code;
	@NotNull
	@Column(name="COURS_TITLE")
	private String titre;
	public Course() {
		super();
	}
	
	public Course(Integer idCourse, String code, String titre) {
		super();
		this.idCourse = idCourse;
		this.code = code;
		this.titre = titre;
	}
   
	public Integer getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Integer idCourse) {
		this.idCourse = idCourse;
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
	
	

}
