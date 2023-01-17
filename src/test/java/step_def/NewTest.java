package step_def;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Driver;

public class NewTest {
WebDriver driver = Driver.getDriver();


    @Given("Visit website Assets")
    public void visit_website_Assets() {
     driver.get("https://assets2-dev.timelysoft.org/auth/login");
    }

    @When("I input {string}, {string}")
    public void i_input(String login, String password) {
      WebElement inputLogin = driver.findElement(By.xpath("//input[@type='text']"));
      inputLogin.sendKeys(login);
      WebElement inputPassword = driver.findElement(By.xpath("//input[@type='password']"));
      inputPassword.sendKeys(password);
      WebElement loginButton = driver.findElement(By.xpath("//button[@style='min-height: 4rem; font-size: 1.5rem; font-weight: 700;']"));
      loginButton.click();

    }

    @Then("I should see page")
    public void i_should_see_page() {

    }

}
