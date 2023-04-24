package com.aurionpro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name = "instructordetails_db")
public class InstructorDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iD_id")
	private Long iDId;
	private String youtube_channel;
	private String git_url;
	
	@OneToOne(mappedBy = "iDetailsS") // one to one bidirectional
	private Instructor instructor;

	public InstructorDetails() {
		super();
	}

	public InstructorDetails(Long iDId, String youtube_channel, String git_url, Instructor instructor) {
		super();
		this.iDId = iDId;
		this.youtube_channel = youtube_channel;
		this.git_url = git_url;
		this.instructor = instructor;
	}

	public Long getiDId() {
		return iDId;
	}

	public void setiDId(Long iDId) {
		this.iDId = iDId;
	}

	public String getYoutube_channel() {
		return youtube_channel;
	}

	public void setYoutube_channel(String youtube_channel) {
		this.youtube_channel = youtube_channel;
	}

	public String getGit_url() {
		return git_url;
	}

	public void setGit_url(String git_url) {
		this.git_url = git_url;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetails [iDId=" + iDId + ", youtube_channel=" + youtube_channel + ", git_url=" + git_url
				+ ", instructor=" + instructor + "]";
	}
	
	
}
