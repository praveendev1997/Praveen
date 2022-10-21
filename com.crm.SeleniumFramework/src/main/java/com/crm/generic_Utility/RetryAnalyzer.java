package com.crm.generic_Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int count=0;
	int retryLimit=3;
	public boolean retry(ITestResult result) {
		if(count<retryLimit)
		{
			count++;
			return true;
		}
		return false;
	}

}
