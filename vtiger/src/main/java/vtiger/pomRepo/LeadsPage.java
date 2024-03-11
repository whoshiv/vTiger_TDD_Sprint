package vtiger.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

    /**
     * Identifying elements
     * 
     */
	@FindBy(xpath = "//img[@title='Create Lead...']") // iske xpath mai differenece hai sir wale se 
	private WebElement leadsPlusButton;

	
	public WebElement getLeadsPlusButton() {
		return leadsPlusButton;
	}


    /**
     * Business Logic
     * 
     */
	public void clickOnLeadsPlusButton()
	{
			leadsPlusButton.click();
	}
	
}
