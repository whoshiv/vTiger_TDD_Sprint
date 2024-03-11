package vtiger.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	
 public CreatingNewOrganizationPage(WebDriver driver) 
 {
	PageFactory.initElements(driver, this);
 }
 
 // Finding Elements
 @FindBy(name = "accountname")
 private WebElement organizationNameTextField;
 
 @FindBy(xpath ="//input[@title='Save [Alt+S]']")
 private WebElement savebutton;

// Getters
public WebElement getOrganizationNameTextField() {
	return organizationNameTextField;
}

public WebElement getSavebutton() {
	return savebutton;
}

//Business logic
public void enterOrganizationName(String organizationname)
{
	organizationNameTextField.sendKeys(organizationname);
}
 
public void clickOnSaveButton()
{
	savebutton.click();
}
}
