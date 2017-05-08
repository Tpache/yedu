package cn.com.yedu.dao;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

public interface ITextMessageDao {

	public Map<String,String> getTextMessageRes(@RequestParam("msgType")String msgType,@RequestParam("type")String type);
	
}
