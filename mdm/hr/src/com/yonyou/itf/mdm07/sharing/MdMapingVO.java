package com.yonyou.itf.mdm07.sharing;

/**
 * ��������ҵ������ӳ��֣�
 * 
 * @author zhangdqb
 * @date Oct 10, 2013 11:40:21 AM
 */
public class MdMapingVO {

	//�����ݱ���
	private String mdmCode;
	
	//ʵ�����
	private String entityCode;
	
	//ҵ�����ݣɣ�
	private String busiDataId;

	public String getMdmCode() {
		return mdmCode;
	}

	public void setMdmCode(String mdmCode) {
		this.mdmCode = mdmCode;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	public String getBusiDataId() {
		return busiDataId;
	}

	public void setBusiDataId(String busiDataId) {
		this.busiDataId = busiDataId;
	}

	@Override
	public String toString() {
		return "[mdmCode=" + mdmCode + ", entityCode=" + entityCode
				+ ", busiDataId=" + busiDataId + "]";
	}
}
