package com.Testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class BuyCard {
	WebDriver driver;
	
	@FindBy(xpath ="//button[text()='Buy Card']") 
	private WebElement Buycard;
	
//	private WebElement addcart;
	
	
	@FindBy(xpath ="//a[@id='shopping_checkout']") 
	private WebElement Checkout;
	
	
	@FindBy(xpath ="//button[text()='Checkout']") 
	private WebElement Checkout2;
	
	@FindBy(id ="cmbCourier") 
	private WebElement shippingoption;
	
	@FindBy(xpath ="//button[@class='btn btn-primary pull-right hidden-xs']") 
	private WebElement Checkout3;
	
	@FindBy(xpath ="//input[@value='check']") 
	private WebElement paymentoption;
	
	@FindBy(xpath ="//button[text()='Checkout']") 
	private WebElement Checkout4;
	
	
	 public BuyCard(WebDriver driver)
	 {
	       this.driver=driver;
	        PageFactory.initElements(this.driver,this); 
	 }
	 
	 public void Buycard(){
		 Buycard.click();
	  }
	 
	 public void addcart(String card){
		 driver.findElement(By.xpath("//h3[text()='"+card+"']//following::button[1]")).click();
		 
	  }
	
	 public void Checkout(){
		 Checkout.click();
	  }
	 
	 public void Checkout2(){
		 Checkout2.click();
	  }
	 
	 public void shippingoption(String shipping){
		  Select s = new Select(shippingoption);
	      s.selectByValue(shipping);
	  }
	 
	 public void Checkout3(){
		 Checkout3.click();
	  }
	 
	 public void paymentoption(){
		 paymentoption.click();
	  }
	 
	 public void Checkout4(){
		 Checkout4.click();
	  }
	
}
