package com.nextconnect.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="followers")
public class Following {
	
	@Id
	@Column(name="relationship_id")
	@SequenceGenerator(allocationSize = 5, name = "following_seq_identifier",sequenceName = "following_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "following_seq_identifier")
	private Integer relationshipId;
	
//	@EmbeddedId
//	private FollowingPk id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = UserDetails.class)
	@JoinColumn(name = "user_id")
	private UserDetails user;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = UserDetails.class)
	@JoinColumn(name = "following")
	private UserDetails followingUserId;

	public Integer getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(Integer relationshipId) {
		this.relationshipId = relationshipId;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public UserDetails getFollowingUserId() {
		return followingUserId;
	}

	public void setFollowingUserId(UserDetails followingUserId) {
		this.followingUserId = followingUserId;
	}

	@Override
	public String toString() {
		return "Following [relationshipId=" + relationshipId + ", user=" + user + ", followingUserId=" + followingUserId
				+ "]";
	}
	
}
