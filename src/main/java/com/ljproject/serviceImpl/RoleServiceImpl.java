/**
 * 
 */
package com.ljproject.serviceImpl;

import javax.transaction.Transactional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ljproject.model.Role;
import com.ljproject.repository.RoleRepository;
import com.ljproject.service.RoleService;

/**
 * @author Nitesh
 *
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	public static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Override
	public Role findById(long id) {
		return roleRepository.findOne((int) id);
	}

}
