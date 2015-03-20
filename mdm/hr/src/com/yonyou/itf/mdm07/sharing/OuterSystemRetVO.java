package com.yonyou.itf.mdm07.sharing;

import java.util.List;

/**
 * ������ϵͳ���ʵ�����ϵͳ����VO
 * 
 * @author zhangdqb
 * @date Sep 24, 2013 10:58:46 AM
 */
public class OuterSystemRetVO {

	/**
	 * ҵ������(json)
	 */
	private String data;
	
	/**
	 * ҵ��ϵͳ��д��ҵ�����ݣɣģ���˳��
	 */
	private List<MdMapingVO> mdMapings;
	
	/**
	 * �����Ƿ�ɹ�
	 */
	private boolean success;
	
	/**
	 * ������ҵ��ϵͳ���ݵ�״̬��������ڷ�ȡ�TODO ����ö������
	 */
	private String dataState;
	
	/**
	 * ��������������쳣��Ϣ
	 */
	private String errorMsg;
	
	/**
	 * �ַ�ʧ�ܵ������ݱ���
	 */
	private List<String> mdmCodes;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDataState() {
		return dataState;
	}

	public void setDataState(String dataState) {
		this.dataState = dataState;
	}

	public List<MdMapingVO> getMdMapings() {
		return mdMapings;
	}

	public void setMdMapings(List<MdMapingVO> mdMapings) {
		this.mdMapings = mdMapings;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<String> getMdmCodes() {
		return mdmCodes;
	}

	public void setMdmCodes(List<String> mdmCodes) {
		this.mdmCodes = mdmCodes;
	}
}
