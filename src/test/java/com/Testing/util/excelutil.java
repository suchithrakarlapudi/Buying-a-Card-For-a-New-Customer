package com.Testing.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class excelutil {
	
	 private  static Map<String,Map<String,String>> allTestData = new HashedMap<String,Map<String,String>>(); 
	 
	private static Map<String, String> screenshotMap = new HashedMap<String,String>() ;

	private  void getTestDataInMap (String filename , String sheetname)   
	{
		try {
		Map<String, String> testData = new HashedMap<String,String>() ;
		String testcaseid=null;
		
		File file = new File("E:\\eclipse_workspace\\CdtaBuyCardTestReport\\src\\test\\resources\\"+filename+".xlsx");
		FileInputStream inputStream = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet(sheetname);
		
		int lastRowNum=sheet.getLastRowNum();
		int lastColNum=sheet.getRow(0).getLastCellNum();
		
		System.out.println("lastRowNum: "+lastRowNum+" lastColNum :"+lastColNum);
		
		List list = new ArrayList();
		for(int i=0; i< lastColNum ; i++)
		{
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(i);
			String rowHeader= cell.getStringCellValue().trim();
			list.add(rowHeader);
		}
		
		for(int j=1; j<lastRowNum;j++)
		{
			Row row=sheet.getRow(j);
			for(int k=0;k<lastColNum;k++)
			{
				Cell cell = row.getCell(k);
				
				String value=null;
				 switch (cell.getCellType()) {
					case STRING:
						value=cell.getStringCellValue();
						break;
					case NUMERIC:
						if(DateUtil.isCellDateFormatted(cell))
						{
							value=String.valueOf(cell.getDateCellValue());
						}
						else {
							value=String.valueOf(cell.getNumericCellValue());
						}
						break;
					
					case BOOLEAN:
						value=Boolean.toString(cell.getBooleanCellValue());
						break;
						
					case BLANK:
						value="";
						break;
						
					default:
						break;
					}
				
				if(k==0)
				{
					testcaseid=value;
				}
				else {
					testData.put((String) list.get(k), value);
				}
				
			}
			allTestData.put(filename+"@"+sheetname+"@"+testcaseid, testData);
			System.out.println();
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Map<String, String> getTestData( String workbookname, String sheetname, String testcaseid)
	{
		System.out.println(workbookname+"@"+sheetname+"@"+testcaseid);
		if(null == allTestData.get(workbookname+"@"+sheetname+"@"+testcaseid) )
		{
			getTestDataInMap(workbookname,sheetname);
			
		}
		return allTestData.get(workbookname+"@"+sheetname+"@"+testcaseid);
	}
	
	public void name( String classname, String testcase) {
		// putting into map
		screenshotMap.put(classname, testcase);
	}
	
	public static String name1(String classname) {
		String testcase=screenshotMap.get(classname);
		
		System.out.println("testcase::::::::"+testcase);
		
		return testcase;
	}
}
