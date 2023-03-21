package utilities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Base {
	public WebDriver driver;
  
  @AfterMethod
  public void afterMethod(ITestResult r) throws Exception {
	  if(ITestResult.SUCCESS==r.getStatus()) {
		
		  File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(f,new File("/Users/Sanoob/Desktop/screenshot/"+r.getName()+".jpeg"));
	  }  
  }

  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
driver.get("http://demo.guru99.com/test/newtours/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
