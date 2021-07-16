package com.imageupload.dto;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "img_tab")
public class ImagePojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
	@SequenceGenerator(name = "image_seq",allocationSize = 5,sequenceName = "img_id_seq")
	@Column(name = "img_id")
	private Integer imageId;
	
	@Column(name = "image")
	private byte[] image;
	
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public ImagePojo() {}
	public ImagePojo(Integer imageId, byte[] image) {
		super();
		this.imageId = imageId;
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "ImagePojo [imageId=" + imageId + ", image=" + Arrays.toString(image) + "]";
	}
	
	

}
