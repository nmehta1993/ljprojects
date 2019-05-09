/**
 * 
 */
package com.ljproject.service;

import com.ljproject.model.DemoUser;



/**
 * @author Nitesh
 *
 */
public interface DemoUserService {
	public DemoUser findUserByEmail(String email);
	public DemoUser saveUser(DemoUser demoUser);
}
