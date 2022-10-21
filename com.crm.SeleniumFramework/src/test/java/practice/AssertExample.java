package practice;

import org.apache.http.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertExample {
	@Test
	public void createCustomer()
	{
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		Assert.assertEquals("a", "b");
		System.out.println("step4");
		System.out.println("step5");
		System.out.println("step6");
	}
	@Test
	public void modifyCustomer()
	{
		System.out.println("........................");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
	}
}
