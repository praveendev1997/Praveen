package practice;

import org.testng.annotations.Test;

public class Sample {
	@Test(priority = 3,invocationCount = 3)
	public void createCustomer()
	{
		System.out.println("customer details created");
		//int arr[]= {1,2,3};
		//System.out.println(arr[4]);
	}
	@Test(dependsOnMethods ="createCustomer" )
	public void modifyCustomer()
	{
		System.out.println("modified customer Details");
	}
	@Test(dependsOnMethods ="createCustomer" )
	public void deleteCustomer()
	{
		System.out.println("deleted customer Details");
	}
}
