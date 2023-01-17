package step_def;

import org.openqa.selenium.WebDriver;
import util.Driver;

public class Test {
    WebDriver driver ;
    @org.junit.Test
    public void test(){

        driver = Driver.getDriver();
        driver.get("https://stackoverflow.com/");


    }
}
