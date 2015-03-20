package com.ufida.localdictquery;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.ufida.dictquery.query.QueryService;
import com.ufida.localdictquery.impl.LocalDictQueryServiceImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;

	private ServiceRegistration sr = null;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		sr = Activator.context.registerService(QueryService.class.getName(),
				new LocalDictQueryServiceImpl(), null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		sr.unregister();
		Activator.context = null;
	}

}
