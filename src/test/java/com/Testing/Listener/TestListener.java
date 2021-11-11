package com.Testing.Listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Testing.Screenshot.TestScreenShot;
import com.Testing.util.excelutil;

public class TestListener implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			System.out.println("success method name :"+result.getClass());
			
			String screenshotname=excelutil.name1(result.getName().toString());
			
			TestScreenShot.takeScreenShot(screenshotname);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			String screenshotname=excelutil.name1(result.getName().toString());
			
			  TestScreenShot.takeScreenShot(screenshotname);
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}
	
}
