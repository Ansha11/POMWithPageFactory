package com.POMWithPageFactory.Scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.POMWithPageFactory.Pages.LoginPage;
import com.POMWithPageFactory.Pages.LoginPage1;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import utilities.Base;

public class LoginTest1 extends Base {
  @Test(dataProvider="dp")
  public void login1(String username,String password) throws Exception {
	  LoginPage1 lp1=new LoginPage1(driver);
	  lp1.logindetails1(username,password);
	 WebElement success=driver.findElement(By.xpath("//h3[text()='Login Successfully']"));
	 boolean a=success.isDisplayed();
	  Assert.assertTrue(a);
  }
  
  
  @DataProvider
	  public Object[][] dp() throws Exception {
	  
	  File f=new File("/Users/Sanoob/Desktop/exceldata.xls");
	  FileInputStream fis=new FileInputStream(f);
	  Workbook workbook=Workbook.getWorkbook(f);
	  Sheet sheet=workbook.getSheet("Sheet1");
	  int r=sheet.getRows();
	  int c=sheet.getColumns();
	 Object[][]data=new Object[r][c];
	  for(int i=0;i<r;i++) {
		 for(int j=0;j<c;j++) {
			 Cell cc=sheet.getCell(j, i);
			 data[i][j]=cc.getContents();	 
		 }
	  }
	 return data; 
	  
	  
	  
	  }
  }

