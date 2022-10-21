package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {
	@Test
	public void createCustomerTest()
	{
		System.out.println("test1");
		System.out.println("test2");
		System.out.println("test3");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals("A","B");
		System.out.println("test4");
		System.out.println("test5");
		soft.assertAll();
	}
	@Test
	public void modifyCustomerTest()
	{
		System.out.println(".........................");
		System.out.println("test1");
		System.out.println("test2");
		System.out.println("test3");
	}
}
