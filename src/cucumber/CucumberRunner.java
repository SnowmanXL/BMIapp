package cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( monochrome = true,//format = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" },
		features = {"src/cucumber/myfeature.feature"})
public class CucumberRunner {

	public CucumberRunner() {
		// TODO Auto-generated constructor stub
	}

}