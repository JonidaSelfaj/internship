package test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/feature",
        glue = "internship.steps"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {


}
