//package system;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Date;
//
//import org.apache.poi.util.IOUtils;
//
//import com.ufida.eip.comp.annotation.Reference;
//import com.ufida.eip.util.EIPRuntime;
//import com.yonyou.itf.mdm07.sharing.IMdSharingCenterServicePortType;
//
//public class SendMdServiceImpl implements SendMdService {
//	
//	@Reference
//	private IMdSharingCenterServicePortType mdSharingCenterService;
//
//	@Override
//	public String sendMd(String systemId, String type) {
////		List<Map<String, Object>> mdList = new ExcelUtil().getMdFromExcel(type);
//		
//		File file = new File(getFilePath(type));
//		BufferedReader br = null;
//		String md = null;
//		try {
//			br = new BufferedReader(new FileReader(file));
//			md = br.readLine();
//		} catch (IOException e) {
//			throw new RuntimeException("�����ļ�ʧ��", e);
//		} finally {
//			IOUtils.closeQuietly(br);
//		}
//		
//		Date startTime = new Date();
//		System.out.println("���������ͣ�" + type);
//		System.out.println("���Ϳ�ʼʱ�䣺" + new Date());
//		mdSharingCenterService.insertMd(systemId, type, md);
//		Date endTime = new Date();
//		System.out.println("���ͽ���ʱ�䣺" + endTime);
//		System.out.println("������ʱ�䣺" + (endTime.getTime() - startTime.getTime()) / 1000 + "s");
//		
//		return null;
//	}
//
//	public IMdSharingCenterServicePortType getMdSharingCenterService() {
//		return mdSharingCenterService;
//	}
//
//	public void setMdSharingCenterService(
//			IMdSharingCenterServicePortType mdSharingCenterService) {
//		this.mdSharingCenterService = mdSharingCenterService;
//	}
//	
//	private String getFilePath(String type) {
//		String esbHome = EIPRuntime.getInstance().getServerHome();
//		String dir = "/solutions/excel/input/";
//		return esbHome + dir + type + ".txt";
//	}
//
//}
