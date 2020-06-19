package com.nextconnect.repos;

import org.springframework.data.repository.CrudRepository;

import com.nextconnect.dto.Comments;

public interface CommentsRepo extends CrudRepository<Comments, Integer>{

}
