package com.nextconnect.repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nextconnect.dto.UserDetails;

@Repository
public interface UserRepository extends CrudRepository<UserDetails, Integer>{
	
	public List<UserDetails> findByEmailIdIgnoreCase(String emailId);

}
