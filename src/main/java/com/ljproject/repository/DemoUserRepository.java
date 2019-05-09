/**
 * 
 */
package com.ljproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ljproject.model.DemoUser;

/**
 * @author Nitesh
 *
 */
@Repository("demoUserRepository")
public interface DemoUserRepository extends JpaRepository<DemoUser, Long> {
	DemoUser findByEmail(String email);
}
