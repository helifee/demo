package com.ufida.dictqueryweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.ufida.dictquery.query.QueryService;

/**
 * 字典查询响应Servlet
 * @author zhangdqb
 *
 */
public class DictQueryServlet extends HttpServlet {

	private static final long serialVersionUID = -3628600145939932380L;
	
	private BundleContext context;
	
	public DictQueryServlet(BundleContext context) {
		this.context = context;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//读取参数
		String queryWord = req.getParameter("query_word");
		ServletOutputStream output = resp.getOutputStream();
		
		//取得服务
		QueryService queryService = null;
		ServiceReference serviceRef = context.getServiceReference(QueryService.class.getName());
		
		if(null != serviceRef) {
			queryService = (QueryService) context.getService(serviceRef);
		}
		
		if(queryService == null) {
			output.println("No available dictquery service");
			return;
		}
		
    	try {
			output.write(queryService.queryWord(queryWord).getBytes());
			return;
		} 
    	catch (Exception e) {
			output.println("Error occurs");
			output.println(e.toString());
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
