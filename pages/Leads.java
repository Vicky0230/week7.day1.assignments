package pages;

import hooks.TestNgHooks;

public class Leads  extends TestNgHooks {
	
	public CreateLead createLeadButton(){

		click(locateElement("link", "Create Lead"));
		return new CreateLead();
	}
	

}
