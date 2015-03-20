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
//		System.out.println("主数据类型：" + type);
//		System.out.println("查询开始时间：" + new Date());
//		
//		MdmRetVO mdmRetVO = mdSharingCenterService.queryListMdByType(systemId, type);
//		Date endTime = new Date();
//		System.out.println("查询结束时间：" + endTime);
//		System.out.println("查询总时间：" + (endTime.getTime() - startTime.getTime()) / 1000 + "s");
//		
//		
//		File md = new File(getFilePath(type));
//		BufferedWriter pw = null;
//		try {
//			pw = new BufferedWriter(new FileWriter(md));
//			pw.write(mdmRetVO.getData());
//			pw.flush();
//		} catch (IOException e) {
//			throw new RuntimeException("写入文件失败", e);
//		} finally {
//			IOUtils.closeQuietly(pw);
//		}
//		
//		
////		List<Map<String, Object>> mdList = gson.fromJson(mdmRetVO.getData(), new TypeToken<List<Map<String, Object>>>(){}.getType());
////		
////		List<MdMapingVO> mdMappings = new ArrayList<MdMapingVO>();
////		new ExcelUtil().writeToExcel(mdList, type, type, mdMappings);//TODO 映射关系需要自已回写。
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
