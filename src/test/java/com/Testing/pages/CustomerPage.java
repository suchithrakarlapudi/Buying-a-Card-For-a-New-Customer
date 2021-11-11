package com.Testing.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import com.Testing.Screenshot.TestScreenShot;

@Component
public class CustomerPage {
	WebDriver driver;
	TestScreenShot shot=new TestScreenShot();
	
	@FindBy(xpath="//*[contains(text(),'Customer Care')]")
	 private WebElement Customercare;
	
	@FindBy(xpath="//h4[text()='Customer Management']")
	 private WebElement CustomerManagement;
	
	@FindBy(xpath="//span[text()='Create a new customer']")
	private WebElement CreateCustomer;
	
	// customer fields
	@FindBy(id="prefix")
	 private WebElement Prefix;
	
	@FindBy(name ="firstName") 
	private WebElement FirstName;
	
	@FindBy(name ="lastName") 
	private WebElement LastName;
	
	@FindBy(name ="middleInitial") 
	private WebElement MI;
	
	@FindBy(name ="externalId") 
	private WebElement CustomerId;
	
	@FindBy(name ="notes") 
	private WebElement CustomerNotes;
	
	@FindBy(id="faretype")
	 private WebElement FareType;
	
	@FindBy(id="accountType")
	 private WebElement AccountType;
	
	
	@FindBy(xpath="//input[@name='isEfare']")
	private WebElement EfareAccount;
	
	@FindBy(name ="email") 
	private WebElement Email;
	
	@FindBy(name ="addressLine1") 
	private WebElement AddressLine1;
	
	@FindBy(name ="addressLine2") 
	private WebElement AddressLine2;
	
	@FindBy(name ="city") 
	private WebElement City;
	
	@FindBy(name ="state") 
	private WebElement State;
	
	@FindBy(name ="postalCode") 
	private WebElement pincode;
	
	@FindBy(name ="country") 
	private WebElement country;
	
	@FindBy(id ="phone") 
	private WebElement phone;
	
	@FindBy(id ="mobilePhone") 
	private WebElement Mobilephone;
	
	@FindBy(id ="dateOfBirth") 
	private WebElement dateOfBirth;
	
	@FindBy(xpath ="//a[text()='Next']") 
	private WebElement ClickNext;
	
	@FindBy(xpath ="//a[text()='Activate Customer']") 
	private WebElement ActivateCustomer;
	
	
	 public CustomerPage(WebDriver driver)
	 {
	       this.driver=driver;
	        PageFactory.initElements(this.driver,this); 
	 }

	 
	 public void Customercare(){
		 Customercare.click();
	  }
	 
	 public void CustomerManagement(){
		 CustomerManagement.click();
	  }
	 
	 public void CreateCustomer(){
		 CreateCustomer.click();
	  }
	 
	 public void Prefix(String prefix){
		  Select s = new Select(Prefix);
	      s.selectByValue(prefix);
	  }
	 
	 public void FirstName(String firstName)
	 {
		 FirstName.sendKeys(firstName);
	 }
	 
	 public void LastName(String lastName)
	 {
		 LastName.sendKeys(lastName);
	 }
	 
	 public void MI(String mi)
	 {
		 MI.sendKeys(mi);
	 }
	 
	 public void CustomerId(String cid) throws IOException
	 {
		 CustomerId.sendKeys(cid);
		 //shot.takeScreenShot(driver, "customerdetails1");
	 }
	 
	 public void CustomerNotes(String notes)
	 {
		 CustomerNotes.sendKeys(notes);
	 }
	 
	 public void FareType(String faretype){
		  Select s = new Select(FareType);
	      s.selectByVisibleText(faretype);
	  }
	 
	 public void AccountType(String accounttype){
		  Select s = new Select(AccountType);
	      s.selectByVisibleText(accounttype);
	  }
	 
	 public void EfareAccount(){
		 EfareAccount.click();
	  }
	 
	 public void Email(String email)
	 {
		 Email.sendKeys(email);
	 }
	 
	 public void AddressLine1(String line1)
	 {
		 AddressLine1.sendKeys(line1);
	 }
	 
	 public void AddressLine2(String line2)
	 {
		 AddressLine2.sendKeys(line2);
	 }
	 
	 public void City(String city)
	 {
		City.sendKeys(city);
	 }
	 
	 public void State(String state)
	 {
		State.sendKeys(state);
	 }
	 
	 public void pincode(String pin)
	 {
		pincode.sendKeys(pin);
	 }
	 
	 public void country(String cntry)
	 {
		 Select s = new Select(country);
	      s.selectByVisibleText(cntry);
	 }
	 
	 public void phone(String ph)
	 {
		phone.sendKeys(ph);
	 }
	 public void Mobilephone(String mobile)
	 {
		Mobilephone.sendKeys(mobile);
	 }
	 
	 public void dateOfBirth(String dob) throws IOException
	 {
		dateOfBirth.sendKeys(dob);
		// shot.takeScreenShot(driver, "customerdetails2");
	 }
	 
	 public void ClickNext(){
		 ClickNext.click();
	  }
	 
	 public void ActivateCustomer() throws IOException{
		// shot.takeScreenShot(driver, "customerdetails");
		 ActivateCustomer.click();
	  }
	
}
