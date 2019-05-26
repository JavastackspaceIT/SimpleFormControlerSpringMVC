package com.sfc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.sfc.bo.CollegeCourseRegistraion;
import com.sfc.bo.CollegeRegistrationBo;
import com.sfc.bo.CourseRegistrationBo;
import com.sfc.dao.CollegeRegistrationDao;
import com.sfc.exception.CollegetException;

@Service
public class CollegeRegistrationService {

	@Autowired(required = true)
	private CollegeRegistrationDao collegeRegistrationDao;
	private int register = 0;

	@Transactional(readOnly = false, isolation = Isolation.DEFAULT)
	public int registerCollege(CollegeCourseRegistraion ccRegistraion) throws CollegetException {

		int result = 0;
		try {
			CourseRegistrationBo courseRegistrationBo = null;
			CollegeRegistrationBo collegeRegistrationBo = new CollegeRegistrationBo();
			collegeRegistrationBo.setCollegeName(ccRegistraion.getCollegeRegistrationBo().getCollegeName());
			collegeRegistrationBo.setUniversity(ccRegistraion.getCollegeRegistrationBo().getUniversity());
			register = collegeRegistrationDao.registerCollege(collegeRegistrationBo);
			courseRegistrationBo = new CourseRegistrationBo();
			courseRegistrationBo = null;
			courseRegistrationBo.setCollegeidfk(register);
			courseRegistrationBo.setCourse(ccRegistraion.getCoRegistrationBo().getCourse());
			courseRegistrationBo.setFee(ccRegistraion.getCoRegistrationBo().getFee());
			result = collegeRegistrationDao.courseInsert(courseRegistrationBo);
		} catch (Exception exception) {
			throw new CollegetException("Sorry there are some internal issue " + exception);
		}
		return result;
	}
}