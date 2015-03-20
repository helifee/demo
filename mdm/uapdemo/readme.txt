1、UAP中发布一个服务的方法
	１）写一个接口与实现类
	２）在upm文件中进行配置
	具体参考示例

２、示例upm文件中
	<extension class="nc.uap.ws.deploy.OxbWSExtensionProcessor">
		<wsdl>/uap/sample/ISampleService.wsdl</wsdl>
		<address>/uap.sample.ISampleService</address>
	</extension>
	是将UAP服务对外发布成WS服务，如果只发布UAP服务，可以去掉些配置

３、UAP模块中调用UAP服务的方法：使用ServiceLocator与NCLocator,如
	ServiceLocator.getService(ISampleService.class)
	
4、在UAP中间件中运行。