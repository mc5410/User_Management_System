package io.egen.userMgmtApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="table_usr")
@NamedQueries ({
	@NamedQuery(name="Users.findUserByInfo", query="SELECT u FROM Users u WHERE u.firstName = :firstName AND u.middleName = :middleName AND u.lastName = :lastName ")
})
public class Users {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="id")
	private String id;
	
	@Column(name="firstName", nullable= false)

	private String firstName;
	
	@Column(name="middleName")
	private String middleName;
	
	@Column(name="lastName", nullable= false)
	private String lastName;
	
	@Column(name = "age", nullable = false)

    private String age;
    
    @Column(name = "gender", nullable = false)
    private String gender;
    
    @Column(name = "phone", nullable = false)

    private String phone;
    
    @Column(name = "zipcode", nullable = true)
    private String zipcode;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	

	

}
