package com.offcn.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 配置相关的类
 * @author Administrator
 *
 */
public class ConfigUtil {
	private String prefix;
	
	private Properties props;
	
	/**
	 * 构造方法，需要传入配置文件的前缀
	 * @param prefix
	 * @throws IOException
	 */
	public ConfigUtil(String prefix) throws IOException {
		super();
		this.prefix = prefix;
		
		//读取配置文件
		props = new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream(prefix + ".properties"));
	}

	/**
	 * 读取配置项
	 * @param suffix
	 * @return
	 */
	public String getConfig(String suffix){
		return props.getProperty(this.prefix + "." + suffix);
	}
	
}
