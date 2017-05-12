package cn.com.yedu.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yedu.dao.IMenuDao;
import cn.com.yedu.service.IMenuService;

@Service("menuService")
public class MenuServiceImpl implements IMenuService{

	@Resource
	public IMenuDao menuDao;
	
	@Override
	public String generateMenu(String appId) {
		Map<String, String>  firstLevelMenus = menuDao.generateMenu(appId,"");
		return firstLevelMenus.toString();
	}
	
}
