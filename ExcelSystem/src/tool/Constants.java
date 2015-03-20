package tool;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	public static final Map<String, String> mdTypeToVoType = new HashMap<String, String>();
	
	static {
		//�����ݽ�����Ʊ��룺ʵ�����(���ʵ��������ֻ��Ӧ������ʵ��)
		mdTypeToVoType.put("supply.Supplier", "supply.Supplier");
		mdTypeToVoType.put("testzdq.Supplier", "supply.Supplier");
		mdTypeToVoType.put("test_zdq.companytype", "supply.CompanyType");
		mdTypeToVoType.put("testdata.person", "testdata.Person");
		mdTypeToVoType.put("singlea", "testdata.Singlea");
		mdTypeToVoType.put("currency", "currenct");
	}
}
