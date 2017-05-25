package cn.com.yedu.util;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import cn.com.yedu.service.IMenuService;
import net.sf.json.JSONObject;

public class MenuUtils {
	
	private static Logger logger = Logger.getLogger(MenuUtils.class);
	/**
	 * @description 	:删除菜单
	 * @param :
	 * @return :
	 * @throws :
	 * @author :mpf
	 * @Date:	2017年5月12日 上午11:36:28
	 */
	public static int delMenu(String accessToken){

        int result = 0;
        //拼装删除菜单的url
        String url = PropertiesUtils.getContextProperty("DELETE_MENU_URL").replace("ACCESS_TOKEN", accessToken);
        //调用接口创建菜单
        JSONObject jsonObject = HttpUtils.httpRequest(url,"GET","","","");//PropertiesUtils.getContextProperty("APPID"),PropertiesUtils.getContextProperty("APPSECRET"));
        if(jsonObject!=null){
            if(jsonObject.containsKey("errcode") && 0!=jsonObject.getInt("errcode")){
                result = jsonObject.getInt("errcode");
                logger.error("删除菜单失败 errcode:{"+jsonObject.getInt("errcode")+"} errmsg:{"+ jsonObject.getString("errmsg")+"}");
            }
        }
        return result;
    }
	/**
	 * @description :	创建菜单
	 * @param :
	 * @return :
	 * @throws :
	 * @author :mpf
	 * @Date:	2017年5月12日 上午11:41:01
	 */
	public static int createMenu(String accessToken) {
		 int result = 0;
		//拼装删除菜单的url
        String url = PropertiesUtils.getContextProperty("CREATE_MENU_URL").replace("ACCESS_TOKEN", accessToken);
        //调用接口创建菜单
        JSONObject jsonObject = HttpUtils.httpRequest(url,"POST",MenuUtils.generateMenu(),"","");//PropertiesUtils.getContextProperty("APPID"),PropertiesUtils.getContextProperty("APPSECRET"));
        if(jsonObject!=null){
            if(jsonObject.containsKey("errcode") && 0!=jsonObject.getInt("errcode")){
                result = jsonObject.getInt("errcode");
                logger.error("创建菜单失败 errcode:{"+jsonObject.getInt("errcode")+"} errmsg:{"+ jsonObject.getString("errmsg")+"}");
            }else{
            	logger.error("创建菜单成功");
            }
        }
		 
		
		/*Menu menu = new Menu();

		ViewButton viewButton1_1 = new ViewButton();
		viewButton1_1.setName("直播间");
		viewButton1_1.setType("view");
		viewButton1_1.setUrl("http://www.baidu.com");

		ViewButton viewButton1_2 = new ViewButton();
		viewButton1_2.setName("外场");
		viewButton1_2.setType("view");
		viewButton1_2.setUrl("http://www.baidu.com");

		ComplexButton mainButton1 = new ComplexButton();
		mainButton1.setName("视频直播");
		mainButton1.setSub_button(new ArrayList(Arrays.asList(new Button[] { viewButton1_1, viewButton1_2 })));

		ViewButton viewButton2_1 = new ViewButton();
		viewButton2_1.setName("竞猜");
		viewButton2_1.setType("view");
		viewButton2_1.setUrl("http://www.baidu.com");
		ViewButton viewButton2_2 = new ViewButton();
		viewButton2_2.setName("寻人");
		viewButton2_2.setType("view");
		viewButton2_2.setUrl("http://www.baidu.com");
		ViewButton viewButton2_3 = new ViewButton();
		viewButton2_3.setName("寻物");
		viewButton2_3.setType("view");
		viewButton2_3.setUrl("http://www.baidu.com");

		ComplexButton mainButton2 = new ComplexButton();
		mainButton2.setName("微服务");
		mainButton2.setSub_button(
				new ArrayList(Arrays.asList(new ViewButton[] { viewButton2_1, viewButton2_2, viewButton2_3 })));

		ViewButton viewButton3_1 = new ViewButton();
		viewButton3_1.setName("建议");
		viewButton3_1.setType("view");
		viewButton3_1.setUrl("http://www.baidu.com");
		ViewButton viewButton3_2 = new ViewButton();
		viewButton3_2.setName("社区");
		viewButton3_2.setType("view");
		viewButton3_2.setUrl("http://www.baidu.com");

		ComplexButton mainButton3 = new ComplexButton();
		mainButton3.setName("直通车");
		mainButton3.setSub_button(new ArrayList(Arrays.asList(new ViewButton[] { viewButton3_1, viewButton3_2 })));
		menu.setButton(new ArrayList(Arrays.asList(new ComplexButton[] { mainButton1, mainButton2, mainButton3 })));*/

		return result;
	}
	
	public static IMenuService menuService;
	
	public static String generateMenu() {
		if(null == menuService || "".equals(menuService)){
			WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
			menuService = (IMenuService) wac.getBean("menuService");
		}
		String menuJson = menuService.generateMenu(PropertiesUtils.getContextProperty("APPID"));
		 /*JSONObject jsonObject = JSONObject.fromObject(MenuUtils.createMenu(""));
		
		 System.out.println(jsonObject);
		System.out.println(jsonObject.toString());*/
		return menuJson;
	}
}
