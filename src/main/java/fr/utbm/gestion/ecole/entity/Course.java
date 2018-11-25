package fr.utbm.gestion.ecole.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "COURS_CODE")
	private String code;

	@Column(name = "COURS_TITLE")
	private String titre;

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

	@Override
	public String toString() {
		return "Course [code=" + code + ", titre=" + titre + "]";
	}
	

}
