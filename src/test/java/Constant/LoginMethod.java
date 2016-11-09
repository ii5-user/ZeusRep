package Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import TestSuite.*;
public class LoginMethod {

	static WebDriver driver=TestDeoCase.driver;
	

	public static  void  LoginAsDeo() throws Exception
	{
		TestData.rwExcle();
		driver.get(TestData.loginUrl);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(TestData.DeoUserName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(TestData.DeoPassword);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
	public static void LoginAsQA() throws Exception
	{
		TestData.rwExcle();
		driver.get(TestData.loginUrl);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(TestData.QAUserName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(TestData.QAPassword);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
	@Test
	public static void LoginAsAdmin() throws Exception
	{
		TestData.rwExcle();
		driver.get(TestData.loginUrl);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(TestData.QAUserName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(TestData.QAPassword);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
