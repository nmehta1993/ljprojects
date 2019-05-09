/**
 * 
 */
package com.ljproject.serviceImpl;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.ljproject.model.DemoUser;
import com.ljproject.repository.DemoUserRepository;

import com.ljproject.service.DemoUserService;

/**
 * @author Nitesh
 *
 */
@Service("demoUserService")
@Transactional
public class DemoUserServiceImpl implements DemoUserService{

	@Autowired
	private DemoUserRepository demoUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public DemoUser findUserByEmail(String email) {

		return demoUserRepository.findByEmail(email);
	}

	@Override
	public DemoUser saveUser(DemoUser demoUser) {
		demoUser.setPassword(bCryptPasswordEncoder.encode(demoUser.getPassword()));
		demoUser.setActive(1);
		demoUser.setRole(demoUser.getRole());
		return demoUserRepository.save(demoUser);
	}

}
