package vtiger.pomRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v120.page.Page;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	WebDriver driver;
 public CampaignInformationPage(WebDriver driver) {
	
	 PageFactory.initElements(driver, this);
	 this.driver= driver;
    }
 
 /**
  * 
  * @param camapignname
  * @return
  */
 public String fetchCampaignInformationPage(String camapignname)
 {
	 return driver.findElement(By.xpath("//span[contains(text(),'"+camapignname+"')]")).getText();
	
 }
}
