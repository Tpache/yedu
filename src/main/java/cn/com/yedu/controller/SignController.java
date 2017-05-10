package cn.com.yedu.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.yedu.pojo.WeChatSign;
import cn.com.yedu.service.ICoreMessageService;
import cn.com.yedu.util.SignUtil;

@Controller
@RequestMapping("/signContr")
public class SignController {
	
	private static Logger logger = Logger.getLogger(SignController.class); 
	
	@Resource
	  private ICoreMessageService coreMessageService;
	
	@RequestMapping(value="/api",method = RequestMethod.GET)
	public void yeduWXAccessGet(HttpServletRequest request,HttpServletResponse response,WeChatSign wc) throws Exception{
		System.out.println("/api");
		String signature = wc.getSignature(); // 微信加密签名  
        String timestamp = wc.getTimestamp(); // 时间戳  
        String nonce = wc.getNonce();// 随机数  
        String echostr = wc.getEchostr();// 随机字符串  
 
        if("".equals(signature)||"".equals(timestamp)||"".equals(nonce)){
        	logger.error("验证signature请求参数出错");
            return;
        }
        logger.info("正在进行验证signature...");
        PrintWriter out = response.getWriter();
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
        	out.print(echostr);
        	logger.info("验证signature成功");
        } else {  
        	logger.info("验证signature失败");
        }
        out.close();
        out = null;
	}
	
	@RequestMapping(value="/api",method = RequestMethod.POST)
	public void yeduWXAccessPost(HttpServletRequest request, HttpServletResponse response) throws Exception	{
		
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  //微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
        response.setCharacterEncoding("UTF-8"); //在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
        PrintWriter out = response.getWriter();
        //初始化配置文件
        String respMessage = coreMessageService.processRequest(request);//调用CoreService类的processRequest方法接收、处理消息，并得到处理结果；
        // 响应消息  
        //调用response.getWriter().write()方法将消息的处理结果返回给用户
      //向微信服务器返回执行结果
        out.print(respMessage);
        logger.info("请求返回结果----> "+respMessage);
        out.close();
	}
}
