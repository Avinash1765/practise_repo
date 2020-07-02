package com.nextconnect.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nextconnect.dto.UserDetails;

public interface BrowseUserRepo extends PagingAndSortingRepository<UserDetails, Integer> {
	
}
