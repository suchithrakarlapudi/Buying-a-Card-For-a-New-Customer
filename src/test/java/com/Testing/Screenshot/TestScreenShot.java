package com.Testing.Screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Testing.AppConfig;

public class TestScreenShot {

	 public static String takeScreenShot(String screenShotName) throws IOException {
	        
	        //String df = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
	        
	        TakesScreenshot ts = (TakesScreenshot) AppConfig.driver;
	        
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        
	        String path = System.getProperty("user.dir") + "/test-output/screenshots/" + screenShotName + ".png";
	        
	      //  String path = "C:\\Users\\Suchithra\\Desktop\\" + screenShotName + df + ".png";
	        
	        System.out.println("path::"+path);
	        File destination = new File(path);
	        
	        FileUtils.copyFile(source, destination);
	        
	        return path;
	    }
}
