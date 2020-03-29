package Options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


/*
 * ako zelimo da pokrecemo iz testNG-ja onda moramo da konvertujemo JUnit u TestNG i za to koristimo extends paket AbstractTestNGCucumberTests
 * isto tako ugasimo anotaciju @RunWith
*/
//@RunWith(Cucumber.class)
@CucumberOptions(
		//ako zelimo da pokrenemo sve "features-e" samo upisemo putanju do paketa
		features = "src/test/java/features/login.feature",
		//package name
		glue ="stepDefinitions"
		)


public class TestRunner extends AbstractTestNGCucumberTests {
	



}
