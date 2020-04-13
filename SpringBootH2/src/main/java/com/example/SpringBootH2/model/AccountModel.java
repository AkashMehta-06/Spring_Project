package com.example.SpringBootH2.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;




@Entity
@Table(name= "account")
public class AccountModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@NotNull
	@Size(max=65)
	@Column(name= "account_name")
	String accountname;
	
	@Column(name= "owner")
	int owner;
	
	@Column(name= "created_By")
	int createBy;
	
	@Column(name= "created_Date")
	String createDate;
	
	@Column(name= "Last_Modified_By")
	int lastModifiedBy;
	
	@Column(name= "Last_Modified_Date")
	String lastModifiedDate;
	
	@OneToOne(mappedBy= "account")
	UserModel user;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}

	
	public int getCreateBy() {
		return createBy;
	}
	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}
	
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
}