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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.ljproject.util.ConstantUtils;
import com.ljproject.validator.Validate;
import com.ljproject.web.services.model.audit.DateAudit;

/**
 * @author Nitesh
 *
 */
@Entity
@Table(name = "subscriber")
public class Subscriber extends DateAudit implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@NotNull
	@Validate(min = 10, max = 100, regexp = ConstantUtils.EMAIL_PATTERN, message = "Please enter between {min}-{max} characters and valid input")
	private String email;

	@Column(name = "subscriberName")
	private String subscriberName;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	public String getSubscriberName() {
		return subscriberName;
	}

	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
