package vtiger.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Finding Elements
	@FindBy(xpath ="//img[@title='Create Organization...']")
	private WebElement organizationPlusButton;

	//Getters
	public WebElement getOrganizationPlusButton() {
		return organizationPlusButton;
	}
	
	//Business Logic
	public void clickOnorganizationPlusButton()
	{
		organizationPlusButton.click();
	}
	
	
	
			

}
