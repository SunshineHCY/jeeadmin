package cn.admin.core.utils;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 全局配置文件工具类
 * 
 * @author  administrator
 * @version 2017-01-19
 */
public class jeeadminPropertiesUtil extends PropertiesUtil {
	private static String JEEWE_BPROPERTIES_FILENAME = "jeeadmin.properties";
	private static jeeadminPropertiesUtil propertiesUtil = new jeeadminPropertiesUtil();
	// 保存全局属性值
	private static Map<String, String> configMap = Maps.newHashMap();

	public jeeadminPropertiesUtil() {
		load(JEEWE_BPROPERTIES_FILENAME);
	}

	public static jeeadminPropertiesUtil getProperties() {
		if (propertiesUtil != null) {
			propertiesUtil = new jeeadminPropertiesUtil();
		}
		return propertiesUtil;
	}

	/**
	 * 获得配置
	 * 
	 * @param key
	 * @return
	 */
	public static String getConfig(String key) {
		String value = configMap.get(key);
		if (value == null) {
			value = propertiesUtil.getString(key);
			configMap.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}

	/**
	 * 设置配置
	 * 
	 * @param key
	 * @param value
	 */
	public static void setConfig(String key, Object value) {
		propertiesUtil.set(key, value);
	}

	/**
	 * 移除配置
	 * 
	 * @param key
	 * @return
	 */
	public static boolean removeConfig(String key) {
		return propertiesUtil.remove(key);
	}
}
