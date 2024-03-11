package vtiger.opportunity_module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.genericUtils.BaseClass;
import vtiger.genericUtils.IPathConstant;
import vtiger.pomRepo.CampaignInformationPage;
import vtiger.pomRepo.CampaignPage;
import vtiger.pomRepo.CreatingNewCampaignPage;
import vtiger.pomRepo.CreatingNewOpportunityPage;
import vtiger.pomRepo.CreatingNewOrganizationPage;
import vtiger.pomRepo.HomePage;
import vtiger.pomRepo.OpportunitiesPage;
import vtiger.pomRepo.OpportunityInformationPage;
import vtiger.pomRepo.OrganizationInformationPage;
import vtiger.pomRepo.OrganizationPage;

@Listeners(vtiger.genericUtils.ITestListenersImplemantation.class)
public class ToCreateOpportunityTest extends BaseClass{

	@Test(retryAnalyzer = vtiger.genericUtils.RetryAnalyzer.class, groups = "smoke")
	public void toCreateAnOpportunityWithOrganizationAndCampaignDetails() throws EncryptedDocumentException, IOException, InterruptedException
	{
		 String organizationName = eUtils.fetchStringDataFromExcelFile(IPathConstant.ORGANIZATION_SHEET_NAME,1, 0)+jUtils.generateRandomNumber(10000);
		 
		// String organizationName = "Boat25";
		 System.out.println(organizationName);
		String campaignName = eUtils.fetchStringDataFromExcelFile(IPathConstant.CAMPAIGN_SHEET_NAME,1, 0);
	//	 String campaignName = "TV Adds10"; 
		// String opportunityName = "";
		// String opportunityClosingDate = 
        // String opportunityLookUpPageTitle =
        // String campaignLookUpPageTitle
		 String opportunityName = eUtils.fetchStringDataFromExcelFile(IPathConstant.OPPORTUNITY_SHEET_NAME,1, 0);
		 String opportunityClosingDate = eUtils.fetchDateDataFromExcelFile(IPathConstant.OPPORTUNITY_SHEET_NAME,1, 1);
		 String opportunityLookUpPageTitle = eUtils.fetchStringDataFromExcelFile(IPathConstant.OPPORTUNITY_SHEET_NAME, 1, 2);
		 System.out.println("opportnity page title "+opportunityLookUpPageTitle);
		 String campaignLookUpPageTitle = eUtils.fetchStringDataFromExcelFile(IPathConstant.OPPORTUNITY_SHEET_NAME, 1, 3);
		 
		 
		 HomePage home = new HomePage(driver);
		 OrganizationPage organization = new OrganizationPage(driver);
		 CreatingNewOrganizationPage createOrganization= new CreatingNewOrganizationPage(driver);
		 OrganizationInformationPage organizationInfo = new OrganizationInformationPage(driver); 
		 
		 CampaignPage campaign = new CampaignPage(driver);
		 CreatingNewCampaignPage createCampaign= new CreatingNewCampaignPage(driver);
		 CampaignInformationPage campaignInfo =new CampaignInformationPage(driver);
		 
		 OpportunitiesPage opportunity= new OpportunitiesPage(driver);
		 CreatingNewOpportunityPage createOpportunity=new CreatingNewOpportunityPage(driver);
		 OpportunityInformationPage opportunityInfo =new OpportunityInformationPage(driver);
		 
		 home.clickOnorganizationsModule();
		 organization.clickOnorganizationPlusButton();
		 createOrganization.enterOrganizationName(organizationName);
		 createOrganization.clickOnSaveButton();
		 
		 System.out.println("CLICKED sAVED IN oRGANIZATION module");
		 
		 String actualOrganizationName = organizationInfo.fetchOrganizationInformation(organizationName);
		 Assert.assertTrue(actualOrganizationName.contains(organizationName));
		 System.out.println("Pass: The organization has been created");
		 
		 home.clickOnmoreDropDown(); //added 
		 home.clickOnCampaignModule();
		 campaign.clickOnCampaignPlusButton();
		 createCampaign.enterCampaignName(campaignName);
		 createCampaign.clickOnSaveButton();
		 
		 String actualCampaignName = campaignInfo.fetchCampaignInformationPage(campaignName);
		 Assert.assertTrue(actualCampaignName.contains(campaignName));
		 System.out.println("Pass: The campaign has been created");
		 
		 home.clickOnopportunitiesModule();
		 opportunity.clickOnOpportunitiesPlusButton();
		 createOpportunity.enterOpportunityName(opportunityName);
		 createOpportunity.clickAndSelectOrganizationNameFromLookUpPage(organizationName, opportunityLookUpPageTitle);
		 
		 createOpportunity.clickAndSelectCampaignNameFromLookUpPage(campaignName, campaignLookUpPageTitle);
		 createOpportunity.enterClosingDate(opportunityClosingDate);
		 createOpportunity.clickOnSaveButton();
		 
		 String actualOpportunityInfo = opportunityInfo.fetchOpportunityInformation(opportunityName);
		 Assert.assertTrue(actualOpportunityInfo.contains(opportunityName));
		 System.out.println("Pass: The Opportunity has been created");
	}

	
}
