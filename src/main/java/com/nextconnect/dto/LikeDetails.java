package com.nextconnect.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="like_details")
public class LikeDetails {
	
	@EmbeddedId
	private LikeDetailPk likeDetail;

	public LikeDetailPk getLikeDetail() {
		return likeDetail;
	}

	public void setLikeDetail(LikeDetailPk likeDetail) {
		this.likeDetail = likeDetail;
	}
	
}
