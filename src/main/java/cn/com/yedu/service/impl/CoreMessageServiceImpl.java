package cn.com.yedu.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.com.yedu.service.ICoreMessageService;
import cn.com.yedu.util.Constants;
import cn.com.yedu.util.MessageUtil;


@Service("coreMessageService")
public class CoreMessageServiceImpl implements ICoreMessageService{

	
	
	public String processRequest(HttpServletRequest request) {
		String result = Constants.REQUEST_ERR;
		try {
			Map<String, String> messages = MessageUtil.parseXml(request);
			if(MessageUtil.EVENT_TYPE_SUBSCRIBE.equals(messages.get("MsgType"))){//事件类型：subscribe(订阅) 
				
				result = Constants.WELOME_SUBSCRIBE;
				
			}if(MessageUtil.EVENT_TYPE_UNSUBSCRIBE.equals(messages.get("MsgType"))){//事件类型：unsubscribe(取消订阅) 
				
				result = Constants.UNSUBSCRIBE_FAREWELL;
				
			}else if(MessageUtil.RESP_MESSAGE_TYPE_TEXT.equals(messages.get("MsgType"))){//文本消息
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
