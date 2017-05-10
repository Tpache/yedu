package cn.com.yedu.service.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import cn.com.yedu.pojo.Button;
import cn.com.yedu.pojo.ComplexButton;
import cn.com.yedu.pojo.Menu;
import cn.com.yedu.pojo.ViewButton;
import cn.com.yedu.service.IMenuService;

@Service("menuService")
public class MenuServiceImpl implements IMenuService{

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Menu createMenu() {
		
		Menu menu = new Menu();
		
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
		mainButton1.setSub_button(new ArrayList(Arrays.asList(new Button[]{viewButton1_1,viewButton1_2})));
		
		
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
		mainButton2.setSub_button(new ArrayList(Arrays.asList(new ViewButton[]{viewButton2_1,viewButton2_2,viewButton2_3})));
		
		
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
		mainButton3.setSub_button(new ArrayList(Arrays.asList(new ViewButton[]{viewButton3_1,viewButton3_2})));
		menu.setButton(new ArrayList(Arrays.asList(new ComplexButton[]{mainButton1,mainButton2,mainButton3})));
		
		return menu;
	}

}
