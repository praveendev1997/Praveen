package com.crm.generic_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
	/**
	 * this method is used to launch the application
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Praveen 
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		// fis=new FileInputStream("./common_data.properties");
		FileInputStream fis=new FileInputStream(iPathConstant.PROPRTYFILE_PATH);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
}
