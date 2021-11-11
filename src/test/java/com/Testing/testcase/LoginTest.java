package com.Testing.testcase;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Testing.AppConfig;
import com.Testing.Listener.TestListener;
import com.Testing.pages.BuyCard;
import com.Testing.pages.CustomerPage;
import com.Testing.pages.LoginPage;
import com.Testing.util.excelutil;


@Test
@ContextConfiguration(classes = AppConfig.class)
@Listeners(TestListener.class)
public class LoginTest extends AbstractTestNGSpringContextTests{

	@Autowired
	LoginPage loginpage;
	
	@Autowired
	CustomerPage cp;
	
	@Autowired
	BuyCard bc;
	
	@Autowired
	excelutil excel;
	
				
	@Test()
	public void test_success() throws IOException
	{
		Map<String , String> map = excel.getTestData("excelutil", "Sheet1", "test1");
		excel.name("test_success", "excelutil@Sheet1@test1");
		
		loginpage.loadWebSite("https://cdta-staging.gfcp.io/");
		loginpage.UserName(map.get("username"));
		loginpage.Password(map.get("password"));
		loginpage.Login();
		// customer details
		
		cp.Customercare();
		cp.CustomerManagement();
		cp.CreateCustomer();
		cp.Prefix(map.get("prefix"));
		cp.FirstName(map.get("firstname"));
		cp.LastName(map.get("lastname"));
		cp.MI(map.get("mi"));
		cp.CustomerId(map.get("customerid"));
		cp.CustomerNotes(map.get("customernotes"));
		cp.FareType(map.get("faretype"));
		cp.AccountType(map.get("accounttype"));
		cp.EfareAccount();
		cp.Email(map.get("email"));
		cp.AddressLine1(map.get("addressline1"));
		cp.AddressLine2(map.get("addressline2"));
		cp.City(map.get("city"));
		cp.State(map.get("state"));
		//cp.pincode(map.get("pincode"));
		cp.country(map.get("country"));
		//cp.phone(map.get("phone"));
		//cp.Mobilephone(map.get("mobilephone"));
	//	cp.dateOfBirth(map.get("dob"));
		//cp.ClickNext();
		//cp.ActivateCustomer();
		
		// buy card for customer
		
		
		/*
		 * bc.Buycard(); bc.addcart(map.get("addcart")); bc.Checkout(); bc.Checkout2();
		 * bc.shippingoption(map.get("shippingoption")); bc.Checkout3();
		 * bc.paymentoption(); bc.Checkout4();
		 */
		 
		 
	}
	
}
