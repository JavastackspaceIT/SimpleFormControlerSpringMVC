package com.sfc.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sfc.exception.CollegetException;
import com.sfc.form.CollegeForm;
import com.sfc.mapper.CollegeCourseRegistrationMapper;
import com.sfc.service.CollegeRegistrationService;
import com.sfc.validator.CollegeCourseFormValidator;

@Controller
@RequestMapping("/")
public class CollegeRegistrationController {
	public static Logger LOG = Logger.getLogger(CollegeRegistrationController.class);
	@Autowired
	private CollegeRegistrationService collegeRegistrationService;

	@Autowired
	CollegeCourseFormValidator collegeCourseFormValidator;

	@Autowired
	CollegeCourseRegistrationMapper collegeCourseRegistrationMapper;

	@GetMapping
	public String showCollegeRegistraion(Model model) {
		model.addAttribute("collegeForm", new CollegeForm());
		return "college";
	}

	@PostMapping
	@RequestMapping("/college.htm")
	public String registerCollege(Model model, CollegeForm collegeForm, BindingResult bindingResult,
			MultipartFile multipartFile) throws CollegetException {
		if (collegeCourseFormValidator.supports(collegeForm.getClass())) {
			collegeCourseFormValidator.validate(collegeForm, bindingResult);
			if (bindingResult.hasErrors()) {
				return "college";
			}
		}
		int result = collegeRegistrationService
				.registerCollege(collegeCourseRegistrationMapper.collegeCourseFormToCollegeCourseBo(collegeForm));
		if (result != 0) {
			LOG.info("My result" + result);
			model.addAttribute("added", result);
		} else {
			LOG.error("Result value is 0");
		}
		return "success";
	}

	@RequestMapping(value = "/getData.htm", method = RequestMethod.GET)
	public ModelAndView getdata() {

		List<String> list = getList();

		// return back to index.jsp
		ModelAndView model = new ModelAndView("getdata");
		model.addObject("lists", list);

		return model;

	}

	private List<String> getList() {

		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");

		return list;

	}
}