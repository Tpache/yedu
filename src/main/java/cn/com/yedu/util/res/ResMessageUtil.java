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
		
		//textMessage.setContent(respContent);
		textMessage.setContent("Biu~的一下你就来到小岗的的大本营啦！\n"
				+ "[鼓掌][鼓掌][鼓掌][鼓掌][爱心][鼓掌][鼓掌][鼓掌][鼓掌]\n"
				+ "还等什么？<a href='http://www.baidu.com'>早到早得哦</a>~[勾引]");
		return MessageUtil.textMessageToXml(textMessage);
	}
}
