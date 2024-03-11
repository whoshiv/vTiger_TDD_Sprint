package vtiger.genericUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mysql.cj.jdbc.Driver;

import io.opentelemetry.context.internal.shaded.WeakConcurrentMap;
import vtiger.pomRepo.HomePage;
import vtiger.pomRepo.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sdriver; // to pass driver to the screenshot method in Ilistener
	
	public FileUtility fUtils = new FileUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	public JavaUtility jUtils = new JavaUtility();
	public WebDriverUtility wUtils = new WebDriverUtility();
	
	public Connection connection;
	
	
	@BeforeSuite()
	public void bsConfig() throws SQLException
	{   
        Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql/vtiger", "root", "root");
		System.out.println("DataBase Connection has been Established");
	}
 
	@BeforeClass()
	public void btConfig() throws IOException
	{   
		String browser = fUtils.fetchDataFromPropertyFile("browser");
		String url = fUtils.fetchDataFromPropertyFile("url");
		System.out.println("Launch the browser & Navigate to the URl");
		if(browser.contains("chrome"))
		{
			driver = new ChromeDriver();
		}
		if(browser.contains("firefox"))
		{
			driver = new FirefoxDriver();
		}
		if(browser.contains("edge"))
		{
			driver = new EdgeDriver();
		}
		
		sdriver = driver;
		wUtils.maximizeTheWindow(driver);
		wUtils.waitForElement(driver);
		System.out.println("Launch the Browser");
		driver.get(url);
		System.out.println("Navigate to the URL");
	}
	
	@BeforeMethod()
	public void bmConfig() throws IOException
	{
		String username = fUtils.fetchDataFromPropertyFile("username");
		String password = fUtils.fetchDataFromPropertyFile("password");
		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);
		System.out.println("Login to the application");
	}
	@AfterMethod()
	public void amConfig() throws IOException
	{
		HomePage home = new HomePage(driver);
		home.signOutAction();
	}
	
	@AfterClass()
	public void acConfig()
	{
		driver.quit();
		System.out.println("Browser is closed");
	}
	
	@AfterSuite()
	public void asConfig() throws SQLException
	{
		connection.close();
		System.out.println("The Database is closed");
	}
}
