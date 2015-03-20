package com.ufida.dictqueryweb;

import javax.servlet.Servlet;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

import com.ufida.dictqueryweb.servlet.DictQueryServlet;

public class Activator implements BundleActivator, ServiceListener {

	private BundleContext context;
	private ServiceReference serviceRef;
	private Servlet servlet;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		context = bundleContext;
		
		//创建servlet
		servlet = new DictQueryServlet(context);
		
		//向HttpService注册 servlet
		registerServlet();
		
		//加入对HttpService的监听
		context.addServiceListener(this, "(objectClass=" + HttpService.class.getName() +
	            ")");
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		try {
			//注销Servlet
            unregisterServlet();
        } catch (Throwable t) {
            t.printStackTrace();
        }

        servlet = null;
        context = null;
        serviceRef = null;
	}
	

	/**
	 * 注册Web应用
	 */
	private void registerServlet() {
		if (serviceRef == null){
			serviceRef = context.getServiceReference(HttpService.class.getName());
        }
	 
        if (serviceRef != null){
            try {
                HttpService http = (HttpService) context.getService(serviceRef);
                if(null != http){
                	//注册Servlet
					http.registerServlet("/demo/dictquery", servlet, null, null);
					
					//注册资源
					http.registerResources("/demo/page","page",null);
					System.out.println("已启动字典查询web模块，请通过/demo/page/dictquery.htm访问");
                }
            } 
			catch (Exception e) {
				e.printStackTrace();
			}
        }
		
	}

	/**
	 * 卸载Web应用
	 */
	private void unregisterServlet() {
		if (serviceRef != null) {
            try {
                HttpService http = (HttpService) context.getService(serviceRef);
                if(null != http){
	                http.unregister("/demo/dictquery");
	                http.unregister("/demo/page");
	                System.out.println("已卸载字典查询web模块！");
                }
            }
            catch(Exception e){
            	e.printStackTrace();
            }
        }
	}

	@Override
	public void serviceChanged(ServiceEvent event) {
		switch (event.getType()){
        case ServiceEvent.REGISTERED:
        	//HttpService注册到OSGi容器的时候，进行Servlet的注册
            registerServlet();
            break;

        case ServiceEvent.UNREGISTERING:
        	//HttpService从OSGi容器注销的时候，注销Servlet
            unregisterServlet();
            break;
    }
	}

}
