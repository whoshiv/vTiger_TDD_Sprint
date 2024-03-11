package vtiger.genericUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

// Selenium ke methods yaha aayenge ... jaise ki
// Dropdown ke liye... Mouse hover ke liye
//Explicit  Wait , Impliict wait laga liya
// Dusre window mai switch kar liya, dusre frame mai switch kar liya
//Alert pop up handel kar liya
//Basic concepts mai jo bhi padhai hai Selenium ka... wo yaha par banana padega
//Action class, Select class, Synchronization sab banane padenge

public class WebDriverUtility {

	public void waitForElement(WebDriver driver)
	{    // Aise same package mai call kar sakyte hai ??
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstant.IMPLICIT_WAIT_DURATION));
	}
	
	public void maximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void waitForButtonToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.EXPLICIT_WAIT_DURATION));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void switchToWindow(WebDriver driver, String titleOfPageToSwitch) throws InterruptedException
	{
      Set<String> allIds = driver.getWindowHandles(); 
      System.out.println("kitne page hai "+allIds.size()); // total no of windows
      for(String id:allIds)
      {    
	  
	    driver.switchTo().window(id);
	    System.out.println(id);
	    String currentwindowtitle = driver.getTitle();
	    System.out.println("current title kya aaya "+currentwindowtitle);
	    
        System.out.println("Title of pages to switch kya hai "+titleOfPageToSwitch);
	    if(currentwindowtitle.contains(titleOfPageToSwitch))
	    {
		  System.out.println(currentwindowtitle);
		  break;
	    }
      } 
		
		 /**Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String wTle = it.next();
			driver.switchTo().window(wTle);
			String currentWindowTitle = driver.getTitle();
			if (currentWindowTitle.contains(titleOfPageToSwitch)) {
				break;
			}
		}**/
	}
	
	//Static kyun banaya hai
	public static void takeAScreenShot(WebDriver driver, String filename) throws IOException 
   	{ 
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		JavaUtility jutils = new JavaUtility();
		String dateandtime = jutils.generateSystemDateAndTime();
		File target = new File("./src/test/resources/screenshots/"+filename+dateandtime+".png");
		Files.copy(source,target);
    }
	
	public void selectOKInAlertPopUp(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void selectCancelInAlertPopUp(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
}