package pages;

import hooks.TestNgHooks;

public class CreateLead extends TestNgHooks
{
	public CreateLead typeCompanyName(String companyName)
	{
		type(locateElement("id", "createLeadForm_companyName"), companyName);
		return this;
	}

	public CreateLead typeFirstName(String firstName)
	{
		type(locateElement("id", "createLeadForm_companyName"), firstName);
		
		return this;
	}

	public CreateLead typeLastName(String lastName)
	{
		type(locateElement("id", "createLeadForm_companyName"), lastName);
		return this;
	}

	public ViewLead clickSubmit()
	{
		click(locateElement("xpath","//input[@name='submitButton']"));
		return new ViewLead();
	}
}
