package pages;

import hooks.TestNgHooks;

public class MyHome extends TestNgHooks {
	
	public Leads clickLeads(){
		
		click(locateElement("link", "Leads"));
		return new Leads();
	}
	
}
