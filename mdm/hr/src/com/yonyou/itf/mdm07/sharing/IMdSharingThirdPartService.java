package com.yonyou.itf.mdm07.sharing;

/**
 * MDM数据共享服务。(由第三方系统提供，MDM调用)
 * 
 * 实现类需要加上以下注解
 * @WebService(name="IMdSharingThirdPartService", serviceName="IMdSharingThirdPartService", targetNamespace="http://sharing.mdm07.itf.yonyou.com/")
 * 
 * @author zhangdqb
 * @date Sep 13, 2013 9:55:35 AM
 */
public interface IMdSharingThirdPartService {
	
	/**
	 * 取得对应主数据的总数
	 * 
	 * @param type
	 * @return
	 */
	public OuterSystemRetVO getRemoteMdCount(String type);
	
	/**
	 * 从第三方系统装载指定类型数据
	 * 
	 * @param type : 主数据类型
	 * @return
	 */
	public OuterSystemRetVO loadMd(String type);
	
	/**
	 * 从第三方系统分批装载指定类型数据
	 * 
	 * @param type
	 * @param batchSize
	 * @param batchIndex
	 * @return
	 */
	public OuterSystemRetVO loadMdBatch(String type,int batchSize,int batchIndex);
	
	/**
	 * 分发指定主数据至第三方系统。
	 * 
	 * @param type
	 * @param action
	 * @param masterData
	 * @return 分发成功时需要返回关系映射List<MdMapingVO>
	 */
	public OuterSystemRetVO distributeMd(String type,String action,String masterData);
	
}
