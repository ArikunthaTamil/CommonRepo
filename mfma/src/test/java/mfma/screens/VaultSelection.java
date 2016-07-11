package mfma.screens;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class VaultSelection extends LoadableComponent <VaultSelection>{
	
	WebDriver driver;
	
    @FindBy(id="vault_selection_list")
    WebElement vaultList;
    

    public VaultSelection(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void ClickOnTheVautName(String strVaultName){
    	
    	 List<WebElement> vaults = vaultList.findElements(By.id("component_string_list_text"));
    	 
    	 int count = 0;
    	 
    	 while(count < vaults.size()){		
    		 if(vaults.get(count).getText().contentEquals(strVaultName)){
    			 vaults.get(count).click();
    			 break;
    		 }
    		 count++;
    		 
    	 }

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
