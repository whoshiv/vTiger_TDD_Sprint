package vtiger.pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtils.WebDriverUtility;

public class CreatingNewOpportunityPage {
    WebDriver driver;
	public CreatingNewOpportunityPage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
	 this.driver = driver;
	}
	
	@FindBy(name = "potentialname")
	private WebElement opportunityNameTextField;
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement organizationLookUpButton;
	
	@FindBy(name ="search_text")
	private WebElement organizationSearchTextField;
	
	@FindBy(name = "search")
	private WebElement organizationSearchButton;
	
	
	
	@FindBy(xpath = "(//img[@title='Select'])[2]")
	private WebElement campaignLookUpButton;
	
	@FindBy(name ="search_text")
	private WebElement campaignSearchTextField;
	
	@FindBy(name = "search")
	private WebElement campaignSearchButton;
	
	
	
	@FindBy(name = "closingdate")
	private WebElement opportunityClosingDate;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	//Dynamic xpath hai isliye aise search karenge
		public void clickOnOrganizationLookUpPage(String organizationName)
		{
		 driver.findElement(By.xpath("//a[text()='"+organizationName+"']")).click();
		}
		
		//Dynamic xpath hai isliye aise search karenge
		public void clickOncampaignLookUpPage(String campaignName)
		{
		 driver.findElement(By.xpath("//a[text()='"+campaignName+"']")).click();
		}

		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getOpportunityNameTextField() {
			return opportunityNameTextField;
		}

		public WebElement getOrganizationLookUpButton() {
			return organizationLookUpButton;
		}

		public WebElement getOrganizationSearchTextField() {
			return organizationSearchTextField;
		}

		public WebElement getOrganizationSearchButton() {
			return organizationSearchButton;
		}

		public WebElement getCampaignLookUpButton() {
			return campaignLookUpButton;
		}

		public WebElement getCampaignSearchTextField() {
			return campaignSearchTextField;
		}

		public WebElement getCampaignSearchButton() {
			return campaignSearchButton;
		}

		public WebElement getOpportunityClosingDate() {
			return opportunityClosingDate;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}
		
	public void enterOpportunityName(String opportunityName)
	{
		opportunityNameTextField.sendKeys(opportunityName);
	}
	
	public void clickAndSelectOrganizationNameFromLookUpPage(String organizationName, String titleToSwitch) throws InterruptedException
 	{    
		String parentpagetitle = driver.getTitle();
		System.out.println("kya hai parent page title "+parentpagetitle);
		System.out.println("Organization name "+organizationName);
		System.out.println("kaha switch karna hai "+titleToSwitch);
		organizationLookUpButton.click();
		//Control ko switch karne ke liye WebDriver Utility wale method ko call karenge
		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToWindow(driver, titleToSwitch);
		Thread.sleep(2000);
		System.out.println("========================"+driver.getTitle());
		organizationSearchTextField.sendKeys(organizationName);
		organizationSearchButton.click();
		clickOnOrganizationLookUpPage(organizationName);
		
		wUtils.switchToWindow(driver, parentpagetitle);
	}
	
	public void clickAndSelectCampaignNameFromLookUpPage(String campaignName, String titleToSwitch) throws InterruptedException
 	{    
		String parentpagetitle = driver.getTitle();
		campaignLookUpButton.click();
		//Control ko switch karne ke liye WebDriver Utility wale method ko call karenge
		WebDriverUtility wUtils = new WebDriverUtility();
		wUtils.switchToWindow(driver, titleToSwitch);
		
		campaignSearchTextField.sendKeys(campaignName);
		campaignSearchButton.click();
		clickOncampaignLookUpPage(campaignName);
		
		wUtils.switchToWindow(driver, parentpagetitle);
	}

	public void enterClosingDate(String closingDate)
	{
		opportunityClosingDate.sendKeys(closingDate);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
}

