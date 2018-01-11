package cn.admin.core.tags.html.builder;

import java.io.IOException;
import java.util.Map;

/**
 * 
 
 * 
 * @title: HtmlComponentBuilder.java
 * @package cn.admin.core.tags.html.builder.builder
 * @description: 组建构造器具
* @author: lichao
 * @date: 2017年5月13日 上午10:20:37
 * @version V1.0
 \* @copyright: 2017 拍财富
 *
 */
public interface HtmlComponentBuilder {
	/**
	 * JSMap
	 * 
	 * @return
	 */
	public Map<String, String> getJsComponents();

	/**
	 * css语句map
	 * 
	 * @return
	 */
	public Map<String, String> getCssComponents();
	
	/**
	 * html语句map
	 * 
	 * @return
	 */
	public Map<String, String> getFragmentComponents();

	/**
	 * 初始化
	 * 
	 * @throws IOException
	 */
	public void init() throws IOException;
}