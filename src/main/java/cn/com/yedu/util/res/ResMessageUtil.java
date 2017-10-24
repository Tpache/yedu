package cn.com.yedu.util.res;

import java.util.Date;
import java.util.Map;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import cn.com.yedu.pojo.resp.TextMessage;
import cn.com.yedu.service.ITextMsgService;
import cn.com.yedu.util.MessageUtil;

public class ResMessageUtil {

	//查询消息列表实用类
	public static ITextMsgService textMsgService;
	static{
		if(null == textMsgService || "".equals(textMsgService)){
			WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
			textMsgService = (ITextMsgService) wac.getBean("textMsgService");
		}
	}
	/**
	 * 回复文本消息    根据用户发送的内容进行查询后回复消息
	 * @param fromUserName
	 * @param toUserName
	 * @param respContent
	 * @return
	 */
	public static String getTextMessage(String fromUserName , String toUserName , String reqContent) {
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		String resultText = "[糗大了]未查询到信息，请检查您发送的关键字是否有误~[糗大了]";
		Map<String, String> respContent = textMsgService.getMsgByContent(toUserName, reqContent);
		if(null != respContent && !respContent.isEmpty()){
			textMessage.setContent(new StringBuilder().append("<a href='").append(respContent.get("signUrl")).append("'>")
				.append(respContent.get("contentDesc")).append("</a>[勾引]").toString());
		}else{
			textMessage.setContent(resultText);
		}
		return MessageUtil.textMessageToXml(textMessage);
	}
	/**
	 * 回复关注内容
	 * @param fromUserName
	 * @param toUserName
	 * @param respContent
	 * @return
	 */
	public static String getSubscribeMessage(String fromUserName , String toUserName , String respContent) {
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		
		//textMessage.setContent(respContent);
		textMessage.setContent("Biu~的一下你就来到小岗的的大本营啦！\n"
				+ "[鼓掌][鼓掌][鼓掌][鼓掌][爱心][鼓掌][鼓掌][鼓掌][鼓掌]\n"
				+ "还等什么？<a href='http://www.baidu.com'>早到早得哦</a>~[勾引]");
		return MessageUtil.textMessageToXml(textMessage);
	}
}
