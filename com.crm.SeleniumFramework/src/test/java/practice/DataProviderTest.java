package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider="dataProvider_Test")
	public void bookTicket(String src, String dest)
	{
		System.out.println("Book tickts from "+src+" to "+dest);
	}
	@DataProvider
	public Object[][] dataProvider_Test()
	{
		Object[][] objArr=new Object[5][2];
		objArr[0][0]="Bangalore";
		objArr[0][1]="goa";
		
		objArr[1][0]="Bangalore";
		objArr[1][1]="Mangalore";
		
		objArr[2][0]="Bangalore";
		objArr[2][1]="Mumbai";
		
		objArr[3][0]="Bangalore";
		objArr[3][1]="Delhi";
		
		objArr[4][0]="Bangalore";
		objArr[4][1]="Hydrabad";
		
		return objArr;
		
	}

}
