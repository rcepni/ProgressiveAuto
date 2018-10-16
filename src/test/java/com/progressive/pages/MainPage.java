package com.progressive.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.progressive.utilities.Driver;

public class MainPage {

	public MainPage() {
			PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	@FindBy(xpath="//li[@class='check attached auto']//a[text()='Auto']")
	public WebElement autoButton;
	
	@FindBy(id="zipCode_ueno")
	public WebElement zipCodeInput;
	
	@FindBy(id="qsButton_ueno")
	public WebElement QuoteAutoButton;
	
	
}
