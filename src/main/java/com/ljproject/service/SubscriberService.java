/**
 * 
 */
package com.ljproject.service;

import java.util.List;
import com.ljproject.model.Subscriber;

/**
 * @author Nitesh
 *
 */
public interface SubscriberService {
	public void saveSubscriber(Subscriber subscriber);
	public Subscriber findById(long id);
	public List<Subscriber> listSubscriber();
	void deleteSubscriberById(long id);

}
