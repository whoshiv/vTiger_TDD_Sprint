package vtiger.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Shiv
 * This POM class has all the elements present in the home page
 *
 */
public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;  // Ask ye kyun karte hai
	}
	
	@FindBy(linkText = "Calendar")
	private WebElement calenderModule;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsModule;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsModule;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsModule;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesModule;
	
	@FindBy(linkText = "Products")
	private WebElement productsModule;
	
	@FindBy(linkText = "Dashboard")
	private WebElement dashboardModule;
	
	@FindBy(linkText = "More")
	private WebElement moreDropDown;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsModule;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendorsModule;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorProfilePicture;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutOption;
	
	public WebElement getCalenderModule() {
		return calenderModule;
	}

	public WebElement getLeadsModule() {
		return leadsModule;
	}

	public WebElement getOrganizationsModule() {
		return organizationsModule;
	}

	public WebElement getContactsModule() {
		return contactsModule;
	}

	public WebElement getOpportunitiesModule() {
		return opportunitiesModule;
	}

	public WebElement getProductsModule() {
		return productsModule;
	}

	public WebElement getDashboardModule() {
		return dashboardModule;
	}

	public WebElement getMoreDropDown() {
		return moreDropDown;
	}

	public WebElement getCampaignsModule() {
		return campaignsModule;
	}

	public WebElement getVendorsModule() {
		return vendorsModule;
	}
 	
	public WebElement getAdministratorProfilePicture() {
		return administratorProfilePicture;
	}

	public WebElement getSignOutOption() {
		return signOutOption;
	}

	/**
	 * Business Logic
	 */
	
	public void clickOnLeadsModule()
	{
		leadsModule.click();
	}
	
	public void clickOnorganizationsModule()
	{
		organizationsModule.click();
	}
	
	public void clickOncontactsModule()
	{
		contactsModule.click();
	}
	
	public void clickOnopportunitiesModule()
	{
		opportunitiesModule.click();
	}
	
	public void clickOnproductsModule()
	{
		productsModule.click();
	}
	
	public void clickOndashboardModule()
	{
		dashboardModule.click();
	}
	
	public void clickOnmoreDropDown()
	{
		moreDropDown.click();
	}
	
	public void clickOnCampaignModule()
	{
		Actions action = new Actions(driver);
	    action.moveToElement(campaignsModule).perform();  // Actions Class to click on dropdown 
	    action.click(campaignsModule).perform();
	}
	
	public void clickOnVendorModule()
	{
		Actions action = new Actions(driver);
		action.moveToElement(moreDropDown).perform();
		action.click(vendorsModule).perform();
	}
	
	public void signOutAction()
	{
		Actions action = new Actions(driver);
		action.click(administratorProfilePicture).perform();
		action.click(signOutOption).perform();
	}
	
}
