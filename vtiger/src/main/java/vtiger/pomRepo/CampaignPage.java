package vtiger.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	//Identifying Elements
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement campaignPlusButton;

	//Getter
	public WebElement getCampaignPlusButton() {
		return campaignPlusButton;
	}
    
	//Business Logic
	public void clickOnCampaignPlusButton()
	{
		campaignPlusButton.click();
	}
	
}
