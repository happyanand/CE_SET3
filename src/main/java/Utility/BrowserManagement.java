package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class BrowserManagement {
	
	 WebDriver driver;
	 static ReadProperty readproperty = new ReadProperty();
	 static String userName,password;
	 static short flag;
	 
	 public static List lst; 
	 public static List verifyingBrowser(short flag) {
		
		 //System.out.println("Browser "+activeBrowserName);
		
		
		
		
			String DataFile = readproperty.loadProperty("DataFile");
			File src = new File(DataFile);
			
			//System.out.println("File "+DataFile);
			List <String> lst = new ArrayList <String>();
		
		    try {
					FileInputStream fis = new FileInputStream(src);
					XSSFWorkbook wb = new XSSFWorkbook(fis);
					XSSFSheet sheet = wb.getSheet("UserCredentials");
					switch(flag)
					{
					 case 0 : userName = sheet.getRow(1).getCell(0).getStringCellValue();
							 password = sheet.getRow(1).getCell(1).getStringCellValue();
							 lst.add(userName);
							 lst.add(password);
							 break;
					 case 1 : userName = sheet.getRow(2).getCell(0).getStringCellValue();
					 		 password = sheet.getRow(2).getCell(1).getStringCellValue();
					 		 lst.add(userName);
					 		 lst.add(password);
					 		 break;
					 case 2 : userName = sheet.getRow(3).getCell(0).getStringCellValue();
					 		 password = sheet.getRow(3).getCell(1).getStringCellValue();
					 		 lst.add(userName);
					 		 lst.add(password);
					 		 break;
					 case 3 : userName = sheet.getRow(4).getCell(0).getStringCellValue();
					 		 password = sheet.getRow(4).getCell(1).getStringCellValue();
					 		 lst.add(userName);
					 		 lst.add(password);
					 		 break;
					 }
					
				} 
		    	catch ( Exception e) 
		    	{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return lst;
	}
}
