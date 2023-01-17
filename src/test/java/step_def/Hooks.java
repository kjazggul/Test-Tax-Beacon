package step_def;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import util.Driver;

public class Hooks {

    private Driver driver;

    @Before
    public void setup(Scenario scenario) {



        // Anything that you want to run before each Scenario]
//        TempStorage.clear();
//        Log.start(scenario.getName());
//        ExtentReport.startTest(scenario.getName());
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.embed(screenshot, "image/png");
           // ExtentReport.fail();

        } else {
           // ExtentReport.pass();
        }
      //  Driver.quitDriver();

    }






}
