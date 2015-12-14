package com.automatika.glue;

import com.automatika.framework.ParentScenario;
import com.automatika.pageObjects.FlightFinder_Page;
import com.automatika.pageObjects.Home_Page;
import com.automatika.pageObjects.LogIn_Page;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StepDefinitions extends ParentScenario {
	 
    @Before
    public void beforeScenario() throws Exception {
        startBrowser();
    }
 
    @Given("^I am on the Selenium homepage$")
    public void I_am_on_the_Selenium_homepage() {
    	navigateToSelenium();
    }
 
    @When("^I click \"([^\"]*)\" tab$")
    public void I_click_tab_on(String tab) {
        mainPage.clickTab(tab);
    }
 
    @Then("^I should see \"([^\"]*)\" download link on Download page$")
    public void I_should_see_download_link_on_download_page(String linkText) {
        assertThat(downloadPage.hasDownloadLinkFor(linkText), is(true));
    }
 
    @Given("^User is on Home Page$")
    public void user_is_on_home_page() throws Throwable {
    	navigateTo();
    }

    @When("^User Navigate to LogIn Page$")
    public void user_navigate_to_login_page() throws Throwable {
        Home_Page.lnk_SignOn().click();
    }
    
    @And("^User enters (.+) and (.+)$")
    public void user_enters_and(String username, String password) throws Throwable {
        LogIn_Page.txt_UserName().sendKeys(username);
        LogIn_Page.txt_Password().sendKeys(password);
        LogIn_Page.btn_SignIn().click();
    }

    @Then("^Home Page Displayed Successfully with \"([^\"]*)\" Page Title$")
    public void home_page_displayed_successfully(String sPageTitle) throws Throwable {
        assertThat(FlightFinder_Page.getPageTitle(), is(sPageTitle));
    }

    
    @When("^User LogOut from the Application$")
    public void user_logout_from_the_application() throws Throwable {
        FlightFinder_Page.lnk_SignOff().click();
    }

    @Then("^User navigate to Login Page with title \"([^\"]*)\"$")
    public void user_navigate_to_login_page_with_title_something(String srtTitle) throws Throwable {
        assertThat(LogIn_Page.getTitle() , is(srtTitle));
    }

    
    @After
    public void afterScenario() {
        closeBrowser();
    }
}
