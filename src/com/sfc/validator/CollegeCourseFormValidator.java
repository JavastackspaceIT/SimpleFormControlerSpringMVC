package com.sfc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sfc.form.CollegeForm;
import com.sfc.validation.util.ValidationUtils;
@Component
public class CollegeCourseFormValidator implements Validator{
	@Override
	public boolean supports(Class<?> classType) {
		if (classType.isAssignableFrom(CollegeForm.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void validate(Object object, Errors errors) {
		CollegeForm cForm = null;

		cForm = (CollegeForm) object;

		 if(ValidationUtils.isEmpty(cForm.getCollegeName())) {
			 errors.reject("collegeName","collegeName.blank");
		 }
		 if(ValidationUtils.isEmpty(cForm.getCourse())) {
			 errors.reject("course", "course.blank");
			 
		 }
		 if(ValidationUtils.isEmpty(cForm.getUniversity())) {
			 errors.reject("university","university.blank");
		 }
	}
}
