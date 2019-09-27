package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 10)
	private String username;
	private String password;
	
	@Column(length = 15)
	private String surname;
	
	@Column(length = 15)
	private String givename;
	
	private Date dob;
	
	private boolean gender;
	private String nationality;
	private String address;
	private String telephone;
	private String email;
	private String officeMail;
	private String postalCode;
	private boolean maritalStatus;
	
	@ManyToMany(cascade=CascadeType.ALL)
	 @JoinTable(name="users_roles",
	    joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
	    inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
	private List<Role> roles;

	
	public User(Integer id, String username, String password, List<Role> roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	public User() {
		
		
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGivename() {
		return givename;
	}
	public void setGivename(String givename) {
		this.givename = givename;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOfficeMail() {
		return officeMail;
	}
	public void setOfficeMail(String officeMail) {
		this.officeMail = officeMail;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public boolean isMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
}
