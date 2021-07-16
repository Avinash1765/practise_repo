package com.imageupload.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imageupload.dto.ImagePojo;

@Repository
public interface ImageUploadRepo extends CrudRepository<ImagePojo, Integer>{

}
