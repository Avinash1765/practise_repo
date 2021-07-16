package com.imageupload.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.imageupload.dto.ImagePojo;
import com.imageupload.repo.ImageUploadRepo;

@RestController
public class FileUploadController {
	
	/*
	 * curl command to upload file: 
	 * curl -X POST -F
	 * File=@C:\Users\atadiboy\Downloads\pet_sample.png
	 * http://localhost:8080/fileupload
	 */	
	
	@Autowired
	private ImageUploadRepo repo;

	@PostMapping("/fileupload")
	public void imageUpload(@RequestParam("File") MultipartFile file) throws IOException {
		System.out.println("size is "+file.getSize());
		
		byte[] imgarr=file.getBytes();
		
		ImagePojo imgObject=new ImagePojo();
		imgObject.setImage(imgarr);
		
		ImagePojo savedImage=repo.save(imgObject);
		
		System.out.println(savedImage);
		
	}
	
	@RequestMapping(value = "/getFile/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageFromDB(@PathVariable("id") int imageId) {
		
		byte[] arr=repo.findById(imageId).get().getImage();
		System.out.println(arr);
		return arr;
		
	}
	
	@RequestMapping(value = "/hitmebro")
	public String getName() {
		return "Avinash";
	}
	
}

