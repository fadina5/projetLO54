package fr.utbm.gestion.ecole.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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

	@ManyToOne
	@JoinColumn(name = "COURS_CODE")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "LOC_ID")
	private Location location;

	@OneToMany(mappedBy = "courseSession")
	private List<Client> clients = new ArrayList<>();

	@Transient
	private Integer clientPercentage;

	public CourseSession() {
		super();
	}

	public CourseSession(Integer id, Date startDate, Date endDate, Integer max, Course course, Location location) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.max = max;
		this.course = course;
		this.location = location;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public Integer getClientPercentage() {
		return clientPercentage;
	}

	public void setClientPercentage(Integer clientPercentage) {
		this.clientPercentage = clientPercentage;
	}

	@Override
	public String toString() {
		return "CourseSession [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", max=" + max
				+ ", course=" + course + ", location=" + location + ", clients=" + clients + "]";
	}

}