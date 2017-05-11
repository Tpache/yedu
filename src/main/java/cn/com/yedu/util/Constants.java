package cn.com.yedu.util;

public class Constants {
	/**
	 * APPID
	 */
	public static String APPID = "wxafa3acec3c315f4d";
	/**
	 * SECRET
	 */
	public static String APPSECRET = "ddd55a78b563cbf8d926377b1f0758a2";
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
	public static String TOKEN = "521yedu";
	
	
	//请求处理失败
	public static String REQUEST_ERR = "请求处理异常，请稍候尝试！";
	//关注欢迎语
	public static String WELOME_SUBSCRIBE = "小编在此候你多时了。。。。"; 
	
	//关注欢迎语
	public static String UNSUBSCRIBE_FAREWELL = "拜拜了您，慢走！";
}
