package com.Testing.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import com.Testing.Screenshot.TestScreenShot;

@Component
public class LoginPage {
	WebDriver driver;
	TestScreenShot shot=new TestScreenShot();
	
	@FindBy(id="username") 
	 private WebElement UserName;
	 
	@FindBy(id="password")
	 private WebElement Password;
	 
	@FindBy(xpath="//button[text()='Login']")
	 private WebElement Login;
	
	 public LoginPage(WebDriver driver)
	 {
	       this.driver=driver;
	        PageFactory.initElements(this.driver,this); 
	 }
	 
	 public void loadWebSite(String url) throws IOException
	 {
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.get(url);
	 }
	 
	 public void UserName(String Id)
	 {
		 UserName.sendKeys(Id);
	 }
	 
	 public void Password(String PasswordValue)  
	 {
	    Password.sendKeys(PasswordValue);
	   
	 }
	 
	 public void Login(){
	    	Login.click();
	  }
}
