package tool;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	public static final Map<String, String> mdTypeToVoType = new HashMap<String, String>();
	
	static {
		mdTypeToVoType.put("xhd", "hyd"); //key:主数据定义编码  value:主表实体编码
	}
}
