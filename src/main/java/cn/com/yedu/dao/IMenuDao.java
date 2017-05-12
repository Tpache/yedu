package cn.com.yedu.dao;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

public interface IMenuDao {

	public Map<String,String> generateMenu(@RequestParam("appId") String appId,@RequestParam("parentId")String parentId);
	
}
