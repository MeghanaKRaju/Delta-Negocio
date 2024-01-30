package com.GenericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fileutils {
	
	/**
	 * This method is used to read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
