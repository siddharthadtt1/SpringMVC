package org.practice.interceptor;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class WeekdayInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws IOException {

		DayOfWeek day = LocalDate.now().getDayOfWeek();

		if (day.equals(DayOfWeek.SATURDAY)) {
			response.getWriter().write(
					"Please visit site on weekdays.It is closed on Sunday");
			return false;
		}

		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object object, ModelAndView modelAndView){
		
		System.out.println("After the /SpringMVC/admission url method is hit");
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception){
		System.out.println("After the admission_form.jsp page has been displayed");
	}

}
