package mfma.screens;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class Login extends LoadableComponent <Login>{
	
	WebDriver driver;
	
    @FindBy(id="login_username")

    WebElement txtUsername;

    
    @FindBy(id="login_password")

    WebElement txtPassword;

    
    @FindBy(id="barone")

    WebElement titleText;

    
    @FindBy(id="login_log_in")
    
    WebElement btnLogin;
    

    public Login(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

       
    //Set user name in textbox

    public void setUserName(String strUserName){

    	txtUsername.sendKeys(strUserName);
    }
    //Set password in password textbox

    public void setPassword(String strPassword){
    	
    	txtPassword.sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){
    	btnLogin.click();

    }


    public void loginToMfiles(String strServerName,String strUserName,String strPasword){
    	
    	//Fill user name
        this.setUserName(strUserName);

        //Fill password
        this.setPassword(strPasword);

        //Click Login button
        this.clickLogin();

    }

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}


}
