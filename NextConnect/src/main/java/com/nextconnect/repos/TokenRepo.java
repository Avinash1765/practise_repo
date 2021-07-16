package com.nextconnect.repos;

import org.springframework.data.repository.CrudRepository;

import com.nextconnect.dto.MessagingToken;

public interface TokenRepo extends CrudRepository<MessagingToken, Integer>{

}
