//package tool;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.xml.bind.annotation.XmlElement;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFHyperlink;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.util.StringUtil;
//
//import com.ufida.eip.log.EIPLogger;
//import com.ufida.eip.util.EIPRuntime;
//import com.yonyou.itf.mdm07.sharing.MdMapingVO;
//
//public class ExcelUtil2 {
//	
//	private HSSFWorkbook workbook = new HSSFWorkbook();;
//	
//	private Set<String> keySet = new HashSet<String>();
//
//	private Map<String, List<Object>> subDataMap;
//	
//	public List<Map<String, Object>> getMdFromExcel(String fullClassName) {
//		String fileName = getShortName(fullClassName);
//			FileInputStream fis;
//			try {
//				fis = readFile(fileName);
//			} catch (FileNotFoundException e) {
//				throw new RuntimeException("文件没有找到:" + fileName, e);
//			}
//			try {
//				workbook = new HSSFWorkbook(fis);
//			} catch (IOException e) {
//				throw new RuntimeException("构建Excel文件对象失败" + fileName, e);
//			}
//		
//		
//		List<Map<String, Object>> masterDataMap = getMasterDataFrom(workbook);
//		
//		return masterDataMap;
//	}
//	
//	public int getMdCountFromExcel(String fullClassName) {
//		String fileName = getShortName(fullClassName);
//		HSSFWorkbook workbook;
//		try {
//			FileInputStream fis = readFile(fileName);
//			workbook = new HSSFWorkbook(fis);
//		} catch(Exception e) {
//			throw new RuntimeException(e);
//		}
//		
//		HSSFSheet sheet = workbook.getSheetAt(0);
//		int rows = sheet.getPhysicalNumberOfRows() - 1;
//		return rows;
//	}
//	
//	public void writeToExcel(List<Map<String, Object>> mdList, String voType, String mdType, List<MdMapingVO> mdMappings) {
//		
//		writeMasterData(voType, mdList, mdMappings);
//		
//		writeExcelFile(workbook, getShortName(mdType));
//	}
//	
//	private void writeExcelFile(HSSFWorkbook workbook, String filename) {
//		
//		String esbHome = EIPRuntime.getInstance().getServerHome();
//		String dir = "/solutions/excel/output/";
//		filename = esbHome + dir + filename + ".xls";
//		
//		try {
//			FileOutputStream out = new FileOutputStream(filename);
//			workbook.write(out);
//			out.flush();
//			out.close();
//			this.keySet.clear();
//		} catch(Exception e) {
//			throw new RuntimeException("输出主数据到EXCEL文件失败 : " + filename, e);
//		}
//	}
//	
//	private void writeMasterData(String mdType, List<Map<String, Object>> masterDataList, List<MdMapingVO> mdMappings) {
//		Class<?> mcClass = null;
//		try {
//			mcClass = Class.forName(mdType);
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("加载主数据Class失败：" + mdType, e);
//		}
//		List<String> header = getHeader(mcClass);
//		
//		for(Map<String, Object> masterData : masterDataList) {
//			String sheetName = getShortName(mcClass);
//			HSSFSheet sheet = workbook.getSheet(sheetName);
//			if(sheet == null) {
//				sheet = workbook.createSheet(sheetName);
//				writeHeader(sheet, header);
//			}
//			
//			writeRecord(sheet, header, masterData, mcClass, mdMappings);
//		}
//	}
//	
//	private void writeRecord(HSSFSheet sheet, List<String> header, Map<String,
//			Object> record, Class<?> mdType, List<MdMapingVO> mdMappings) {
//		int rownum = sheet.getPhysicalNumberOfRows();
//		HSSFRow row = sheet.createRow(rownum);
//		
//		List<String> fieldList = getField(mdType);
//		
//		for(int i=0; i<header.size(); i++) {
//			//判断业务数据ＩＤ是否为空，如果为空则生成ＩＤ，并生成与主数据映射关系MdMappingVO
//			String fieldName = header.get(i);
//			Object value = record.get(fieldName);
////			if(value == null) {
////				value = "";
////			}
//			if("id".equals(fieldName)) {
//				if(value == null) {
//					value = new Date().getTime();
//					
//					//取得实体编码
//					String entityCode = getShortName(mdType);
//					
//					//取得主数据编码
//					String mdmCode = (String) record.get("mdm_code");
//					
//					//生成映射关系
//					MdMapingVO mapping = new MdMapingVO();
//					mapping.setBusiDataId(String.valueOf(value));
//					mapping.setEntityCode(entityCode);
//					mapping.setMdmCode(mdmCode);
//					mdMappings.add(mapping);
//				}
//			}
//			
////			Class<?> valClass = value.getClass();
//			
//			
//			Field field = null;
//			try {
//				field = mdType.getDeclaredField(fieldList.get(i));
//			} catch (SecurityException e1) {
//				throw new RuntimeException("从Class取得主数据属性类型失败：" + header.get(i), e1);
//			} catch (NoSuchFieldException e1) {
//				throw new RuntimeException("从Class取得主数据属性类型失败：" + header.get(i), e1);				
//			}
//			Class<?> type = (Class<?>) field.getType();
//			
//			if(type.isAssignableFrom(ArrayList.class)) {	//主子表
//				Type actualType = null;
//				List<Map<String, Object>> listVal = null;
//				try {
//					listVal = (List<Map<String, Object>>)value;
//					if(listVal != null && listVal.size()>0) {
//						actualType = ((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0];
//						writeMasterData((Class<?>)actualType, listVal, mdMappings);
//					}
//				} catch(Exception e) {
//					throw new RuntimeException("写入子表数据失败!类型：" + actualType + ",值：" + listVal, e);
//				}
//				
//			} else if(isPrimitive(type)) {	//基本类型
//				HSSFCell cell = row.createCell(i);
//				cell.setCellValue((value==null)? "" : value.toString());
//				
//			} else {	//参照类型
//				String key = null;
//				try {
//					if(value == null) {
//						HSSFCell cell = row.createCell(i);
//						cell.setCellValue(key);
//						continue;
//					} else {
//						key = (String) ((Map<String, Object>)value).get("id");						
//					}
//				} catch(Exception e) {
//					throw new RuntimeException("分发参照类型数据失败：属性：" + field + ", 值：" + value);
//				}
////				if(StringUtils.isEmpty(key)) {
////					throw new RuntimeException("分发参照类型数据失败：被参照数据中没有ID属性！属性：" + field + ", 值：" + value);
////				}
//				
//				HSSFCell cell = row.createCell(i);
//				cell.setCellValue(key);
//				
//				//去除重复记录
//				if(!keySet.contains(key)) {
//					keySet.add(key);
//					
//					//增加子记录
//					try {
//						List<Map<String, Object>> refObject = new ArrayList<Map<String, Object>>();
//						refObject.add((Map<String, Object>)value);
//						writeMasterData(type,refObject, mdMappings);
//					} catch(Exception e) {
//						throw new RuntimeException("写入参照数据失败！类型：" + type + ",值：" + value, e);
//					}
//				}
//			}
//			
//		}
//	}
//	
//	private boolean isPrimitive(Class<?> clazz) {
//		if(clazz.isPrimitive() || "java.lang.String".equals(clazz.getName())) {
//			return true;
//		}
//		
//		try {
//			if(((Class)clazz.getField("TYPE").get(null)).isPrimitive()) {
//				return true;
//			}
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchFieldException e) {
//			return false;
//		}
//		
//		return false;
//	}
//
//	private void writeMasterData(Class<?> mdType, List<Map<String, Object>> masterDataList, List<MdMapingVO> mdMappings) {
//		List<String> header = getHeader(mdType);
//		
//		for(Map<String, Object> masterData : masterDataList) {
//			String sheetName = getShortName(mdType);
//			HSSFSheet sheet = workbook.getSheet(sheetName);
//			if(sheet == null) {
//				sheet = workbook.createSheet(sheetName);
//				writeHeader(sheet, header);
//			}
//			
//			writeRecord(sheet, header, masterData, mdType, mdMappings);
//		}
//	}
//	
//	
//	private void writeHeader(HSSFSheet sheet, List<String> header) {
//		HSSFRow row = sheet.createRow(0);
//		for(int i=0; i<header.size(); i++) {
//			HSSFCell cell = row.createCell(i);
//			cell.setCellValue(header.get(i));
//		}
//	}
//	
//	private String getShortName(Class<? extends Object> clazz) {
//		String fullName = clazz.getName();
//		int index = fullName.lastIndexOf(".");
//		if(index != -1) {
//			return fullName.substring(index + 1);
//		}
//		return null;
//	}
//	
//	private List<String> getHeader(Class<?> clazz) {
//		Field[] declaredFields = clazz.getDeclaredFields();
//		List<String> header = new ArrayList<String>();
//		for(Field field : declaredFields) {
//			XmlElement annotation = field.getAnnotation(javax.xml.bind.annotation.XmlElement.class);
//			if(annotation != null) {
//				if(!"##default".equals(annotation.name())) {
//					header.add(annotation.name());
//					continue;
//				}
//				
//			}
//			header.add(field.getName());
//		}
//		header.remove("serialVersionUID");	//TODO
//		return header;
//	}
//	
//	private List<String> getField(Class<?> clazz) {
//		Field[] declaredFields = clazz.getDeclaredFields();
//		List<String> header = new ArrayList<String>();
//		for(Field field : declaredFields) {
//			header.add(field.getName());
//		}
//		header.remove("serialVersionUID");	//TODO
//		return header;
//	}
//	
//	private List<Map<String, Object>> getMasterDataFrom(HSSFWorkbook workbook) {
//		
//		List<Map<String, Object>> masterData = new ArrayList<Map<String, Object>>();
//
//		//默认第一个sheet为主表
//		HSSFSheet sheet = workbook.getSheetAt(0);
//		if(sheet == null) {
//			throw new RuntimeException("Excel模板错误：没有主表sheet!");
//		}
//		
//		int rows = sheet.getPhysicalNumberOfRows();
//		for (int r = 1; r < rows; r++) {
//			HSSFRow row = sheet.getRow(r);
//			if (row == null) {
//				continue;
//			}
//
//			//列长
//			int cells = sheet.getRow(0).getPhysicalNumberOfCells();
//			Map<String, Object> rowMap = new HashMap<String, Object>();
//			
//			//取得超链接列Index
//			List<Integer> linkClmIndex = getLinkClmIndex(sheet);
//			
//			for (int c = 0; c < cells; c++) {
//				HSSFCell cell = row.getCell(c);
//				Object value = getCellValue(cell);
//				
//				//取得属性名称
//				HSSFCell headCell = sheet.getRow(0).getCell(c);
//				String fieldName = headCell.getStringCellValue();
//				
//				//判断第一行是否为title行
//				if(c == 0) {
//					if(!"id".equalsIgnoreCase(fieldName)) {
//						throw new RuntimeException("Excel模板文件中没有Title行！");
//					}
//				}
//				
//				//生成引用字段
//				if((linkClmIndex != null) && linkClmIndex.contains(c)) {
//					
//					HSSFSheet targetSheet = getRefSheet(headCell);
//					
//					
//					String refCellAddress = getRefCellAddress(headCell);
//					int[] rowClm = getIndexOfRowClm(refCellAddress);
//					
//					//主子表情况
//					if(value == null) {
//						
//						//主表第一列主引用key
//						Object refKey = getCellValue(row.getCell(0));
//						
//						try {
//							if(subDataMap == null) {
//								subDataMap = getSubDataMap(targetSheet, rowClm[1]);
//							}
////							value = getRefList(targetSheet, rowClm[1], refKey);
//							value = subDataMap.get(refKey);
//						} catch(Exception e) {
//							throw new RuntimeException("取得子表数据失败！关系key:" + refKey, e);
//						}
//						
//					//参照情况
//					} else {
//						Object refVal = null;
//						try {
//							refVal = value;
//							value = getRefBean(targetSheet, rowClm[1], refVal);
//						} catch(Exception e) {
//							throw new RuntimeException("取得子表数据失败！关系key:" + refVal, e);
//						}
//					}
//
//				}
////				EIPLogger.info("行：%s, 列：%s, 字段名称：%s, 字段值：%s", r, c, fieldName, value);
//				
//				rowMap.put(fieldName, value);
//			}
//			masterData.add(rowMap);
//		}
//		
//		return masterData;
//	}
//
//	private List<Integer> getLinkClmIndex(HSSFSheet sheet) {
//		List<Integer> linkClms = null;
//		int cells = sheet.getRow(0).getPhysicalNumberOfCells();
//		for(int c=0; c<cells; c++) {
//			HSSFCell headCell = sheet.getRow(0).getCell(c);
//			if(headCell.getHyperlink() != null) {
//				if(linkClms == null) {
//					linkClms = new ArrayList<Integer>();
//				}
//				linkClms.add(c);
//			}
//		}
//		return linkClms;
//	}
//
//	/**
//	 * 取得引用的Bean, 默认第一列为关联字段
//	 * 
//	 * @param headCell
//	 * @param key
//	 * @param beanClass
//	 * @return
//	 * @throws IllegalAccessException 
//	 * @throws InstantiationException 
//	 * @throws InvocationTargetException 
//	 * @throws IllegalArgumentException 
//	 */
//	private List<Object> getRefList(HSSFSheet sheet, int clmIndex, Object fkey) throws Exception {
//		List<Object> refList = new ArrayList<Object>();
//		
//		//取得目标Sheet名称
//		if(sheet == null) {
//			throw new RuntimeException("没有对应的引用sheet!");
//		}
//		int rows = sheet.getPhysicalNumberOfRows();
//		for(int r=1; r<rows - 1; r++) {
//			HSSFRow row = sheet.getRow(r);
//			
//			//取得子表中的关联字段
//			
//			String key = row.getCell(clmIndex).getStringCellValue();
//			if(key.equals(fkey)) {
//				Map<String, Object> rowMap = new HashMap<String, Object>();
//				int cells = row.getPhysicalNumberOfCells();
//				for(int c=0; c<cells; c++) {
//					HSSFCell cell = row.getCell(c);
//					Object value = getCellValue(cell);
//					String fieldName = sheet.getRow(0).getCell(c).getStringCellValue();
//					rowMap.put(fieldName, value);
//				}
//				refList.add(rowMap);
//				System.out.println(r + "---" + rowMap);
//			}
//			
//		}
//		return refList;
//	}
//	
//	private Map<String, List<Object>> getSubDataMap(HSSFSheet sheet, int clmIndex) {
//		Map<String, List<Object>> retMap = new HashMap<String, List<Object>>();
//		int rows = sheet.getPhysicalNumberOfRows();
//		List<String> titleList = subTitle(sheet);
//		for(int r=1; r<rows - 1; r++) {
//			HSSFRow row = sheet.getRow(r);
//			String refKey = row.getCell(clmIndex).getStringCellValue();
//			if(!retMap.containsKey(refKey)) {
//				List<Object> rowMaps = new ArrayList<Object>();
//				retMap.put(refKey, rowMaps);
//			}
//			
//			retMap.get(refKey).add(getRowMap(row, titleList));
//		}
//		return retMap;
//	}
//	
//	private List<String> subTitle(HSSFSheet sheet) {
//		List<String> subTitleList = new ArrayList<String>();
//		HSSFRow row0 = sheet.getRow(0);
//		int cells = row0.getPhysicalNumberOfCells();
//		for(int c=0; c<cells; c++) {
//			subTitleList.add(row0.getCell(c).getStringCellValue());
//		}
//		return subTitleList;
//	}
//	
//	private Map<String, Object> getRowMap(HSSFRow row, List<String> titleList) {
//		Map<String, Object> rowMap = new HashMap<String, Object>();
//		int cells = row.getPhysicalNumberOfCells();
//		for(int c=0; c<cells; c++) {
//			HSSFCell cell = row.getCell(c);
//			Object value = getCellValue(cell);
//			String fieldName = titleList.get(c);
//			rowMap.put(fieldName, value);
//		}
//		
//		return rowMap;
//	}
//
//	private Object getRefBean(HSSFSheet sheet, int clmIndex, Object fkey) throws Exception {
//		
//		Map<String, Object> refMap = null;
//		
//		//取得目标Sheet名称
//		int rows = sheet.getPhysicalNumberOfRows();
//		for(int r=1; r<rows; r++) {
//			HSSFRow row = sheet.getRow(r);
//			
//			//取得子表中的关联字段
//			String key = row.getCell(clmIndex).getStringCellValue();
//			if(key.equals(fkey)) {
//				refMap = new HashMap<String, Object>();
//				int cells = row.getPhysicalNumberOfCells();
//				for(int c=0; c<cells; c++) {
//					HSSFCell cell = row.getCell(c);
//					Object value = getCellValue(cell);
//					String fieldName = sheet.getRow(0).getCell(c).getStringCellValue();
//					refMap.put(fieldName, value);
//				}
//				break;
//			}
//		}
//		return refMap;
//	}
//
//	private Object getCellValue(HSSFCell cell) {
//		Object value = null;
//
//		if(cell != null) {
//			switch (cell.getCellType()) {
//	
//				case HSSFCell.CELL_TYPE_FORMULA:
//					value = cell.getCellFormula();
//					break;
//	
//				case HSSFCell.CELL_TYPE_NUMERIC:
//					boolean dateFormatted = DateUtil.isCellDateFormatted(cell);
//					if(dateFormatted) {
//						value = cell.getDateCellValue();			
//					} else {
//						value = cell.getNumericCellValue();						
//					}
//					break;
//	
//				case HSSFCell.CELL_TYPE_STRING:
//					value = cell.getStringCellValue();
//					break;
//	
//				default:
//			}
//		}
//		return value;
//	}
//	
//	private String getShortName(String fullName) {
//		int index = fullName.lastIndexOf(".");
//		if(index != -1) {
//			return fullName.substring(index + 1);
//		}
//		return fullName;
//	}
//	
//	private FileInputStream readFile(String filename) throws FileNotFoundException {
//		
//		String esbHome = EIPRuntime.getInstance().getServerHome();
//		String dir = "/solutions/excel/input/";
//		filename = esbHome + dir + filename + ".xls";
//		return new FileInputStream(filename);
//	}
//	
//	private HSSFSheet getRefSheet(HSSFCell headCell) {
//		String sheetName = null;
//		HSSFHyperlink hyperlink = headCell.getHyperlink();
//		String target = hyperlink.getAddress();
//		try {
//			sheetName = target.substring(0, target.indexOf("!"));
//		} catch(Exception e) {
//			throw new RuntimeException("取得引用sheet名错误！");
//		}
//		
//		return workbook.getSheet(sheetName);
//	}
//	
//	private int[] getIndexOfRowClm(String address) {
//		char[] charArray = address.toCharArray();
//		int indexOfFirstDigit = 0;
//		for(int c=0; c<charArray.length; c++) {
//			boolean isDigit = Character.isDigit(charArray[c]);
//			if(isDigit) {
//				indexOfFirstDigit = c;
//				break;
//			}
//		}
//		
//		//row index
//		int[] rowClm = new int[2];
//		rowClm[0] = Integer.parseInt(address.substring(indexOfFirstDigit)) - 1;
//
//		//column index
//		if(indexOfFirstDigit == 1) {
//			rowClm[1] = charArray[0] - 'A';
//		} else {
//			rowClm[1] = (charArray[0] - 'A' + 1) * 26 + (charArray[1] - 'A');
//		}
//		
//		return rowClm;
//	}
//	
//	private String getRefCellAddress(HSSFCell headCell) {
//		HSSFHyperlink hyperlink = headCell.getHyperlink();
//		String target = hyperlink.getAddress();
//		return target.substring(target.indexOf("!") + 1);
//	}
//}
