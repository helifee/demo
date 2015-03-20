package com.yonyou.itf.mdm07.sharing;

/**
 * MDM���ݹ������(�ɵ�����ϵͳ�ṩ��MDM����)
 * 
 * ʵ������Ҫ��������ע��
 * @WebService(name="IMdSharingThirdPartService", serviceName="IMdSharingThirdPartService", targetNamespace="http://sharing.mdm07.itf.yonyou.com/")
 * 
 * @author zhangdqb
 * @date Sep 13, 2013 9:55:35 AM
 */
public interface IMdSharingThirdPartService {
	
	/**
	 * ȡ�ö�Ӧ�����ݵ�����
	 * 
	 * @param type
	 * @return
	 */
	public OuterSystemRetVO getRemoteMdCount(String type);
	
	/**
	 * �ӵ�����ϵͳװ��ָ����������
	 * 
	 * @param type : ����������
	 * @return
	 */
	public OuterSystemRetVO loadMd(String type);
	
	/**
	 * �ӵ�����ϵͳ����װ��ָ����������
	 * 
	 * @param type
	 * @param batchSize
	 * @param batchIndex
	 * @return
	 */
	public OuterSystemRetVO loadMdBatch(String type,int batchSize,int batchIndex);
	
	/**
	 * �ַ�ָ����������������ϵͳ��
	 * 
	 * @param type
	 * @param action
	 * @param masterData
	 * @return �ַ��ɹ�ʱ��Ҫ���ع�ϵӳ��List<MdMapingVO>
	 */
	public OuterSystemRetVO distributeMd(String type,String action,String masterData);
	
}
