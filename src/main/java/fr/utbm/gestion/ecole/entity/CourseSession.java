package fr.utbm.gestion.ecole.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="COURSE_SESSION")
public class CourseSession implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CS_ID")
	private Integer id;
	
	@Column(name = "CS_START_DATE")
	@NotNull
	private Date startDate;
	@Column(name = "CS_END_DATE")
	@NotNull
	private Date endDate;
	@Column(name = "CS_MAX")
	@NotNull
	private Integer max;
	
	@ManyToOne
    @JoinColumn(name ="COURS_CODE")
	private Course course;
	
	@ManyToOne
    @JoinColumn(name ="LOC_ID")
	private Location location;
	
	public CourseSession() {
		super();
	}
	public CourseSession(Integer id, Date startDate, Date endDate, Integer max) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.max = max;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
	


}
