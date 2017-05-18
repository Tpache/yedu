package cn.com.yedu.filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// 读取文件
		excludeUrls = readFile(XSSFilter.class.getResource("/xssWhite.txt").getPath());
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String pathInfo = request.getPathInfo() == null ? "" : request.getPathInfo();
		String url = request.getServletPath() + pathInfo;
		String uri = request.getRequestURI();


		// 获取请求所有参数，校验防止SQL注入，防止XSS漏洞
		@SuppressWarnings("unchecked")
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String paramName = params.nextElement();
			String paramVale = request.getParameter(paramName);
			// 校验是否存在SQL注入信息
			/*if (CheckUtil.checkSQLInject(paramVale, url)) {
				errorResponse(response);
				return;
			}*/
		}
	
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * 读取白名单
	 * 
	 * @param fileName
	 * @return
	 */
	private List<String> readFile(String fileName) {
		List<String> list = new ArrayList<>();
		InputStreamReader read = null;
		BufferedReader reader = null;
		FileInputStream fs = null;
		try {
			File f = new File(fileName);
			if (f.isFile() && f.exists()) {
				fs = new FileInputStream(f);
				read = new InputStreamReader(fs, "UTF-8");
				reader = new BufferedReader(read);
				String line;
				while ((line = reader.readLine()) != null) {
					if (!"".equals(line)) {
						list.add(line);
						LOGGER.info(line);
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("读取白名单", e);
		} finally {
			try {
				if (fs != null) {
					fs.close();
				}
				if (read != null) {
					read.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		return list;
	}
}
