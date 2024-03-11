package vtiger.pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
    WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;

	}
	/**
	 *
	 * @param organizationname
	 * @return String
	 */
	public String fetchOrganizationInformation(String organizationname)
	{
	return driver.findElement(By.xpath("//span[contains(text(),'"+organizationname+"')]")).getText();
    }
}

