package Constant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestSuite.TestDeoCase;
public class TestData {
	public static FileInputStream excleFile;
	public static XSSFWorkbook workbook;
	public static XSSFSheet loginSheet;
	public static XSSFSheet testCaseSheet;
	public static XSSFSheet urlSheet;
	public FileOutputStream outFile;
	public static int r,c;
	public static WebDriver driver;
	public static String loginUrl,DeoUserName,DeoPassword,QAUserName,QAPassword,AdminUserName,AdminPassword;
	public static Row rows;

	@BeforeTest
	public static  void browser() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	
	@Test
	public static void rwExcle() throws Exception
	{
		excleFile= new FileInputStream(new File("D:\\jee-neon\\workspace\\ZeusTestData.xlsx"));
		workbook = new XSSFWorkbook(excleFile);
		loginSheet=workbook.getSheet("Login");
		testCaseSheet=workbook.getSheet("TestCase");
		urlSheet=workbook.getSheet("Url");
		//Getting Login Url
		loginUrl=urlSheet.getRow(0).getCell(0).toString();
		//Getting Login Credential
		DeoUserName=loginSheet.getRow(0).getCell(1).toString();
		DeoPassword=loginSheet.getRow(0).getCell(2).toString();
		QAUserName=loginSheet.getRow(1).getCell(1).toString();
		QAPassword=loginSheet.getRow(1).getCell(2).toString();
		AdminUserName=loginSheet.getRow(2).getCell(1).toString();
		AdminPassword=loginSheet.getRow(2).getCell(2).toString();
		//Run only those Test Case which as Yes in first column 
		int rowcount=testCaseSheet.getLastRowNum();//Getting total number of test cases
		System.out.println("Total Number of TestCase - "+rowcount);
		for (r=1;r<=rowcount;r++)
		{
			Row rows=testCaseSheet.getRow(r);
			if(rows.getCell(2).toString().equals("Yes"))
			{
				String testcasId=rows.getCell(0).toString();
				if(testcasId.equals("BUC-001"))
				{
					TestDeoCase.BUC_001();
				}else if(testcasId.equals("BUC-002"))
				{
					TestDeoCase.BUC_002();
				}else if(testcasId.equals("BUC-003"))
				{
					TestDeoCase.BUC_003();
				}
			}
		}
	}



	@AfterTest
	public static void writeExcle() throws Exception
	{
		FileOutputStream outFile =new FileOutputStream(new File("D:\\jee-neon\\workspace\\ZeusTestData.xlsx"));
		workbook.write(outFile);
		outFile.close();
		workbook.close();
	}

}




