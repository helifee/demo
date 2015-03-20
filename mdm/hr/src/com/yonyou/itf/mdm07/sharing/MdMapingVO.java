package com.yonyou.itf.mdm07.sharing;

/**
 * 主数据与业务数据映射ＶＯ
 * 
 * @author zhangdqb
 * @date Oct 10, 2013 11:40:21 AM
 */
public class MdMapingVO {

	//主数据编码
	private String mdmCode;
	
	//实体编码
	private String entityCode;
	
	//业务数据ＩＤ
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
