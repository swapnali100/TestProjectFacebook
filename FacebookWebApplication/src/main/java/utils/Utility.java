package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility

{
	
	public static String getDataFromExcelSheet(String sheet,int row,int col) throws EncryptedDocumentException, IOException
	
	{
	
	
		FileInputStream file = new FileInputStream("C:\\Users\\shri\\Desktop\\Class.xlsx");
		 
		String  data=  WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
		
		return data;
	}
	public static void getScreenShot(WebDriver driver,int testID) throws IOException
	{

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy  HH mm ss ");
	LocalDateTime now = LocalDateTime.now();
//	System.out.println(dtf.format(now));
	//--------------screenshot code-------------------------------
	File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File des = new File("C:\\Users\\shri\\Downloads\\screenshot\\Test" +testID+(dtf.format(now))+".jpg");
	FileHandler.copy(src, des);
	}
}
