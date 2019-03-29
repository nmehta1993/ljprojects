/**
 * 
 */
package com.ljproject.validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Nitesh
 *
 */
public class RoleValidator implements Validator{

	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "bookingDate", "required", "Please provide Booking Date");
			
	}

}
