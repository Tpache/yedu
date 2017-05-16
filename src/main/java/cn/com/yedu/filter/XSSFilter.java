package cn.com.yedu.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

/**
 * @author Administrator
 *	非法字符过滤器（防SQL注入，防XSS漏洞）
 */
public class XSSFilter implements Filter  {

	private static final Logger LOGGER = Logger.getLogger(XSSFilter.class);

	/**
	 * 排除部分URL不做过滤
	 */
	private List<String> excludeUrls = new ArrayList<>();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
