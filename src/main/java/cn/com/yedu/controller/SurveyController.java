package cn.com.yedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 *	调查问卷
 */
@Controller
@RequestMapping("/surveyContr")
public class SurveyController {
	
	private boolean isTableExists(String flag){
		
		return false;
	}
}
