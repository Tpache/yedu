package cn.com.yedu.util.res;

import java.util.Date;

import cn.com.yedu.pojo.resp.TextMessage;
import cn.com.yedu.util.MessageUtil;

public class ResMessageUtil {

	/**
	 * 回复文本消息
	 * @param fromUserName
	 * @param toUserName
	 * @param respContent
	 * @return
	 */
	public static String getTextMessage(String fromUserName , String toUserName , String respContent) {
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);
		
		textMessage.setContent(respContent);
		return MessageUtil.textMessageToXml(textMessage);
	}
}
