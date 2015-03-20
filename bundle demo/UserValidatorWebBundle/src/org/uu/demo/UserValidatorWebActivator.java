package org.uu.demo;

import javax.servlet.Servlet;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.uu.demo.web.servlet.LoginServlet;

/**
 * desc: ���ڴ�ͳ�ķ�ʽ��ɷ�������úͼ��� 
 *
 * @author jerry
 */
public class UserValidatorWebActivator implements BundleActivator,ServiceListener{

	// ------------------------------------------------Instance Variables
	
	private BundleContext bc;
	
	private ServiceReference ref;
	
	private Servlet servlet;
	
	// ------------------------------------------------Public Method
	
	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		bc=context;
		servlet=new LoginServlet(bc);
		registerServlet();
		context.addServiceListener(this, "(objectClass=" + HttpService.class.getName() +
	            ")");
	}

	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		try {
            unregisterServlet();
        } catch (Throwable t) {
            t.printStackTrace();
        }

        servlet = null;
        bc = null;
        ref = null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.ServiceListener#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	public void serviceChanged(ServiceEvent event) {
		switch (event.getType()){
            case ServiceEvent.REGISTERED:
                registerServlet();
                break;

            case ServiceEvent.UNREGISTERING:
                unregisterServlet();
                break;
        }
	}
	
	// ------------------------------------------------Private Method
	
	/*
	 * ע��WebӦ��
	 */
	private void registerServlet(){
		if (ref == null)
        {
            ref = bc.getServiceReference(HttpService.class.getName());
        }
	 
        if (ref != null) 
        {
            try {
                HttpService http = (HttpService) bc.getService(ref);
				http.registerServlet("/demo/login", servlet, null, null);
				http.registerResources("/demo/page","page",null);
				System.out.println("�������û���¼��֤webģ�飬��ͨ��/demo/page/login.htm����");
            } 
			catch (Exception e) {
				e.printStackTrace();
			}
        }
	}
	
	/*
	 * ж��WebӦ��
	 */
	private void unregisterServlet(){
		if (ref != null) 
        {
            try {
                HttpService http = (HttpService) bc.getService(ref);
                http.unregister("/demo/login");
                http.unregister("/demo/page");
                System.out.println("��ж���û���¼��֤webģ�飡");
            }
            catch(Exception e){
            	e.printStackTrace();
            }
        }
	}

}
