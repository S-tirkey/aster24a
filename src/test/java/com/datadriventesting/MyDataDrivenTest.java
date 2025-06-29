package com.datadriventesting;
import org.testng.annotations.Test;
import com.skillio.dataproviders.DataProviders;

public class MyDataDrivenTest {
	@Test(dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void verifyIfProductIsDeliverableInArea(int pincode) {
		System.out.println("Pincode: " + pincode);		
	}	
}
