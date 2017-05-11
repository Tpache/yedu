package cn.com.yedu.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import cn.com.yedu.service.IAccessTokenService;
import cn.com.yedu.service.IMenuService;

/**
 * 监听器启动获取AccessToken 并创建  底部菜单
 * @author Administrator
 *
 */
public class AccessTokenListener implements ServletContextListener {

	private static Logger logger = Logger.getLogger(AccessTokenListener.class);

	//@Resource
	public IAccessTokenService accessTokenService;
	public IMenuService menuService;
	private MyThread myThread;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		if(null == accessTokenService || "".equals(accessTokenService)){
			WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
			accessTokenService = (IAccessTokenService) wac.getBean("accessTokenService");
		}
		if(null == menuService || "".equals(menuService)){
			WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
			menuService = (IMenuService) wac.getBean("menuService");
		}
		//更新AccessToken
		accessTokenService.updateAccessTokenByAppId();
		//创建菜单
		
		/*new Thread(new Runnable() {
			public void run() {
				while (true) {// 线程未中断执行循环
					try {
						// ------------------ 开始执行 ---------------------------
						Thread.sleep(2*60*60*1000); // 每隔2000ms执行一次
						accessTokenService.updateAccessTokenByAppId();
						System.out.println("____ACTION TIME:" + System.currentTimeMillis());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}).start();*/
		
		String str = null;
		if (str == null && myThread == null) {
			myThread = new MyThread(accessTokenService);
			myThread.start();
		}
		
		/*//使用TimerTask定时器
		Timer timer = new Timer();  
		timer.schedule(new MyTimerTask(), 1000, 2000);*/  
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (myThread != null && myThread.isInterrupted()) {
			System.out.println("服务关闭……");
			myThread.interrupt();
		}

	}

}

/**
 * 自定义一个 Class 线程类继承自线程类，重写 run() 方法，用于从后台获取并处理数据
 * @author Champion.Wong
 */
class MyThread extends Thread {
	
	private static Logger logger = Logger.getLogger(MyThread.class);
	
	public IAccessTokenService accessTokenService;
	
	public MyThread(IAccessTokenService accessTokenService){
		this.accessTokenService = accessTokenService;
	}
	public void run() {
		while (!this.isInterrupted()) {// 线程未中断执行循环
			try {
				Thread.sleep(2*60/**60*/*1000); // 每2个小时执行一次
				logger.info("获取微信服务器AccessToken开始--> " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				accessTokenService.updateAccessTokenByAppId();
				logger.info("获取微信服务器AccessToken结束--> " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/*class MyTimerTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("____ACTION TIME____:" + System.currentTimeMillis());
	}
	
}*/
