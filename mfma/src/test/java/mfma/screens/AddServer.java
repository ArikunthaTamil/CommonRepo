package mfma.screens;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class AddServer extends LoadableComponent <AddServer>{
	
	WebDriver driver;
	
	@FindBy(id="login_server")

    WebElement txtServername;
	
	
	@FindBy(id="login_log_in")

    WebElement btnConnect;   

    public AddServer(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    
    //Set server name in textbox

    public void setServerName(String strServerName){
    	
    	txtServername.sendKeys(strServerName);
    }
    
    //Click on connect button

    public void clickConnect(){

    	btnConnect.click();

    }
    
    public void connectToServer(String strServerName){

        
    	//Fill server name
        this.setServerName(strServerName);
        
        //Click Connect button
        this.clickConnect();

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
