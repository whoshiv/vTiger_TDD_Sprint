package vtiger.lead_Module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.genericUtils.BaseClass;
import vtiger.genericUtils.IPathConstant;
import vtiger.pomRepo.CreatingNewLeadsPage;
import vtiger.pomRepo.HomePage;
import vtiger.pomRepo.LeadsInformationPage;
import vtiger.pomRepo.LeadsPage;

//class ka naam Scenario/Module ke naam se hoga
@Listeners(vtiger.genericUtils.ITestListenersImplemantation.class)
public class ToCreateALeadTest extends BaseClass {

	@Test(retryAnalyzer = vtiger.genericUtils.RetryAnalyzer.class, groups = "regression" )  
	// Method ka naam hoga joki --Manual Test Case ka naam hoga
	public void toCreateALeadAndVerifyTheLeadInfo() throws EncryptedDocumentException, IOException
	{
	  //Test Data
	 String leadsalutation = eUtils.fetchStringDataFromExcelFile(IPathConstant.LEAD_SHEET_NAME, 1, 0);
	 String leadfirstname=eUtils.fetchStringDataFromExcelFile(IPathConstant.LEAD_SHEET_NAME, 1, 1);
	 String leadlastname=eUtils.fetchStringDataFromExcelFile(IPathConstant.LEAD_SHEET_NAME, 1, 2);
	 String leadcompanyname = eUtils.fetchStringDataFromExcelFile("lead", 1, 3);
	 
	 //POM Object Creation
	 
	 HomePage home = new HomePage(driver);
//	 LeadsInformationPage create = new LeadsInformationPage(driver);
	 LeadsPage lead = new LeadsPage(driver);
	 CreatingNewLeadsPage createlead =new CreatingNewLeadsPage(driver);
	 LeadsInformationPage leadinfo = new LeadsInformationPage(driver);
	 
	 //Jan karke fail kar rahe hai
	 Assert.fail();
	 
	 home.clickOnLeadsModule();
	 lead.clickOnLeadsPlusButton();
	 //Creating Lead
	 createlead.selectLeadSalution(leadsalutation);
	 createlead.enterLeadFirstName(leadfirstname);
	 createlead.enterLeadLastName(leadlastname);
	 createlead.enterCompanyName(leadcompanyname);
	 createlead.clickOnSaveButton();
	 
	 String actualleadinformation = leadinfo.fetchLeadInformation(leadlastname);
	 //Assert true lagayenge
	 Assert.assertTrue(actualleadinformation.contains(leadlastname));
	 System.out.println("Pass: The lead has been created");
	}
}