/**
 * 
 */
package com.ljproject.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljproject.model.Subscriber;
import com.ljproject.repository.SubscriberRepository;
import com.ljproject.service.SubscriberService;

/**
 * @author Nitesh
 *
 */
@Service("subscriberService")
@Transactional
public class SubscriberServiceImpl implements SubscriberService {

	
	@Autowired
	SubscriberRepository subscriberRepository;
	
	
	 public static final Logger logger = LoggerFactory.getLogger(SubscriberServiceImpl.class);
	/* (non-Javadoc)
	 * @see com.ljproject.service.SubscriberService#saveSubscriber(com.ljproject.model.Subscriber)
	 */
	@Override
	public void saveSubscriber(Subscriber subscriber) {
		// TODO Auto-generated method stub
		subscriberRepository.save(subscriber);
		
	}

	/* (non-Javadoc)
	 * @see com.ljproject.service.SubscriberService#findById(long)
	 */
	@Override
	public Subscriber findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ljproject.service.SubscriberService#listSubscriber()
	 */
	@Override
	public List<Subscriber> listSubscriber() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ljproject.service.SubscriberService#deleteSubscriberById(long)
	 */
	@Override
	public void deleteSubscriberById(long id) {
		// TODO Auto-generated method stub
		
	}

}
