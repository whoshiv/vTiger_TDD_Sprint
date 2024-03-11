package vtiger.pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v120.page.Page;
import org.openqa.selenium.support.PageFactory;

public class LeadsInformationPage {
	WebDriver driver;
	public LeadsInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/**
	 * This method is used to verify last name
	 * @param leadLastName
	 */
	public String fetchLeadInformation(String leadLastName)
	{
		return driver.findElement(By.xpath("//span[contains(text(),'"+leadLastName+"')]")).getText();
		// Variable name bhi double quotes mai aayega
	}
	
}
