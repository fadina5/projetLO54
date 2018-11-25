package fr.utbm.gestion.ecole.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "COURSE_SESSION")
public class CourseSession implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CS_ID")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "CS_START_DATE")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CS_END_DATE")
	private Date endDate;

	@Column(name = "CS_MAX")
	private Integer max;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COURS_CODE")
	private Course courseCode;

	/*
	 * @JoinColumns({
	 * 
	 * @JoinColumn(name = "LOC_ID", insertable = false, updatable = false,
	 * foreignKey = @ForeignKey(name = "FK_COURSE_SESSION_LOCATION")),
	 * 
	 * @JoinColumn(name = "LOC_CITY", insertable = false, updatable = false,
	 * foreignKey = @ForeignKey(name = "FK_COURSE_SESSION_LOCATION")) })
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LOC_ID")
	private Location locationId;

	public CourseSession() {
		super();
	}

	public CourseSession(Integer id, Date startDate, Date endDate, Integer max, Course courseCode,
			Location locationId) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.max = max;
		this.courseCode = courseCode;
		this.locationId = locationId;
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

	public Course getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(Course courseCode) {
		this.courseCode = courseCode;
	}

	public Location getLocationId() {
		return locationId;
	}

	public void setLocationId(Location locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "CourseSession [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", max=" + max
				+ ", courseCode=" + courseCode + ", locationId=" + locationId + "]";
	}

}
