package cn.com.yedu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import cn.com.yedu.dao.IMenuDao;
import cn.com.yedu.pojo.ComplexButton;
import cn.com.yedu.pojo.Menu;
import cn.com.yedu.pojo.ViewButton;
import cn.com.yedu.service.IMenuService;
import net.sf.json.JSONObject;

@Service("menuService")
public class MenuServiceImpl implements IMenuService{

	@Resource
	public IMenuDao menuDao;
	
	@Override
	public String generateMenu(String appId) {
		Menu menu = new Menu();
		List<Map<String, String>> firstLevelMenus = menuDao.generateMenu(appId,null);
		List<ComplexButton> complexButtons = new ArrayList<ComplexButton>();
		if(null != firstLevelMenus && firstLevelMenus.size() > 0){
			ComplexButton complexButton;
			for (Map<String, String> firsrMap : firstLevelMenus) {
				complexButton = new ComplexButton();
				complexButton.setName(firsrMap.get("name"));
				List<Map<String, String>> secendLevelMenus = menuDao.generateMenu(appId,firsrMap.get("id"));
				if(null != secendLevelMenus && secendLevelMenus.size() > 0){
					List<ViewButton> viewButtons = new ArrayList<ViewButton>();
					ViewButton viewButton;
					for (Map<String, String> secendmap : secendLevelMenus) {
						viewButton = new ViewButton();
						viewButton.setName(secendmap.get("name"));
						viewButton.setType(secendmap.get("type"));
						viewButton.setKey(secendmap.get("key"));
						viewButton.setUrl(secendmap.get("url"));
						viewButtons.add(viewButton);
					}
					complexButton.setSub_button(viewButtons);
				}
				complexButtons.add(complexButton);
			}
			menu.setButton(complexButtons);
		}
		return JSONObject.fromObject(menu).toString();
	}
	
}
