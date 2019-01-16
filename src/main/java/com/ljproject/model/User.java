package com.ljproject.model;

import java.io.Serializable;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.hibernate.annotations.ColumnDefault;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

import com.ljproject.util.ConstantUtils;
import com.ljproject.validator.Validate;
import com.ljproject.web.services.model.audit.DateAudit;





@Entity
@Table(name = "user")
public class User extends DateAudit implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long id;
	
	@NotNull
	@Validate(min=10, max=100, regexp=ConstantUtils.EMAIL_PATTERN, message="Please enter between {min}-{max} characters and valid input")
	private String email;
	
    @NotBlank
    @Size(max = 15)
    private String username;
    
   private String sex;
   
   
    @ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
    
    
    

    public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

		public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	

	/**
	 * @param name
	 * @param username2
	 * @param email2
	 * @param password2
	 */
	  public User() {

    }

    public User(String name, String username, String email, String password) {
        this.firstName = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	@Length(min = 8, message = "*Your password must have at least 8 characters")
	@NotEmpty(message = "*Please provide your password")
	@Transient
	private String password;
	@NotNull
	@Validate(min=5, max=30, regexp=ConstantUtils.CHAR_PATTERN, message="Please enter between {min}-{max} characters and no digits")
	private String firstName;

	public int getApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}

	@NotNull
	private String lastName;
	
	private int active;
	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	
	
	
	private String otp;
	
	
	@ColumnDefault("0")
	private String verify;


	
	
	
	
	@ColumnDefault("0")
	private int approved;
	
	
	
	

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}



}
