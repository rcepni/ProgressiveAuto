package com.progressive.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.errorprone.annotations.RequiredModifiers;
import com.progressive.utilities.BrowserUtils;
import com.progressive.utilities.Driver;

import junit.framework.Assert;

public class AutoRegisterPage {

	public AutoRegisterPage() {
			PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	@FindBy(id="NameAndAddressFormModel_FirstName_Value")
	public WebElement firstNameInput;
	
	@FindBy(id="NameAndAddressFormModel_LastName_Value")
	public WebElement lastNameInput;
	
	@FindBy(id="NameAndAddressFormModel_DateOfBirth_Value")
	public WebElement dateOfBirth;  // mm/dd/yyyy
	
	@FindBy(id="NameAndAddressFormModel_MailingAddress_Value")
	public WebElement address;
	
	@FindBy(id="NameAndAddressFormModel_City_Value")
	public WebElement city;
	
	@FindBy(id="next")
	public WebElement submitNext;
	
	@FindBy(id="UnlistedVehicleFormModel_BodyStyle_Value")
	public WebElement body;
	
	@FindBy(xpath="(//div[@id='UnlistedVehicleFormModel_VehicleUse_Div']//select)[1]")							//(id="UnlistedVehicleFormModel_VehicleUse_Value")
	public WebElement use;
	
	@FindBy(xpath="//div[@id='UnlistedVehicleFormModel_OwnOrLease_Div']//select")
	public WebElement own;
	
	@FindBy(id="UnlistedVehicleFormModel_LengthOfOwnership_Value")
	public WebElement howlong;
	
	@FindBy(id="EditPniDetailsFormModel_DriverDetail_MaritalStatus_Value")
	public WebElement mStatus;
	
	@FindBy(id="EditPniDetailsFormModel_DriverDetail_HighestLevelOfEducation_Value")
	public WebElement educa;
	
	@FindBy(id="EditPniDetailsFormModel_DriverDetail_EmploymentStatus_Value")
	public WebElement empSta;
	
	@FindBy(xpath="//label[@id='EditPniDetailsFormModel_DriverDetail_Occupation_Value_Label']/a[@class='clickable submit-link']")
	public WebElement viewOccupationList;
	
	@FindBy(id="OccupationListFormModel_Industry_Value")
	public WebElement indust;
	
	@FindBy(id="OccupationListFormModel_ListedOccupation_Value")
	public WebElement occupa;
	
	@FindBy(id="EditPniDetailsFormModel_DriverDetail_PrimaryResidence_Value")
	public WebElement primRes;
	
	@FindBy(id="EditPniDetailsFormModel_DriverDetail_LicenseStatus_Value")
	public WebElement licSta;
	
	@FindBy(id="EditPniDetailsFormModel_DriverDetail_DriverYearsLicensed_Value")
	public WebElement yearLi;
	
	@FindBy(id="FinalDetailsFormModel_RecentAutoInsuranceCompanyPeriod_Value")
	public WebElement howLongCurComp;
	
	@FindBy(id="FinalDetailsFormModel_BodilyInjuryLimits_Value")
	public WebElement curBodIncLim;
	
	@FindBy(xpath="//span[@class='calendar-icon']")
	public WebElement calenderButton;
	
	@FindBy(id="FinalDetailsFormModel_PrimaryEmailAddress_Value")
	public WebElement priEmail;
	
	@FindBy(id="no-thanks-link")
	public WebElement noThanksLink;
	
	@FindBy(xpath="//p[@class='price']")
	public WebElement finalPriceOfQuotePart1;
	
	@FindBy(xpath="//p[@class='price']//following-sibling::p")
	public WebElement finalPriceOfQuotePart2;
	
	
	public void primaryEmailEnter(String email) {
		priEmail.sendKeys(email);
	}
	
	public void yearOfCar(int year){  //Sample : 1999, 2000
		Driver.getDriver().findElement(By.xpath("//ul[@id='UnlistedVehicleFormModel_Year_Value']//li[text()="+year+"]")).click();
	}
	
	
	public void makeOfCar(String make){ //sample : "Dodge", "BMW", "Acura"
		Driver.getDriver().findElement(By.xpath("//li[contains(text(),'"+make+"')]")).click();
	}
	
	public void modelOfCar(String model){ // sample " "Camry", "Corolla"
		Driver.getDriver().findElement(By.xpath("//ul[@id='UnlistedVehicleFormModel_Model_Value']//li[contains(text(),'"+model+"')]")).click();
	}
	
	public Select selectBodyType(){  // better to select by index
		Select select =new Select(body);
		return select;
	}
	
	public Select selectPrimaryUse(){  // better to pick by first index or 2, 3
		Select select =new Select(use);
		return select;
	}
	
	public Select selectOwnOrLease(){ // sample: "Own" , "Lease"
		Select select =new Select(own);
		return select;
	}
	
	public Select selectHowLongHaveYouHad(){ // better to select by index like first 3-4
		Select select =new Select(howlong);
		return select;
	}
	
	
	public void GenderRadio(String gender) {  // sample : male or female (case sensitive!)
		List<WebElement> findElements = Driver.getDriver().findElements(By.xpath("//div[@id='EditPniDetailsFormModel_DriverDetail_Gender_Div']//input"));
//		findElements.get(1).click();
		for(int i=0 ; i<findElements.size() ; i++ ) {
			if(findElements.get(i).getAttribute("Value").equalsIgnoreCase(gender)) findElements.get(i).click();
		}
	}
	
	public Select selectMaritalStatus(){ // sample: "Single", "Divorced"    or select by index to 6
		Select select =new Select(mStatus);
		return select;
	}
	
	public Select selectEducationStatus(){ // better to select by index to 7
		Select select =new Select(educa);
		return select;
	}
	
	public Select selectEmploymentStatus(){ // Sample: "Employed"  better to pick this for the scenario
		Select select =new Select(empSta);
		return select;
	}
	
	public Select selectIndustry(){ // better to go by index number up to 15-20
		Select select =new Select(indust);
		return select;
	}
	
	public Select selectOccupation(){ // better to go by index number up to 20-30 depends on the selected Industry
		Select select =new Select(occupa);
		return select;
	}
	
	public Select selectPrimaryResidence(){ // better to go by index number up to 4-5. First one is null
		Select select =new Select(primRes);
		return select;
	}
	
	public void MovedInLast2MonthsRadio(String yesNo) {  // sample : Yes or No (ignoredCase!)
		List<WebElement> findElements = Driver.getDriver().findElements(By.xpath("//div[@id='EditPniDetailsFormModel_DriverDetail_HasPriorAddress_Div']//input"));
		for(int i=0 ; i<findElements.size() ; i++) {
			if(findElements.get(i).getAttribute("Value").equalsIgnoreCase(yesNo)) findElements.get(i).click();
		}
	}
	
	public Select selectLicenseStatus(){ // better to go by "Valid" or with the first index
		Select select =new Select(licSta);
		return select;
	}
	
	public Select selectYearsLicensed(){ // better to go by index up to 5. First one is null
		Select select =new Select(yearLi);
		return select;
	}
	
	public void accidentsClaimsOrDamagesRadio(String yesNo) {  // sample : Yes or No (ignoredCase!)
		List<WebElement> findElements = Driver.getDriver().findElements(By.xpath("//div[@id='EditPniDetailsFormModel_DriverDetail_HasAccidentsOrClaims_Div']//input"));
		for(int i=0 ; i<findElements.size() ; i++) {
			if(findElements.get(i).getAttribute("Value").equalsIgnoreCase(yesNo)) findElements.get(i).click();
		}
	}
	
	
	public void ticketsOrViolationsRadio(String yesNo) {  // sample : Yes or No (ignoredCase!)
		List<WebElement> findElements = Driver.getDriver().findElements(By.xpath("//div[@id='EditPniDetailsFormModel_DriverDetail_HasTicketsOrViolations_Div']//input"));
		for(int i=0 ; i<findElements.size() ; i++) {
			if(findElements.get(i).getAttribute("Value").equalsIgnoreCase(yesNo)) findElements.get(i).click();
		}
	}
	
	public void doYouHaveInsuranceRadio(String yesNo) {  // sample : Yes or No (ignoredCase!)
		List<WebElement> findElements = Driver.getDriver().findElements(By.xpath("//div[@id='FinalDetailsFormModel_InsuranceToday_Div']//input"));
		for(int i=0 ; i<findElements.size() ; i++) {
			if(findElements.get(i).getAttribute("Value").equalsIgnoreCase(yesNo)) findElements.get(i).click();
		}
	}
	
	public Select selectHowLongHaveYouBeenCurrentCompany(){ // better to go by index up to 5, the first one is null
		Select select =new Select(howLongCurComp);
		return select;
	}
	
	public Select selectCurrentBodilyInjuryLimits(){ // better to go by index 2 to 5
		Select select =new Select(curBodIncLim);
		return select;
	}
	
	public void doYouHaveNonAutoPolicyProgressiveRadio(String yesNo) {  // sample : Yes or No (ignoredCase!)
		List<WebElement> findElements = Driver.getDriver().findElements(By.xpath("//div[@id='FinalDetailsFormModel_OtherPolicies_Div']//input"));
		for(int i=0 ; i<findElements.size() ; i++) {
			if(findElements.get(i).getAttribute("Value").equalsIgnoreCase(yesNo)) findElements.get(i).click();
		}
	}
	
	public void haveYouHadInsuranceWithProgressiveRadio(String yesNo) {  // sample : Yes or No (ignoredCase!)
		List<WebElement> findElements = Driver.getDriver().findElements(By.xpath("//div[@id='FinalDetailsFormModel_PriorProgressive_Div']//input"));
		for(int i=0 ; i<findElements.size() ; i++) {
			if(findElements.get(i).getAttribute("Value").equalsIgnoreCase(yesNo)) findElements.get(i).click();
		}
	}
	
	public void whenDoYouWantToStartPolicy(int row, int column) { // row start from 1, column 2 to 8
		BrowserUtils.waitForClickablility(Driver.getDriver().findElement(By.xpath("//span[@class='calendar-icon']")), 5).click();
		BrowserUtils.waitForClickablility(Driver.getDriver().findElement(By.xpath("//ul[@class='dropdown-menu']//tr["+row+"]//td["+column+"]")),5).click();;
	}
	
	public void areAllHouseholdCoveredByHealthInsuranceRadio(String yesNo) {  // sample : Yes or No (ignoredCase!)
		List<WebElement> findElements = Driver.getDriver().findElements(By.xpath("//div[@id='FinalDetailsFormModel_HealthInsurance_Div']//input"));
		for(int i=0 ; i<findElements.size() ; i++) {
			if(findElements.get(i).getAttribute("Value").equalsIgnoreCase(yesNo)) findElements.get(i).click();
		}
	}
	
	
	public void slctVehiclesToEnrollRadio(String yesNo) {  // sample : Yes or No (ignoredCase!) we are not ready for Yes scenario
		List<WebElement> findElements = Driver.getDriver().findElements(By.xpath("//div[@id='SnapshotFormModel_SnapshotEnrollments_0__Div']//input"));
		for(int i=0 ; i<findElements.size() ; i++) {
			if(findElements.get(i).getAttribute("Value").equalsIgnoreCase(yesNo)) findElements.get(i).click();
		}
	}
	
	public void finalPriceCheck() {
		int startPnt = finalPriceOfQuotePart2.getText().indexOf("Total");
		int endPnt = finalPriceOfQuotePart2.getText().indexOf("*");
		String totalPrice = finalPriceOfQuotePart2.getText().substring(startPnt, endPnt);
		Assert.assertTrue(finalPriceOfQuotePart2.isDisplayed());
		System.out.println("Your final quote in "+ totalPrice);
	}
	
	
}
