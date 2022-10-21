package com.crm.generic_Utility;

import java.util.Random;

public class Java_Utility {
	/**
	 * this program is used to avoid Duplicates
	 * @return
	 * @author Praveen
	 */
	public int getRandomNum()
	{
		Random ra=new Random();
		int ranNum = ra.nextInt(1000);
		return ranNum;
	}
}
