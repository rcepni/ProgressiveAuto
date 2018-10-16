package com.progressive.stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.progressive.utilities.ConfigurationReader;
import com.progressive.utilities.DBUtils;
import com.progressive.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void setUp() {
		 Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 Driver.getDriver().manage().window().fullscreen();
		 Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	}

	// @Before("@amazon_check")
	// public void setUpAmazon() {
	// Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	// Driver.getDriver().manage().window().fullscreen();
	// Driver.getDriver().get("http://amazon.com");
	// }

	@Before("@db")
	public void setUpDBConnection() {
		DBUtils.createConnection();
	}

	@After("@db")
	public void tearDownDBConnection() {
		DBUtils.destroy();
	}

	@After
	public void tearDown(Scenario scenario) {
		// only takes a screenshot if the scenario fails
		if (scenario.isFailed()) {
			// taking a screenshot
			final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			// adding the screenshot to the report
			scenario.embed(screenshot, "image/png");
		}
		Driver.closeDriver();
	}

}
