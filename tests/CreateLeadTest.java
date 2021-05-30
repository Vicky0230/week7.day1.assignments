package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.LoginPage;

public class CreateLeadTest extends TestNgHooks{

	
	@Test(dataProvider = "readExcelData")
	public void createLead(String CompanyName, String FirstName, String LastName) 
	{
		new LoginPage()
			.typeUsername("DemoSalesManager")
			.typePassword("crmsfa")
			.clickSubmit()
			.VerifyMessage()
			.crmLink()
			.clickLeads()
			.createLeadButton()
			.typeCompanyName(CompanyName)
			.typeFirstName(FirstName)
			.typeLastName(LastName)
			.clickSubmit()
			.VerifyTitle();
	}

}
