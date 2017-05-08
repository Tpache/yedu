package cn.com.yedu.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.yedu.pojo.User;
import cn.com.yedu.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	  @Resource
	  private IUserService userService;

	  
	  @RequestMapping("/showUser")
//	  @ResponseBody
	  public void toIndex(HttpServletRequest request,HttpServletResponse response) throws IOException{
	    int userId = Integer.parseInt(request.getParameter("id"));
	    User user = this.userService.getUserById(userId);
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json;charset=utf-8");
	    response.getWriter().write(user.getId());
	  }
}
