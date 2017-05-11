package cn.com.yedu.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yedu.dao.IAccessTokenDao;
import cn.com.yedu.pojo.AccessToken;
import cn.com.yedu.service.IAccessTokenService;
import cn.com.yedu.util.Constants;
import cn.com.yedu.util.HttpUtils;
import net.sf.json.JSONObject;

@Service("accessTokenService")
public class AccessTokenServiceImpl implements IAccessTokenService {

	@Resource
	public IAccessTokenDao accessTokenDao;

	public String getLocalAccessToken() {
		AccessToken accessToken = accessTokenDao.getLocalAccessToken(Constants.APPID);
		// 为空时重新获取accessToken 否则验证accessToken是否有效
		if (null == accessToken || null == accessToken.getAccessToken()) {
			JSONObject jsonObject = HttpUtils.httpRequest(Constants.GET_ACCESSTOKEN_URL
					.replace("APPID", Constants.APPID).replace("APPSECRET", Constants.APPSECRET), "GET", null,
					Constants.APPID, Constants.APPSECRET);
			if (null != jsonObject && jsonObject.containsKey("access_token")) {
				accessToken = new AccessToken();
				accessToken.setAppId(Constants.APPID);
				accessToken.setAppSecret(Constants.APPSECRET);
				accessToken.setAccessToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
				accessToken.setCrtTime(new Date());
				accessTokenDao.updateAccessTokenByAppId(accessToken);
			}
		} else {
			long sdate = accessToken.getCrtTime().getTime() + accessToken.getExpiresIn() * 1000;
			if (new Date().after(new Date(sdate))) {
				JSONObject jsonObject = HttpUtils.httpRequest(Constants.GET_ACCESSTOKEN_URL
						.replace("APPID", Constants.APPID).replace("APPSECRET", Constants.APPSECRET), "GET", null,
						Constants.APPID, Constants.APPSECRET);
				if (null != jsonObject && jsonObject.containsKey("access_token")) {
					accessToken = new AccessToken();
					accessToken.setAppId(Constants.APPID);
					accessToken.setAppSecret(Constants.APPSECRET);
					accessToken.setAccessToken(jsonObject.getString("access_token"));
					accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
					accessToken.setCrtTime(new Date());
					accessTokenDao.updateAccessTokenByAppId(accessToken);
				}
			}
		}
		return accessToken.getAccessToken();
	}

	public void updateAccessTokenByAppId() {
		JSONObject jsonObject = HttpUtils.httpRequest(Constants.GET_ACCESSTOKEN_URL
				.replace("APPID", Constants.APPID).replace("APPSECRET", Constants.APPSECRET), "GET", null,
				Constants.APPID, Constants.APPSECRET);
		if (null != jsonObject && jsonObject.containsKey("access_token")) {
			AccessToken accessToken = new AccessToken();
			accessToken.setAppId(Constants.APPID);
			accessToken.setAppSecret(Constants.APPSECRET);
			accessToken.setAccessToken(jsonObject.getString("access_token"));
			accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			accessToken.setCrtTime(new Date());
			accessTokenDao.updateAccessTokenByAppId(accessToken);
		}
	}

}
