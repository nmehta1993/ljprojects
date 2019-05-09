/**
 * 
 */
package com.ljproject.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ljproject.util.ConstantUtils;
import com.ljproject.validator.Validate;
import com.ljproject.web.services.model.audit.DateAudit;

/**
 * @author Nitesh
 *
 */
@Entity
@Table(name = "demo_user")
public class DemoUser  extends DateAudit implements Serializable{
	
	
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
        

	@Length(min = 8, message = "*Your password must have at least 8 characters")
	@NotEmpty(message = "*Please provide your password")
	@Transient
	private String password;
	@NotNull
	@Validate(min=5, max=30, regexp=ConstantUtils.CHAR_PATTERN, message="Please enter between {min}-{max} characters and no digits")
	private String firstName;
	
	
	@NotNull
	private String lastName;
	
	private int active;
		
	private String otp;
	
	
	@ColumnDefault("0")
	private String verify;

	
	@ColumnDefault("0")
	private int approved;
	
	@ManyToOne
	@JsonIgnore
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	public int getApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}



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

	


}
