package com.ufida.dictquery.query;

/**
 * 字典查询服务接口
 * @author zhangdqb
 *
 */
public interface QueryService {

	/**
	 * 根据输入的单词查询意思
	 * @param word
	 * @return
	 */
	public String queryWord(String word);
}
