package swaglabs.myrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(  
	
		plugin= {"pretty","json:CucumberReport/cucumber-reports/cucumber.json"},
		features = "Features/",
		glue = {"swaglabs.stepdef","swaglabs.hooks"},
		tags = "@sanity",
		monochrome=true, 
		dryRun=false
		)
public class LoginRunner  extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;
 
    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("Cucumber Test Class Before");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 
    @Test(groups = "cucumber", description = "Runs LoginCandiate Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        System.out.println("Cucumber Test Class Inside Test");
        System.out.println(cucumberFeature.getCucumberFeature());
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        System.out.println("Data Provider test Class");
        return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}
