package cn.com.yedu.service.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.com.yedu.dao.ITextMessageDao;
import cn.com.yedu.service.ICoreMessageService;
import cn.com.yedu.util.Constants;
import cn.com.yedu.util.MessageUtil;
import cn.com.yedu.util.res.ResMessageUtil;


@Service("coreMessageService")
public class CoreMessageServiceImpl implements ICoreMessageService{

	@Resource
	public ITextMessageDao textMessageDao;
	
	
	public String processRequest(HttpServletRequest request) {
		String result = Constants.REQUEST_ERR;
		try {
			Map<String, String> messages = MessageUtil.parseXml(request);
            String fromUserName = messages.get("FromUserName");//发送方账号（open_id）
            String toUserName = messages.get("ToUserName");//公众账号
            String msgType = messages.get("MsgType");            //消息类型
			if(MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msgType)){//文本消息
				
				result = ResMessageUtil.getTextMessage(fromUserName,toUserName,messages.get("Content"));
				
			}else if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)){
				String eventType = messages.get("Event");
				
				if(MessageUtil.EVENT_TYPE_SUBSCRIBE.equals(eventType)){//事件类型：subscribe(订阅) 
					
					result = ResMessageUtil.getTextMessage(fromUserName,toUserName,Constants.WELOME_SUBSCRIBE);
					
				}else if(MessageUtil.EVENT_TYPE_UNSUBSCRIBE.equals(eventType)){//事件类型：unsubscribe(取消订阅) 
					
				}
			}else if(MessageUtil.REQ_MESSAGE_TYPE_LOCATION.equals(msgType)){
				String latitude = messages.get("Latitude");//<>23.137466</Latitude>
				String longitude = messages.get("Longitude");//<>113.352425</Longitude>
				String pecision = messages.get("Precision");//<>119.385040</Precision>
				System.out.println("latitude--->"+latitude +"    longitude--->"+longitude +"    pecision--->"+pecision);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
