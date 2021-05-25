package com.mph.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * This Entity is for the User class
 * @author Divya G
 * @version 1.0
 */
@Entity(name = "BTBS_USER")
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "uid")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long uid;
	@NotEmpty(message="first name cannot be empty")
	@Column(name = "f_name")
	private String fname;
	@Column(name = "m_name")
	private String mname;
	@NotEmpty(message="last name cannot be empty")
	@Column(name = "l_name")
	private String lname;
	@NotNull(message="gender cannot be empty")
	private String gender;
	private long phone;
	@Valid
	@Embedded
	private Address address;
	@OneToOne
	@JoinColumn(name = "role_ID")
	private Role role;
	@NotEmpty
	@Size(min=5, max=10, message="password has to be 5-15 characters long")
	private String password;
	@Email(message="email should be valid")
	private String emailId;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long uid, String fname, String mname, String lname, long phone, Address address, Role role,
			String username, String password, String emailId, String gender) {
		super();
		this.uid = uid;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.gender = gender;
		this.password = password;
		this.emailId = emailId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", fname=" + fname + ", mname=" + mname + ", lname=" + lname + ", phone=" + phone
				+ ", address=" + address + ", role=" + role + ", password=" + password
				+ ", emailId=" + emailId + "]";
	}


	
}
