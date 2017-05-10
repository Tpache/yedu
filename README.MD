微信公共平台java开发

微信接入接口    域名/yedu/signContr/api.html GET方法

发送消息接口  域名/yedu/signContr/api.html POST方法

项目启动
	调用监听器 AccessTokenListener 获取AccessToken 并 创建menu菜单
	该监听器使用多线程，每(2*60*60*1000 - 2*1000)调用一次 、两个小时减去2分钟
		保证AccessToken是最新的值