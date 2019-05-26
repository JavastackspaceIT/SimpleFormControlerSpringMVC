package com.sfc.bo;

import java.io.Serializable;

public class CourseRegistrationBo implements Serializable{

	private String course;
	private float fee;
	private int collegeidfk;
	public int getCollegeidfk() {
		return collegeidfk;
	}
	public void setCollegeidfk(int collegeidfk) {
		this.collegeidfk = collegeidfk;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "CourseRegistrationBo [course=" + course + ", fee=" + fee + ", collegeidfk=" + collegeidfk + "]";
	}
	
	
	
}
