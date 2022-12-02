package org.pojo;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flipkartpojo extends BaseClass{
	// 1. Non-parameterized constructors
	public Flipkartpojo() {

PageFactory.initElements(driver, this);// to avoid stale element exception
	}

	// 2.Creating private elements
	// normally we use diver.findelement(by.locators)

	// Here we use annotations 1.@FindBy 2.@FindBys 3.@FindAll 4.@CacheLookUp

	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
	private WebElement mobno;

	@FindBy(xpath = "//input[@class='_2IX_2- _3mctLh VJZDxU']")

	private WebElement passwd;

	@FindBy(xpath = "(//span[text()='Login'])[2]")
	private WebElement login;

//3. Getters to access webelements outside the class

	public WebElement getMobno() {
		return mobno;
	}

	public WebElement getPasswd() {
		return passwd;
	}

	public WebElement getLogin() {
		return login;
	}

}
