package vtiger.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLeadsPage {

	public CreatingNewLeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "salutationtype")
	private WebElement leadSalutationDropDown;
	
	@FindBy(name = "firstname")
	private WebElement leadFirstNameTextBox;
	
	@FindBy(name = "lastname")
	private WebElement leadLastNameTextBox;
	
	@FindBy(name = "company")
	private WebElement leadCompanyNameTextBox;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getLeadSalutationDropDown() {
		return leadSalutationDropDown;
	}

	public WebElement getLeadFirstNameTextBoc() {
		return leadFirstNameTextBox;
	}

	public WebElement getLeadLastNameTextBox() {
		return leadLastNameTextBox;
	}

	public WebElement getCompanyNameTextBox() {
		return leadCompanyNameTextBox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business Logic
	/**
	 * Method to perform action
	 */
	
	 
	 public void selectLeadSalution(String salutation)
	 {
		 Select select = new Select(leadSalutationDropDown);
		 select.selectByVisibleText(salutation);
	 }
	 
	 public void enterLeadFirstName(String leadFirstName)
	 {
		leadFirstNameTextBox.sendKeys(leadFirstName);
	 }
	 
	 public void enterLeadLastName(String leadLastName)
	 {
		leadLastNameTextBox.sendKeys(leadLastName);
	 }
	 
	 /**
	  *  this method is used to pass company name to the lead
	  * @param companyName
	  */
	 public void enterCompanyName(String companyName)
	 {
		 leadCompanyNameTextBox.sendKeys(companyName);
	 }

	 public void clickOnSaveButton()
	 {
		 saveButton.click();
	 }
}
