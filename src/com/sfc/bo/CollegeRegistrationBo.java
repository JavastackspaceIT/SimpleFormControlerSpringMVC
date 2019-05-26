package com.sfc.bo;

import java.io.Serializable;

public class CollegeRegistrationBo implements Serializable{

	private String collegeName;
	private String university;
	
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	
	@Override
	public String toString() {
		return "CollegeRegistrationBo [collegeName=" + collegeName + ", university=" + university + "]";
	}
	
}
