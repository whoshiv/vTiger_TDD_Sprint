package vtiger.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaignPage {

	public CreatingNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Identification
	@FindBy(name = "campaignname")
	private WebElement campaignNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	//Getters
	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business Logic
	public void enterCampaignName(String campaignname)
	{
		campaignNameTextField.sendKeys(campaignname);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
}
