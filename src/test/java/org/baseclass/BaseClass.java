package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	public static void launchBrowser(){
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}
	public static void launchurl(String url) {
		
		driver.get(url);
		
	}
	
	public static void geturl() {
		String currentUrl = driver.getCurrentUrl();	
		System.out.println(currentUrl);
		}
	public static void getTitle() {
		
		String title = driver.getTitle();
		System.out.println(title);
	}
	public static void  passText(String txt,WebElement element) {
		element.sendKeys(txt);

	}
	
	public static void clickBtn(WebElement ele) {
		ele.click();

	}
	
	public void screenShot(String imgName) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f=new File("location+ imgName.png");
		FileUtils.copyFile(image, f);
		
	}

	
	//Step2 :Use getScreenShotAs() method to take screenshot and store in temp floder(temp.folder)
	//OutPutType is a inferface
	
	
	//Step3: file is a predifined class creation of destination folder
	

	
	//Step4: Copy file content from temp folder to destination folder
	
	
	
	
	
	public static void createNewExcelFile(int rownum,int cellnum,String newdata) throws IOException {
		File f= new File("D:\\Selenium_Intership_Jul22\\DataDriven_ReadSingleData\\Excel\\multipledata.xlsx");		
		Workbook  wb=new XSSFWorkbook();
		Sheet newsheet = wb.createSheet("Multpledataupdate");
		Row createRow = newsheet.createRow(rownum);
		Cell newcell = createRow.createCell(cellnum);
		newcell.setCellValue(newdata);
		FileOutputStream fb = new FileOutputStream(f);
		wb.write(fb);
		
		
	}
	
	public static void createCell(int rownum,int cellnum,String newdata) throws IOException {
		File f= new File("D:\\Selenium_Intership_Jul22\\DataDriven_ReadSingleData\\Excel\\multipledata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook  wb=new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Multpledataupdate");
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(newdata);
		FileOutputStream fb = new FileOutputStream(f);
		wb.write(fb);
	}
	
	public static void createRow(int crerow,int crecell,String newdata) throws IOException {
		File f= new File("D:\\Selenium_Intership_Jul22\\DataDriven_ReadSingleData\\Excel\\multipledata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook  w=new XSSFWorkbook(fis);
		Sheet sheet = w.getSheet("Multpledataupdate");
		Row row = sheet.createRow(crerow);
		Cell cell = row.createCell(crecell);
		cell.setCellValue(newdata);
		FileOutputStream fb = new FileOutputStream(f);
		w.write(fb);
		
		
	}
	
	public static void updateDataToParticularCell(int getrow,int getcell,String existingdata,String newdata) throws IOException {
		File f= new File("D:\\Selenium_Intership_Jul22\\DataDriven_ReadSingleData\\Excel\\multipledata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook  w=new XSSFWorkbook(fis);
		Sheet sheet = w.getSheet("Multpledataupdate");
		Row row = sheet.getRow(getrow);
		Cell cell = row.getCell(getcell);
		String stringCellValue = cell.getStringCellValue();	
		if (stringCellValue.equals(existingdata)) {
			cell.setCellValue(newdata);
			}
		
		FileOutputStream fb = new FileOutputStream(f);
		w.write(fb);
	}
	
	public void closeBrowser() {
		driver.close();
	}
}  
