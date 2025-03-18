/**
 * 
 */
package Utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author ajithkumar.pisharadi
 *
 */
public class ExcelHelper {
/*
 * 	To Read data from Excel File
 */
	 static ReadProperty readproperty = new ReadProperty();
	 String userName,password;
	

	// To Read Data File From Excel 
			public XSSFSheet readExcelSheet(String TCFileName, String SheetName)
			{
				
				String TestData = readproperty.loadProperty("TestData");
				File src = new File(TestData);
				//System.out.println("File "+src);
				XSSFSheet sheet = null;
				try {
					FileInputStream fis = new FileInputStream(src);
					XSSFWorkbook wb = new XSSFWorkbook(fis);
					sheet = wb.getSheet(SheetName);
					
					//userName = sheet.getRow(1).getCell(0).getStringCellValue();
					//password = sheet.getRow(1).getCell(1).getStringCellValue();
					
				} catch ( Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return sheet;
			}
			public XSSFSheet readExcelSheet_Update(String TCFileName, String SheetName)
			{
				
				String TestDataInputFile = readproperty.loadProperty("TestData");
				File src = new File(TestDataInputFile);
				//System.out.println("File "+src);
				XSSFSheet sheet = null;
				try {
					FileInputStream fis = new FileInputStream(src);
					XSSFWorkbook wb = new XSSFWorkbook(fis);
					sheet = wb.getSheet(SheetName);
					
					//userName = sheet.getRow(1).getCell(0).getStringCellValue();
					//password = sheet.getRow(1).getCell(1).getStringCellValue();
					
				} catch ( Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return sheet;
			}
			public XSSFSheet readPTCExcelSheet(String TCFileName, String SheetName)
			{
				
				String TestDataInputFile = readproperty.loadProperty("TestDataInputFile2");
				File src = new File(TestDataInputFile);
				//System.out.println("File "+src);
				XSSFSheet sheet = null;
				try {
					FileInputStream fis = new FileInputStream(src);
					XSSFWorkbook wb = new XSSFWorkbook(fis);
					sheet = wb.getSheet(SheetName);
					
					//userName = sheet.getRow(1).getCell(0).getStringCellValue();
					//password = sheet.getRow(1).getCell(1).getStringCellValue();
					
				} catch ( Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return sheet;
			}
}
