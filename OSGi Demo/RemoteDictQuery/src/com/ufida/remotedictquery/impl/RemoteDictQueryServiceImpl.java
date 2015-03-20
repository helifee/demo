package com.ufida.remotedictquery.impl;

import java.util.concurrent.ConcurrentHashMap;

import com.ufida.dictquery.query.QueryService;

/**
 * 远程查询单词
 * @author zhangdqb
 *
 */
public class RemoteDictQueryServiceImpl implements QueryService {
	
	private static final ConcurrentHashMap<String, String> dict = 
		new ConcurrentHashMap<String, String>();
	
	static {
		dict.put("computer", "计算机");
		dict.put("Mac", "苹果本");
	}

	@Override
	public String queryWord(String word) {
		System.out.println("RemoteDictQueryServiceImpl called.");
		
		String result = dict.get(word);
		if(null == result) {
			result = "N/A";
		}
		
		return result;
	}

}
