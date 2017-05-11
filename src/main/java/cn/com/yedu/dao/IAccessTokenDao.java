package cn.com.yedu.dao;

import org.springframework.web.bind.annotation.RequestParam;

import cn.com.yedu.pojo.AccessToken;

public interface IAccessTokenDao {
	
	public AccessToken getLocalAccessToken(@RequestParam("appId")String appId);
	public void updateAccessTokenByAppId(@RequestParam("accessToken")AccessToken accessToken); 
}
