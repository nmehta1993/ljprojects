/**
 * 
 */
package com.ljproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ljproject.model.Subscriber;


/**
 * @author Nitesh
 *
 */
@Repository("subscriberRepository")
public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

}
