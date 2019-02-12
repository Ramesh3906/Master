package com.crm.qa.TestCases;

import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.Pages.HomePage;
import com.crm.qa.Pages.LoginPage;
import com.crm.qa.Testutil.Testutill;


import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest extends TestBase{
	public LoginPage loginPage;
	public HomePage homeobj;
	public Testutill UtilObj;
  
	public LoginTest(){
		super();
	}
	
	
	
	@Test
	public void pagetitle(){
		String str=loginPage.validatePageTitle();
		String strexpected="CRMPRO - CRM software for customer relationship management, sales, and support.";
		//Assert.assertEquals("CRMPRO  - CRM software for customer relationship management, sales, and support.",str);
		//Assert.assertEquals(strexpected, str);
		
		System.out.println(str);
		if(str.contains(strexpected)){
			Assert.assertTrue(true);
			
		}else{
			Assert.assertTrue(false,"Expected values not matched");
		}
	
	}
	
	
	@Test(priority=2)
	public void CRMImage(){
		Boolean b=loginPage.ValidateCRMLogoImg();
		Assert.assertTrue(b);
	}
	
	@Test(priority=3)
	public void LoginTest1(){
		homeobj=loginPage.LogInPage(pro.getProperty("userName"), pro.getProperty("Password"));
	}
  
	
	
  @BeforeMethod
  public void setUp() {
		initialization();
	
		
		loginPage =new LoginPage();
		// UtilObj = new Testutill();

	  
}


  @AfterMethod
  public void TearDown() {
	  driver.quit();
  }

}
