package pages;



import hooks.TestNgHooks;

public class Home extends TestNgHooks 
{
	public Home VerifyMessage(){
		
		verifyPartialText(locateElement("tag", "h2"), "Welcome");

		return this;
	}

	public MyHome crmLink(){
		
		click(locateElement("link", "CRM/SFA"));
		return new MyHome();
	}

	public LoginPage Logout(){
		click(locateElement("class", "decorativeSubmit"));
		return new LoginPage();
	}	
}
