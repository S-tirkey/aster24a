package com.frameworktests;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MyTestCases {
		  
	@Test(invocationCount=5, successPercentage=20)
	public static void  m1() throws Error{
		
		int a = 1;
		if( a<=3) {
			a++ ;
		}else
			throw  new Error();
		System.out.println("Hello Skillio_1st testcase");

	}
	
	@Test(priority = 1)
	public static void  m2(){
		System.out.println("Hello Skillio_2nd testcase");

	}
	@Test
	public static void  BeforeSuiteDemo(){
		System.out.println("Hello Skillio_3rd testcase");

	}

}
