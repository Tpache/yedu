package cn.com.yedu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 *	调查问卷
 */
@Controller
@RequestMapping("/surveyContr")
public class SurveyController {
	
	private static Logger logger = Logger.getLogger(SurveyController.class); 
	
	@RequestMapping(value = "/addSurvey")
	public ModelAndView addSurvey(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("用户访问HomeController.class----->  /surveyContr/addSurvey.html");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("web/addSurvey");
		return modelAndView;
	} 
	
	private boolean isTableExists(String flag){
		
		return false;
	}
}
