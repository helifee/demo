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
		
		//����servlet
		servlet = new DictQueryServlet(context);
		
		//��HttpServiceע�� servlet
		registerServlet();
		
		//�����HttpService�ļ���
		context.addServiceListener(this, "(objectClass=" + HttpService.class.getName() +
	            ")");
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		try {
			//ע��Servlet
            unregisterServlet();
        } catch (Throwable t) {
            t.printStackTrace();
        }

        servlet = null;
        context = null;
        serviceRef = null;
	}
	

	/**
	 * ע��WebӦ��
	 */
	private void registerServlet() {
		if (serviceRef == null){
			serviceRef = context.getServiceReference(HttpService.class.getName());
        }
	 
        if (serviceRef != null){
            try {
                HttpService http = (HttpService) context.getService(serviceRef);
                if(null != http){
                	//ע��Servlet
					http.registerServlet("/demo/dictquery", servlet, null, null);
					
					//ע����Դ
					http.registerResources("/demo/page","page",null);
					System.out.println("�������ֵ��ѯwebģ�飬��ͨ��/demo/page/dictquery.htm����");
                }
            } 
			catch (Exception e) {
				e.printStackTrace();
			}
        }
		
	}

	/**
	 * ж��WebӦ��
	 */
	private void unregisterServlet() {
		if (serviceRef != null) {
            try {
                HttpService http = (HttpService) context.getService(serviceRef);
                if(null != http){
	                http.unregister("/demo/dictquery");
	                http.unregister("/demo/page");
	                System.out.println("��ж���ֵ��ѯwebģ�飡");
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
        	//HttpServiceע�ᵽOSGi������ʱ�򣬽���Servlet��ע��
            registerServlet();
            break;

        case ServiceEvent.UNREGISTERING:
        	//HttpService��OSGi����ע����ʱ��ע��Servlet
            unregisterServlet();
            break;
    }
	}

}
