package org.practice.controller;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.practice.customeditor.StudentNamePropertyEditorSupport;
import org.practice.dto.Student;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

//public class HelloController extends AbstractController {

@Controller
public class HelloController {

	// @Override
	// protected ModelAndView handleRequestInternal(HttpServletRequest request,
	// HttpServletResponse response)
	// throws Exception {
	// ModelAndView modelAndView = new ModelAndView("welcome");
	// modelAndView.addObject("welcomeMsg", "This is a demo page");
	// return modelAndView;
	// }

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		DateFormat dt = new SimpleDateFormat("dd**MM**yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dt, true));
		webDataBinder.registerCustomEditor(String.class, "name", new StudentNamePropertyEditorSupport());
	}

	@RequestMapping(value = "/")
	public ModelAndView welcome(@RequestParam(value = "user", defaultValue = "Mr XYZ") String user) {
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("welcomeMsg", user + " , Welcome to Spring MVC ");
		return modelAndView;
	}

	@ModelAttribute
	public void addingCommonObjects(Model model) {
		model.addAttribute("headerMsg", "Cg College Of Engineering");
	}

	@RequestMapping(value = "/addUserDetails/{country}/{user}")
	public ModelAndView testRequestMap(@PathVariable Map<String, String> pathVars) {
		String country = pathVars.get("country");
		String user = pathVars.get("user");

		ModelAndView modelAndView = new ModelAndView("welcome");
		System.out.println("Country : " + country + " , user : " + user);

		return modelAndView;
	}

	@RequestMapping(value = "/admission")
	public ModelAndView admissionForm() throws Exception{
		String exception = "NULL_POINTER";
		if(exception.equalsIgnoreCase(exception)){
			throw new NullPointerException("Null pointer exception has occured");
		}
		ModelAndView modelAndView = new ModelAndView("admission_form");
		return modelAndView;
	}

	@RequestMapping(value = "/admissionRequest", method = RequestMethod.POST)
	public ModelAndView processAdmissionRequest(@Valid @ModelAttribute("student1") Student student,
			BindingResult bindingResult) {
		
		System.out.println("Received model attribute as : " + student.toString());

		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("admission_form");
			return modelAndView;
		}

		ModelAndView modelAndView = new ModelAndView("admission_success");
		return modelAndView;
	}

}
