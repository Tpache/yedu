package cn.com.yedu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/homeContr")
public class HomeController {

	private static Logger logger = Logger.getLogger(HomeController.class); 
	@RequestMapping(value = "/home")
	public ModelAndView homePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("用户访问HomeController.class----->  /homeContr/home.html");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");
		modelAndView.addObject("msg", "欢迎访问");
		return modelAndView;
	}
}
