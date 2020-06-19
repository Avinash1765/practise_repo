package com.nextconnect.repos;

import org.springframework.data.repository.CrudRepository;

import com.nextconnect.dto.LikeDetailPk;
import com.nextconnect.dto.LikeDetails;

public interface LikeDetailRepo extends CrudRepository<LikeDetails, LikeDetailPk>{
	
}
