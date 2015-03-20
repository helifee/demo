package system;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import tool.Constants;
import tool.ExcelUtil;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ufida.eip.util.EIPRuntime;
import com.yonyou.itf.mdm07.sharing.IMdSharingThirdPartServicePortType;
import com.yonyou.itf.mdm07.sharing.MdMapingVO;
import com.yonyou.itf.mdm07.sharing.OuterSystemRetVO;

public class WSPublishServiceImpl implements IMdSharingThirdPartServicePortType {
	
	private Gson gson = new Gson();
	
	@Override
	public OuterSystemRetVO loadMd(String mdType) {
		
		OuterSystemRetVO retVo = new OuterSystemRetVO();
		List<Map<String, Object>> mdList = null;
		try {
			mdList = new ExcelUtil().getMdFromExcel(mdType, 0, 0);
		} catch(RuntimeException e) {
			retVo.setErrorMsg(e.getMessage());
			retVo.setSuccess(false);
		}
		
		String mdJson = null;
		if(mdList != null && mdList.size() > 0) {
			mdJson = gson.toJson(mdList);
		}
		
		//�����ؽ����
		retVo.setData(mdJson);
		
		return retVo;
	}

	@Override
	public OuterSystemRetVO distributeMd(String mdType, String action, String masterData) {
		
		OuterSystemRetVO retVO = new OuterSystemRetVO();
		if(StringUtils.isEmpty(mdType) || StringUtils.isEmpty(masterData)) {
			retVO.setErrorMsg("����Ϊ��mdType:" + mdType + ", md:" + masterData + ", ���鴫��Ĳ�����");
			retVO.setSuccess(false);
			return retVO;
		}
		
		List<MdMapingVO> mdMapings = new ArrayList<MdMapingVO>();
		retVO.setMdMapings(mdMapings);
		List<Map<String, Object>> mdList = gson.fromJson(masterData, new TypeToken<List<Map<String, Object>>>(){}.getType());
		
		String entityCode = Constants.mdTypeToVoType.get(mdType);
		if(mdList != null && !mdList.isEmpty()) {
			for(Map<String, Object> mdMap : mdList) {
				String id = (String) mdMap.get("id");
				if(StringUtils.isEmpty(id)) {
					MdMapingVO mapping = new MdMapingVO();
					mapping.setEntityCode(entityCode);
					id = String.valueOf(new Date().getTime());	//��ʱȡ��ǰʱ�����Ϊ����ID
					mapping.setBusiDataId(id);
					mapping.setMdmCode((String) mdMap.get("mdm_code"));
					mdMapings.add(mapping);
				}				
			}
		}
		retVO.setMdMapings(mdMapings);
		
		//��������������ļ���ʵʩʱ�ɵ��������д�����յ�������
		writeToFile(masterData, mdType);
		
		
//		if(StringUtils.isEmpty(voType)) {
//			retVO.setErrorMsg("��������Ӧ��ӳ���ϵ�������ݱ��룺" + mdType);
//			retVO.setSuccess(false);
//			return retVO;
//		}
//
//		//д��EXCEL
//		try{
//			new ExcelUtil().writeToExcel(mdList, voType.trim(), mdType, mdMapings);
//		} catch (RuntimeException e) {
//			
//			//�����쳣��Ϣ
//			retVO.setErrorMsg(e.getMessage());
//			retVO.setMdMapings(null);
//			retVO.setSuccess(false);
//			return retVO;
//		}
		
		retVO.setSuccess(true);
		return retVO;
	}
	
	/**
	 * ����ESB���ɵ��࣬ȡ��MDMʵ����룬Ŀǰ���������ע����ַ�������ȡ
	 * 
	 * @param mdType
	 * @return
	 */
	private String getEntityCode(String mdType) {
		Class<?> voClazz = null;
		String voType = Constants.mdTypeToVoType.get(mdType);
		try {
			voClazz = Class.forName(voType);
		} catch (Exception e) {
			throw new RuntimeException("û���ҵ���Ӧ����:" + voType);
		}
		String annotationInfo = voClazz.getAnnotation(javax.xml.bind.annotation.XmlType.class).toString();
		int index = annotationInfo.indexOf("name=");
		annotationInfo = annotationInfo.substring(index);
		return annotationInfo.substring(5, annotationInfo.indexOf(","));
	}
	
//	private String getShortName(String fullName) {
//		int index = fullName.lastIndexOf(".");
//		if(index != -1) {
//			return fullName.substring(index + 1);
//		}
//		return fullName;
//	}
	
	private void writeToFile(String md, String filename) {
		
		String esbHome = EIPRuntime.getInstance().getServerHome();
		String dir = "/solutions/excel/output/";
		filename = esbHome + dir + filename + ".txt";
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			writer.write(md);
			writer.flush();
			writer.close();
		} catch(Exception e) {
			throw new RuntimeException("��������ݵ��ļ�ʧ�� : " + filename, e);
		}
	}

	@Override
	public OuterSystemRetVO getRemoteMdCount(String mdType) {
		OuterSystemRetVO retVo = new OuterSystemRetVO();
		int mdCount = 0;
		try {
			mdCount = new ExcelUtil().getMdCountFromExcel(mdType);
		}catch(Exception e) {
			retVo.setErrorMsg(e.getMessage());
			retVo.setSuccess(false);
			return retVo;
		}
		
		//�����ؽ����
		retVo.setData(String.valueOf(mdCount));
		retVo.setSuccess(true);
		
		return retVo;
	}

	@Override
	public OuterSystemRetVO loadMdBatch(String mdType,
			Integer batchSize, Integer batchIndex) {
		OuterSystemRetVO retVo = new OuterSystemRetVO();
		List<Map<String, Object>> mdList = null;
		try {
			mdList = new ExcelUtil().getMdFromExcel(mdType, batchSize, batchIndex);
		} catch(RuntimeException e) {
			retVo.setErrorMsg(e.getMessage());
			retVo.setSuccess(false);
		}

		String mdJson = null;
		if(mdList != null && mdList.size() > 0) {
			mdJson = gson.toJson(mdList);
		}
		
		//�����ؽ����
		retVo.setData(mdJson);
		
		return retVo;
	}
}
