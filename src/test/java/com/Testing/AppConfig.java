package com.Testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.github.bonigarcia.wdm.ChromeDriverManager;

@Configuration
@ComponentScan(basePackages = "com.Testing")
public class AppConfig {

	public static WebDriver driver;
	
	@Bean
	public WebDriver create_chromedriver()
	{
		ChromeDriverManager.chromedriver().setup();
	     driver= new ChromeDriver();
	     
	     driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
	     return driver;
	}
}
