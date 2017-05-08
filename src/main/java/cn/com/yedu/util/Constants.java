package cn.com.yedu.util;

public class Constants {
	/**
	 * APPID
	 */
	public static String APPID = "wx52e8ee1150fe3a42";
	/**
	 * SECRET
	 */
	public static String SECRET = "3b69f4a0443558fae7c088bb784c2e5e";
	/**
	 * 获取ACCESS_TOKEN接口
	 */
	public static String GET_ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	/**
	 * ACCESS_TOKEN有效时间(单位：ms)
	 */
	public static int EFFECTIVE_TIME = 700000;
	/**
	 * conf.properties文件路径
	 */
	public static String CONF_PROPERTIES_PATH = "src/conf/config.properties";
	/**
	 * 微信接入token ，用于验证微信接口
	 */
	public static String TOKEN = "abc123";
	
	
	//请求处理失败
	public static String REQUEST_ERR = "请求处理异常，请稍候尝试！";
	//关注欢迎语
	public static String WELOME_SUBSCRIBE = "小编在此候你多时了。。。。"; 
	
	//关注欢迎语
	public static String UNSUBSCRIBE_FAREWELL = "拜拜了您，慢走！";
}