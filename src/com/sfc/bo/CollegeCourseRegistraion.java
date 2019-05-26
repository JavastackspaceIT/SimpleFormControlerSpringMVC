package com.sfc.bo;

import java.io.Serializable;

public class CollegeCourseRegistraion implements Serializable{

	private CollegeRegistrationBo collegeRegistrationBo;
	private CourseRegistrationBo coRegistrationBo;
	public CollegeRegistrationBo getCollegeRegistrationBo() {
		return collegeRegistrationBo;
	}
	public void setCollegeRegistrationBo(CollegeRegistrationBo collegeRegistrationBo) {
		this.collegeRegistrationBo = collegeRegistrationBo;
	}
	public CourseRegistrationBo getCoRegistrationBo() {
		return coRegistrationBo;
	}
	public void setCoRegistrationBo(CourseRegistrationBo coRegistrationBo) {
		this.coRegistrationBo = coRegistrationBo;
	}
	@Override
	public String toString() {
		return "CollegeCourseRegistraion [collegeRegistrationBo=" + collegeRegistrationBo + ", coRegistrationBo="
				+ coRegistrationBo + "]";
	}
	
}
