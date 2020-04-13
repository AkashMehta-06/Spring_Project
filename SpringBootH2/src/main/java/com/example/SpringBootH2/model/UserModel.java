package com.example.SpringBootH2.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;




@Entity
@Table(name= "User")
public class UserModel  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@NotNull
	@Size(max=65)
	@Column(name= "user_name")
	String username;
	
	@Enumerated(EnumType.STRING)
    @Column(length = 10)
	Status status;
	
	@NotNull
	@Size(max=65)
	@Column(name= "first_name")
	String firstName;
	
	@Size(max=65)
	@Column(name= "last_name")
	String lastName;
	
	@NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
	String email;
	
	@Column(name= "created_By")
	int createdBy;
	
	@Column(name= "created_Date")
	String createdDate;
	
	@Column(name= "Last_Modified_By")
	int lastModifiedBy;
	
	@Column(name= "Last_Modified_Date")
	String lastModifiedDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id", referencedColumnName = "owner")
	AccountModel account;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	

	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	
	public int getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(int lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	
	
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
/*	public void setStatus(String string) {
		// TODO Auto-generated method stub
		
	}*/
	
	
}
