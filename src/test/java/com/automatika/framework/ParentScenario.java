package com.automatika.framework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automatika.pageObjects.DownloadPage;
import com.automatika.pageObjects.MainPage;
import com.automatika.utility.Log;
import com.automatika.utility.Utils;

public class ParentScenario {
	 
    private WebDriver driver;
    private String sTestCaseName;
 
    protected DownloadPage downloadPage;
    protected MainPage mainPage;
 
    protected void startBrowser() throws Exception {
 
    	DOMConfigurator.configure("log4j.xml");
    	
	  	sTestCaseName = this.toString();
	  	 
	  	// refine the test case name
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
	  	Log.startTestCase(sTestCaseName);
    	
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 
        downloadPage = new DownloadPage(driver);
        mainPage = new MainPage(driver);
    }
 
    protected void navigateTo() {
        driver.get("http://www.newtours.demoaut.com/");
    }
    
    protected void navigateToSelenium() {
        driver.get("http://docs.seleniumhq.org/");
    }
 
    protected void closeBrowser() {
    	Log.endTestCase(sTestCaseName);
        driver.quit();
    }
 
}