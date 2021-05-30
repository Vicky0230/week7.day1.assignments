package hooks;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

import utils.ReadExcelData;
import wrappers.BaseDriver;


public class TestNgHooks extends BaseDriver{
	int i=0;

	@BeforeSuite
	public void init(){

	}

	@BeforeTest
	public void setupTests(){

	}

	@BeforeClass
	public void beforeClass(){

	}
	
	@BeforeMethod
	public void invoke(){
		startApp("chrome", "http://leaftaps.com/opentaps");
	}
	
	@AfterMethod
	public void close(){
		closeActiveBrowser();

	}

	@AfterClass
	public void afterClass(){

	}

	@AfterTest
	public void completeTests(){

	}

	@AfterSuite
	public void teardown(){


	}
	

	@AfterStep
	public void screenshot() throws IOException
	{
		File src= driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./snap"+(i++)+".jpg"));
	}

	
	@DataProvider(name="readExcelData")
	public Object[][] fetchData() throws InvalidFormatException, IOException {
		
		
		try {
			return ReadExcelData.readExcelData("Create Lead");
		} catch (InvalidFormatException e) {
			System.err.println("The excel is in invalid format. Looks corrupted");
		} catch (IOException e) {
			System.err.println("The file does not exist");
		}
		return null;

	}
}
