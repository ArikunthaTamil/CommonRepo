package mfma.stepdefinitions;
import mfma.screens.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import genericLibrary.Session;

public class LoginSteps {
	
	@When("^Enter server \"([^\"]*)\" name$")
	public void EntersServerName(String servername) throws Throwable {
		try {
		new AddServer(Session.driver).setServerName(servername);
		}
		
		catch(Exception e){
			e.printStackTrace();
			}
		}
	
	@And("^Click Connect to enter login credentials$")
		public void ClicksConnect() throws Throwable {
			try{
				new AddServer(Session.driver).clickConnect();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			}

	@Given("^Enter user name \"([^\"]*)\" and  \"([^\"]*)\" password$")
	public void EntersCredentials(String uname , String password) throws Throwable {
			try{
				new Login(Session.driver).setUserName(uname);
				new Login(Session.driver).setPassword(password);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	@And("^Click Login to see the list of vaults$")
	public void ClicksLogin() throws Throwable {
			try{
				new Login(Session.driver).clickLogin();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	
	@And("^Click on the vault \"([^\"]*)\" from the list$")
	public void ClicksVaultName(String vaultname) throws Throwable {
		try {
			new VaultSelection(Session.driver).ClickOnTheVautName(vaultname);
		}
		
		catch(Exception e){
			e.printStackTrace();
			}
		}
	
	 
}
