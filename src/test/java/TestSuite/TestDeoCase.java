package TestSuite;

import org.openqa.selenium.WebDriver;
import Constant.TestData;

public class TestDeoCase {

	public static WebDriver driver = TestData.driver;
	
	public static void BUC_001() throws Exception
	{
		System.out.print("BUC_001 method is called");
		TestData.testCaseSheet.getRow(TestData.r).createCell(3).setCellValue("Pass");
		
	}
	
	public static void BUC_002() throws Exception
	{
		System.out.print("BUC_002 method is called");
		TestData.testCaseSheet.getRow(TestData.r).createCell(3).setCellValue("Pass");
				
	}
	
	public static void BUC_003() throws Exception
	{
		System.out.print("BUC_003 method is called");
		TestData.testCaseSheet.getRow(TestData.r).createCell(3).setCellValue("Pass");
				
	}

}
