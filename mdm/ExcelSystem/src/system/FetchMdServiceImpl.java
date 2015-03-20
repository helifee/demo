//package system;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Date;
//
//import org.apache.poi.util.IOUtils;
//
//import com.ufida.eip.comp.annotation.Reference;
//import com.ufida.eip.util.EIPRuntime;
//import com.yonyou.itf.mdm07.sharing.IMdSharingCenterServicePortType;
//import com.yonyou.itf.mdm07.sharing.MdmRetVO;
//
//public class FetchMdServiceImpl implements FetchMdService {
//	
//	@Reference
//	private IMdSharingCenterServicePortType mdSharingCenterService;
//
////	private Gson gson = new Gson();
//
//	@Override
//	public String fetchMd(String systemId, String type) {
//		
//		Date startTime = new Date();
//		System.out.println("���������ͣ�" + type);
//		System.out.println("��ѯ��ʼʱ�䣺" + new Date());
//		
//		MdmRetVO mdmRetVO = mdSharingCenterService.queryListMdByType(systemId, type);
//		Date endTime = new Date();
//		System.out.println("��ѯ����ʱ�䣺" + endTime);
//		System.out.println("��ѯ��ʱ�䣺" + (endTime.getTime() - startTime.getTime()) / 1000 + "s");
//		
//		
//		File md = new File(getFilePath(type));
//		BufferedWriter pw = null;
//		try {
//			pw = new BufferedWriter(new FileWriter(md));
//			pw.write(mdmRetVO.getData());
//			pw.flush();
//		} catch (IOException e) {
//			throw new RuntimeException("д���ļ�ʧ��", e);
//		} finally {
//			IOUtils.closeQuietly(pw);
//		}
//		
//		
////		List<Map<String, Object>> mdList = gson.fromJson(mdmRetVO.getData(), new TypeToken<List<Map<String, Object>>>(){}.getType());
////		
////		List<MdMapingVO> mdMappings = new ArrayList<MdMapingVO>();
////		new ExcelUtil().writeToExcel(mdList, type, type, mdMappings);//TODO ӳ���ϵ��Ҫ���ѻ�д��
//		
//		return null;
//	}
//	
//	private String getFilePath(String type) {
//		String esbHome = EIPRuntime.getInstance().getServerHome();
//		String dir = "/solutions/excel/output/";
//		return esbHome + dir + type + ".txt";
//	}
//
//
//	public IMdSharingCenterServicePortType getMdSharingCenterService() {
//		return mdSharingCenterService;
//	}
//
//
//	public void setMdSharingCenterService(
//			IMdSharingCenterServicePortType mdSharingCenterService) {
//		this.mdSharingCenterService = mdSharingCenterService;
//	}
//
//}
