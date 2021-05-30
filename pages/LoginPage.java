package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import hooks.TestNgHooks;

public class LoginPage extends TestNgHooks
{

	public LoginPage typeUsername(String username)
	{
		type(locateElement("id", "username"), username);
		
		return this;
	}

	public LoginPage typePassword(String password)
	{
		
		type(locateElement("id", "password"), password);
		return this;
	}

	public Home typePasswordEnter()
	{
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("crmsfa",Keys.ENTER);
		return new Home();
	}

	public Home clickSubmit()
	{
		click(locateElement("class", "decorativeSubmit"));
		
		return new Home();
	}

	public LoginPage clickLoginForFailure()
	{
		click(locateElement("class", "decorativeSubmit"));
		return this;
	}

}
