package wrappers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver implements Browser, Element, Select, TargetLocator {

	public static RemoteWebDriver driver;

	@Override
	public boolean startApp(String browser, String url) {

		try {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			} else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			} else {
				System.err.println("This browser "+browser+" is not supported");
				return false;
			}

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("The browser "+browser+" launched successfully");
			return true;

		} catch (Exception e) {
			System.err.println("The browser "+browser+" could not be launched");
			return false;
		}

	}

	@Override
	public void switchToWindow(int index) {

		try {
			Set<String> windowHandles=driver.getWindowHandles();
			List<String> allWindows=new ArrayList<String>(windowHandles);
			String windowHandle=allWindows.get(index);
			driver.switchTo().window(windowHandle);
			System.out.println("The Window of index"+index+" is switched");
		} catch (Exception e) {
			System.err.println("The Window of index"+index+" could not switched");
		}

	}

	@Override
	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub

		try {
			driver.switchTo().frame(ele);
			System.out.println("The frame "+ele+" is switched");
		} catch (Exception e) {
			System.err.println("The frame "+ele+" could not switched");
		}

	}

	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub

		try {
		driver.switchTo().alert().accept();
			System.out.println("Aceepted the alert");
		} catch (Exception e) {
			System.err.println("Alert not Accepted");
		}

	}

	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub

		try {
			driver.switchTo().alert().dismiss();;
			
			System.out.println("Rejected the alert");
		} catch (Exception e) {
			System.err.println("Alert not Rejected");
		}

	}

	@Override
	public String getAlertText() {
		try {
			System.out.println("Alert text: " +driver.switchTo().alert().getText());
		} catch (Exception e) {
			System.err.println("Alert text is not Displayed");
		}
		return null;
	}

	@Override
	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		// TODO Auto-generated method stub
		try {
			selectDropDownUsingVisibleText(ele,value);
			System.out.println("The dropdown "+ele+"is selected with the value "+value);
		} catch (Exception e) {
			System.err.println("The dropdown "+ele+"is not selected with the value "+value);
		}
	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub
		try {
			selectDropDownUsingValue(ele,value);
			System.out.println("The dropdown "+ele+"is selected with the value "+value);
		} catch (Exception e) {
			System.err.println("The dropdown "+ele+"is not selected with the value "+value);
		}
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		try {
			selectDropDownUsingIndex(ele,index);
			System.out.println("The dropdown "+ele+"is selected with the index "+index);
		} catch (Exception e) {
			System.err.println("The dropdown "+ele+"is not selected with the index "+index);
		}
	}

	@Override
	public void type(WebElement ele, String data) {

		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The element "+ele+" is typed with the value "+data);
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be typed with the value "+data);
		}

	}

	@Override
	public void click(WebElement ele) {	
		try {
			ele.click();
			System.out.println("The element "+ele+" is clicked");
		} catch (Exception e) {
			System.err.println("The element "+ele+" could not be clicked");
		}

	}

	@Override
	public String getText(WebElement ele) {

		try {
		
			System.out.println("Get the text"+ele.getText()+"Value");
		} catch (Exception e)
		{
			System.err.println("Not Get the text value");
		}
		return null;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		try {			
			if(ele.getText().equals(expectedText))
			{
				System.out.println("verified the Exact Text");
			}
		} catch (Exception e) {
			System.err.println("Not verified the Exact Text");
		}
	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		try {
			if(ele.getText().contains(expectedText))
			{
				System.out.println("verified the Partial Text");
			}
		} catch (Exception e) {
			System.err.println("Not verified the Partial Text");
		}
	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		try {
			if(ele.getAttribute(attribute).equals(value))
			{
				System.out.println("Expected Attribute are verified Successfully");
			}
		} catch (Exception e) {
			System.err.println("Expected Attribute are not verified Successfully");
		}
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		try {
			
			if(ele.getAttribute(attribute).contains(value))
			{
				System.out.println("Expected Attribute are verified Successfully");
			}
		} catch (Exception e) {
			System.err.println("Expected Attribute are not verified Successfully");
		}
	}

	@Override
	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Verified this"+ele.isSelected()+" Element");
		} catch (Exception e) {
			System.err.println("not Verified the selected Element");
		}
	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Verified this"+ele.isDisplayed()+" Element");
		} catch (Exception e) {
			System.err.println("not Verified the Displayed Element");
		}
	}

	@Override
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator.toLowerCase()) {
			case "id": return driver.findElement(By.id(locValue));
			case "name": return driver.findElement(By.name(locValue));
			case "link": return driver.findElement(By.linkText(locValue));
			case "class": return driver.findElement(By.className(locValue));
			case "tag": return driver.findElement(By.tagName(locValue));
			case "xpath": return driver.findElement(By.xpath(locValue));
			case "css": return driver.findElement(By.cssSelector(locValue));
			case "partial": return driver.findElement(By.partialLinkText(locValue));
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element could not be found for the locator "+locator+" with value "+locValue);
		}
		return null;

	}

	@Override
	public boolean verifyExactTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		try {
			if(driver.getTitle().equals(expectedTitle))
			{
				System.out.println("Expected Title are verified Successfully");
			}
		} catch (Exception e) {
			System.err.println("Expected Title are not verified Successfully");
		}
		return false;
	}

	@Override
	public boolean verifyPartialTitle(String expectedTitle) {
		try {
			if(driver.getTitle().contains(expectedTitle))
			{
				System.out.println("Expected Title are verified Successfully");
			}
		} catch (Exception e) {
			System.err.println("Expected Title are not verified Successfully");
		}
		return false;
	}

	@Override
	public void closeActiveBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			System.out.println("Active Browser closed successfully");
		} catch (Exception e) {
			System.err.println("Active Browser not closed successfully");
		}

	}

	@Override
	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
			System.out.println("All the Browsers closed successfully");
		} catch (Exception e) {
			System.err.println("All the Browsers not closed successfully");
		}
	}





}
