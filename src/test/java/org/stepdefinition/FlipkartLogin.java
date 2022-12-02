package org.stepdefinition;

import org.baseclass.BaseClass;
import org.pojo.Flipkartpojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlipkartLogin extends BaseClass{
	Flipkartpojo fkp =new Flipkartpojo();//declared global
	
	@Given("To launch the chrome browser and maximise window")
	public void to_launch_the_chrome_browser_and_maximise_window() {
		launchBrowser();
		windowMaximize();
	    
		
	}

	@When("To launch the url of flipkart application")
	public void to_launch_the_url_of_flipkart_application() {
	  launchurl("https://www.flipkart.com/");
	  
	}

	@When("To Pass valid username in mobile no field")
	public void to_Pass_valid_username_in_mobile_no_field() {
	   
	   
	   passText("7200675462", fkp.getMobno());
	}

	@When("To Top Pass ivalid password in password field")
	public void to_Top_Pass_ivalid_password_in_password_field() {
	   passText("Parthi27$", fkp.getPasswd());
	   
	}

	@When("To click the login button")
	public void to_click_the_login_button() {
		
	   clickBtn(fkp.getLogin());
	   
	}

	@When("To check whether navigated to home page or not")
	public void to_check_whether_navigated_to_home_page_or_not() {
	    System.out.println("Log into flikart home page");
		
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
		closeBrowser();
	    
		
	}

}
