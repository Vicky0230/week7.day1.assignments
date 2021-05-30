package pages;

import hooks.TestNgHooks;

public class ViewLead extends TestNgHooks
{
	public ViewLead VerifyTitle(){
		
		verifyPartialTitle("View Lead");
		return this;
	}
}
