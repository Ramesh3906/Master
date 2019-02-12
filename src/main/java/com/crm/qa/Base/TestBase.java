package com.crm.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.Testutil.Testutill;





public class TestBase {
	public static WebDriver driver=null;
	public static Properties pro=null;
	public static EventFiringWebDriver eventDriver;
	//public static WebEventListner eventL;
	
	public TestBase(){
		pro=new Properties();
		try {
			FileInputStream src=new FileInputStream("C:\\Users\\ramur\\testing_workplcce\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\Config.properties");
			pro.load(src);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	public static void initialization(){
		String browsername=pro.getProperty("Browser");
		System.out.println("Getting propery values is  "+browsername);
		if(browsername.equals("chorme")){
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Jar files\\Geko Drivers\\chrome\\chromedriver.exe");
			 driver=new ChromeDriver();
			
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Testutill.PageLoadWaitTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutill.ImplicityLoadWaitTime, TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
		

}

}
