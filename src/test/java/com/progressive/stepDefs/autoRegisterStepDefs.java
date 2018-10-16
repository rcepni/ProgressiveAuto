package com.progressive.stepDefs;

import com.progressive.pages.AutoRegisterPage;
import com.progressive.pages.MainPage;
import com.progressive.utilities.BrowserUtils;
import com.progressive.utilities.ConfigurationReader;
import com.progressive.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class autoRegisterStepDefs {

	MainPage main = new MainPage();
	AutoRegisterPage reg = new AutoRegisterPage();
	
	
	
	@Given("the user is on the homepage of Progressive")
	public void the_user_is_on_the_homepage_of_Progressive() {
		System.out.println("Run by Hooks class");
	}

	@When("the user verifies url and title while on the homepage.")
	public void the_user_verifies_url_and_title_while_on_the_homepage() {
	    Assert.assertEquals("Title did not match","Progressive: Ranked One Of The Best Insurance Companies | Progressive", Driver.getDriver().getTitle());
	}

	@When("the user clicks on the Auto button")
	public void the_user_clicks_on_the_Auto_button() {
	    main.autoButton.click();
	}

	@When("the user enters the zip code")
	public void the_user_enters_the_zip_code() {
	   main.zipCodeInput.sendKeys("22312");
	}

	@When("the user clicks on the Quote Auto button")
	public void the_user_clicks_on_the_Quote_Auto_button() {
	    BrowserUtils.waitForClickablility(main.QuoteAutoButton, 3).click();
	}

	@When("the user enters the first name")
	public void the_user_enters_the_first_name() {
	    reg.firstNameInput.sendKeys("RivRiv");
	}

	@When("the user enters the last name")
	public void the_user_enters_the_last_name() {
	    reg.lastNameInput.sendKeys("DeRiv");
	}

	@When("the user enters the address")
	public void the_user_enters_the_address() {
	    BrowserUtils.waitForClickablility(reg.address, 3).sendKeys("5650 General Washington Drive");
	}

	@When("the user enters the city")
	public void the_user_enters_the_city() {
	    reg.city.sendKeys("Alexandria");
	}

	@When("the user enters the date of birth")
	public void the_user_enters_the_date_of_birth() {
	    reg.dateOfBirth.sendKeys("11111995");
	   
	}

	@When("the user clicks on the Okay, start my quote button")
	public void the_user_clicks_on_the_Okay_start_my_quote_button() {
	    reg.submitNext.click();
	}

	@When("the user chooses the year of the vehicle")
	public void the_user_chooses_the_year_of_the_vehicle() {
		BrowserUtils.waitFor(1);
	    reg.yearOfCar(2015);
	}

	@When("the user chooses the make of the vehicle")
	public void the_user_chooses_the_make_of_the_vehicle() {
		BrowserUtils.waitFor(1);
	   reg.makeOfCar("Acura");
	}

	@When("the user chooses the model of the vehicle")
	public void the_user_chooses_the_model_of_the_vehicle() {
		BrowserUtils.waitFor(1);
	    reg.modelOfCar("MDX");
	}

	@When("the user selects body type")
	public void the_user_selects_body_type() {
		BrowserUtils.waitFor(1);
	    reg.selectBodyType().selectByIndex(2);
	}

	@When("the user selects the purpose of use")
	public void the_user_selects_the_purpose_of_use() {
		BrowserUtils.waitFor(1);
		reg.selectPrimaryUse().selectByIndex(2);
	}

	@When("user selects if the car is owned or leased")
	public void user_selects_if_the_car_is_owned_or_leased() {
		BrowserUtils.waitFor(1);
		reg.selectOwnOrLease().selectByVisibleText("Own");
		
	}

	@When("the user selects for how lond the car has been owned")
	public void the_user_selects_for_how_lond_the_car_has_been_owned() {
		
		BrowserUtils.waitFor(1);
		reg.selectHowLongHaveYouHad().selectByIndex(2);
	}

	@When("the user clicks on the Done button")
	public void the_user_clicks_on_the_Done_button() {
		BrowserUtils.waitFor(1);
		BrowserUtils.waitForVisibility(reg.submitNext, 3).click();
	}

	@When("the user clicks on the Save and Continue button")
	public void the_user_clicks_on_the_Save_and_Continue_button() {
		BrowserUtils.waitFor(1);
		BrowserUtils.waitForVisibility(reg.submitNext, 3).click();
	}

	@When("the user chooses the gender")
	public void the_user_chooses_the_gender() {
		BrowserUtils.waitFor(2);
		reg.GenderRadio("m");
		
	}

	@When("the user selects marital status")
	public void the_user_selects_marital_status() {
		BrowserUtils.waitFor(1);
		reg.selectMaritalStatus().selectByIndex(4);
	}

	@When("the user selects the highest level of education")
	public void the_user_selects_the_highest_level_of_education() {
		reg.selectEducationStatus().selectByIndex(7);
	}

	@When("the user selects employment status")
	public void the_user_selects_employment_status() {
		BrowserUtils.waitFor(1);
		reg.selectEmploymentStatus().selectByIndex(1);
	}

	@When("the user views the accupation list")
	public void the_user_views_the_accupation_list() {
		BrowserUtils.waitFor(2);
		reg.viewOccupationList.click();
	}

	@When("the user selects an industry from the industry selection list")
	public void the_user_selects_an_industry_from_the_industry_selection_list() {
		BrowserUtils.waitFor(1);
		reg.selectIndustry().selectByIndex(10);
	}

	@When("the user selects an occupation from the occupation list")
	public void the_user_selects_an_occupation_from_the_occupation_list() {
		reg.selectOccupation().selectByIndex(3);
	}

	@When("the user clicks on the save and continue button after selecting occupation")
	public void the_user_clicks_on_the_save_and_continue_button_after_selecting_occupation() {
		reg.submitNext.click();
	}

	@When("the user selects primary residence")
	public void the_user_selects_primary_residence() {
		BrowserUtils.waitFor(1);
		reg.selectPrimaryResidence().selectByIndex(3);
	}

	@When("the user answers the question if s\\/he moved in two years")
	public void the_user_answers_the_question_if_s_he_moved_in_two_years() {
		BrowserUtils.waitFor(1);
		reg.MovedInLast2MonthsRadio("N");
	}

	@When("the user selects the years licensed")
	public void the_user_selects_the_years_licensed() {
		BrowserUtils.waitFor(1);
		reg.selectYearsLicensed().selectByIndex(2);
	}

	@When("the user answers the question if s\\/he was involven in an accident")
	public void the_user_answers_the_question_if_s_he_was_involven_in_an_accident() {
		BrowserUtils.waitFor(1);
		reg.accidentsClaimsOrDamagesRadio("n");
	}

	@When("the user reports the violations and tictets")
	public void the_user_reports_the_violations_and_tictets() {
		BrowserUtils.waitFor(1);
		reg.ticketsOrViolationsRadio("n");
	}

	@When("the user clicks on the save and continue button and continues")
	public void the_user_clicks_on_the_save_and_continue_button_and_continues() {
		BrowserUtils.waitFor(2);
		reg.submitNext.click();
	}

	@When("the user clicks on the fourth save and continue button to continue")
	public void the_user_clicks_on_the_fourth_save_and_continue_button_to_continue() {
		BrowserUtils.waitFor(2);
		reg.submitNext.click();
	}

	@When("the user clicks on the save and continue button for the fifth time")
	public void the_user_clicks_on_the_save_and_continue_button_for_the_fifth_time() {
		BrowserUtils.waitFor(2);
		reg.submitNext.click();
	}

	@When("the user answers the question about insurance history")
	public void the_user_answers_the_question_about_insurance_history() {
		BrowserUtils.waitFor(3);
		reg.doYouHaveInsuranceRadio("y");
	}

	@When("the user selects the duration with s\\/he is insured with the current company")
	public void the_user_selects_the_duration_with_s_he_is_insured_with_the_current_company() {
		BrowserUtils.waitFor(1);
		reg.selectHowLongHaveYouBeenCurrentCompany().selectByIndex(2);
	}

	@When("the user selects most recent bodily injury limits")
	public void the_user_selects_most_recent_bodily_injury_limits() {
		reg.selectCurrentBodilyInjuryLimits().selectByIndex(2);
	}

	@When("the user chooeses if s\\/he has purchases a service from progressive other than car insurance")
	public void the_user_chooeses_if_s_he_has_purchases_a_service_from_progressive_other_than_car_insurance() {
		BrowserUtils.waitFor(1);
		reg.doYouHaveNonAutoPolicyProgressiveRadio("n");
	}

	@When("the user chooses if s\\/he was insured by progressive last month")
	public void the_user_chooses_if_s_he_was_insured_by_progressive_last_month() {
		BrowserUtils.waitFor(1);
		reg.haveYouHadInsuranceWithProgressiveRadio("n");
	}

	@When("the user enters the primary email address")
	public void the_user_enters_the_primary_email_address() {
		BrowserUtils.waitFor(2);
		reg.whenDoYouWantToStartPolicy(4, 7);
		BrowserUtils.waitFor(1);
		reg.primaryEmailEnter("ricepni@gmail.com");
	}

	@When("the user answers the question if the family members have health insurance")
	public void the_user_answers_the_question_if_the_family_members_have_health_insurance() {
		reg.areAllHouseholdCoveredByHealthInsuranceRadio("n");
	}

	@When("the user clicks oon the sixth save and continue button")
	public void the_user_clicks_oon_the_sixth_save_and_continue_button() {
		BrowserUtils.waitFor(1);
		reg.submitNext.click();;
	}

	@When("the customer is asked if s\\/he wants to use snatpshot")
	public void the_customer_is_asked_if_s_he_wants_to_use_snatpshot() {
		BrowserUtils.waitFor(2);
		reg.slctVehiclesToEnrollRadio("n");
		reg.submitNext.click();
	}

	@When("the customer clicks on the save and continiue button for the seventh time")
	public void the_customer_clicks_on_the_save_and_continiue_button_for_the_seventh_time() {
		BrowserUtils.waitFor(3);
		BrowserUtils.waitForVisibility(reg.finalPriceOfQuotePart1, 5);
		
		reg.finalPriceCheck();
	}
	
	
}
