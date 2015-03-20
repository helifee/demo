package com.ufida.localdictquery.impl;

import java.util.concurrent.ConcurrentHashMap;

import com.ufida.dictquery.query.QueryService;

/**
 * 从本地字典中查询单词
 * 
 * @author zhangdqb
 * 
 */
public class LocalDictQueryServiceImpl implements QueryService {

	private static final ConcurrentHashMap<String, String> dict = 
		new ConcurrentHashMap<String, String>();
	
	static {
		dict.put("test", "测试");
		dict.put("china", "中国");
	}

	@Override
	public String queryWord(String word) {
		System.out.println("LocalDictQueryServiceImpl.queryWord called.");
		
		String result = dict.get(word);
		if(null == result) {
			result = "N/A";
		}
		
		return result;
	}

}
