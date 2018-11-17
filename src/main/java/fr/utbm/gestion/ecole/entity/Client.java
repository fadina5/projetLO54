package fr.utbm.gestion.ecole.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="CLIENT")
public class Client implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CLI_ID")
	private Integer id;
	
	@Column(name ="CLI_LASTNAME")
	@NotNull
    private String lastname;
	
	@Column(name ="CLI_FIRSTNAME")
	@NotNull
    private String firstname;
	
	@Column(name ="CLI_ADDRESS")
	@NotNull
    private String address;
	
	@Column(name ="CLI_PHONE")
	@NotNull
    private String phone;
	
	@Column(name ="CLI_EMAIL")
	@NotNull
    private String email;
	
	@ManyToMany(mappedBy ="courseSession") 
	private Set<CourseSession> courseSession;
	
    public Client() {
		super();
	}
	public Client(Integer id, String lastname, String firstname, String address, String phone, String email) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<CourseSession> getCourseSession() {
		return courseSession;
	}
	public void setCourseSession(Set<CourseSession> courseSession) {
		this.courseSession = courseSession;
	}
	
    

}
