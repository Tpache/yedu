package cn.com.yedu.listener;

import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import cn.com.yedu.service.IAccessTokenService;

public class AccessTokenListener implements ServletContextListener {

	private static Logger logger = Logger.getLogger(AccessTokenListener.class);

	/*@Resource
	public IAccessTokenService accessTokenService;*/
	private MyThread myThread;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//更新AccessToken
//		accessTokenService.updateAccessTokenByAppId();
		String str = null;
		if (str == null && myThread == null) {
			myThread = new MyThread();
			myThread.start(); // servlet 上下文初始化时启动 socket
		}
		
		/*//使用TimerTask定时器
		Timer timer = new Timer();  
		timer.schedule(new MyTimerTask(), 1000, 2000);*/  
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("服务关闭……");
		if (myThread != null && myThread.isInterrupted()) {
			myThread.interrupt();
		}

	}

}

/**
 * 自定义一个 Class 线程类继承自线程类，重写 run() 方法，用于从后台获取并处理数据
 * 
 * @author Champion.Wong
 * 
 */
class MyThread extends Thread {
	public void run() {
		while (!this.isInterrupted()) {// 线程未中断执行循环
			try {
				// ------------------ 开始执行 ---------------------------
				System.out.println("____ACTION TIME:" + System.currentTimeMillis());
				Thread.sleep(5000*2); // 每隔2000ms执行一次
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

class MyTimerTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("____ACTION TIME____:" + System.currentTimeMillis());
	}
	
}
