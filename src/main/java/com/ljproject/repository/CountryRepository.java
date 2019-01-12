/**
 * 
 */
package com.ljproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ljproject.model.Country;

/**
 * @author Nitesh
 *
 */
@Repository("countryRepository")
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
