package com.automatika.pageObjects;

import org.openqa.selenium.WebDriver;

import com.automatika.framework.ParentPage;

public class MainPage extends ParentPage {
	 
    public MainPage(WebDriver driver) {
        super(driver);
    }
 
    public void clickTab(String tab) {
        click(tab);
    }
 
}	
