package com.progressive.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			plugin= {
					"html:target/default-cucumber-reports",
					"json:target/cucumber.json",
					"junit:target/cucumber.xml"
					},
			tags="@progressive",
			features="src/test/resources/features",
			glue="com.progressive.stepDefs"
//			,dryRun=true
		)


public class CukesRunner {

}
