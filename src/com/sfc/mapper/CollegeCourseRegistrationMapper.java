package com.sfc.mapper;

import org.springframework.stereotype.Component;

import com.sfc.bo.CollegeCourseRegistraion;
import com.sfc.bo.CollegeRegistrationBo;
import com.sfc.bo.CourseRegistrationBo;
import com.sfc.form.CollegeForm;

@Component
public class CollegeCourseRegistrationMapper {
	public CollegeCourseRegistraion collegeCourseFormToCollegeCourseBo(CollegeForm collegeForm) {
		CollegeCourseRegistraion collegeCourseRegistraion = null;
		CollegeRegistrationBo collegeRegistrationBo=null;
		CourseRegistrationBo courseRegistrationBo=null;
		
		
		collegeCourseRegistraion = new CollegeCourseRegistraion();
		
		collegeRegistrationBo=new CollegeRegistrationBo();
		
		courseRegistrationBo=new CourseRegistrationBo();
		
		collegeRegistrationBo.setCollegeName(collegeForm.getCollegeName());
		collegeRegistrationBo.setUniversity(collegeForm.getUniversity());
		
		courseRegistrationBo.setCourse(collegeForm.getCourse());
		courseRegistrationBo.setFee(collegeForm.getFee());
		
		collegeCourseRegistraion.setCollegeRegistrationBo(collegeRegistrationBo);
		collegeCourseRegistraion.setCoRegistrationBo(courseRegistrationBo);
		
		return collegeCourseRegistraion;
		
	}
}
