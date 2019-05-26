package com.sfc.form;

public class CollegeForm {

	private String collegeName;
	private String university;
	private String course;
	private float fee;

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
		return "CollegeForm [collegeName=" + collegeName + ", university=" + university + ", course=" + course
				+ ", fee=" + fee + "]";
	}

}
