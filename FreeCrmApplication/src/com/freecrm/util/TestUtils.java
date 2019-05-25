package com.freecrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.freecrm.base.TestBase;

public class TestUtils extends TestBase {

	public TestUtils() throws IOException {
		super();
		
	}

	public static void TakeSnapshots(String name)throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File("D:\\Testing\\FreeCrmApplication\\Snapshots\\"+name+".png") );

	}
	
	public static Object[][] getDataFromExcel(String sheetName) throws Exception{
	
		File file = new File("D:\\Testing\\FreeCrmApplication\\src\\com\\freecrm\\testdata\\TestData.xlsx");
	FileInputStream fis = new FileInputStream(file);
	  
	//apache poi
XSSFWorkbook workbook = new XSSFWorkbook(fis);
Sheet sheet = workbook.getSheet("Sheet1");
int rows = sheet.getLastRowNum()+1;
int columns = sheet.getRow(0).getLastCellNum();
Object data[][] = new Object[rows][columns];
for(int i=0 ; i<rows ; i++) {
	for (int j = 0 ; j<columns ; j++) {
		data[i][j] = sheet.getRow(i).getCell(j).toString();
	}
}
return data;	
}	

}

