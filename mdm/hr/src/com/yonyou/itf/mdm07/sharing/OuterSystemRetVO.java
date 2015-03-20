package com.yonyou.itf.mdm07.sharing;

import java.util.List;

/**
 * 主数据系统访问第三方系统返回VO
 * 
 * @author zhangdqb
 * @date Sep 24, 2013 10:58:46 AM
 */
public class OuterSystemRetVO {

	/**
	 * 业务数据(json)
	 */
	private String data;
	
	/**
	 * 业务系统回写的业务数据ＩＤ（有顺序）
	 */
	private List<MdMapingVO> mdMapings;
	
	/**
	 * 调用是否成功
	 */
	private boolean success;
	
	/**
	 * 第三方业务系统数据的状态，如存在于否等　TODO 考虑枚举类型
	 */
	private String dataState;
	
	/**
	 * 第三方服务里的异常信息
	 */
	private String errorMsg;
	
	/**
	 * 分发失败的主数据编码
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
