package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.SeleniumDriver;
import pages.SignonPage;

import java.io.ByteArrayInputStream;

import static basePack.BaseClass.checkResult;

public class LoginSteps
{

    WebDriver driver;
    SignonPage signonPage;

    @Before
    @Given("^I am on Mercury application$")
    public void login()
    {
        SeleniumDriver.setUpDriver();
        SeleniumDriver.openPage("http://demo.guru99.com/test/newtours/login.php");
    }

    @When("^I enter (.*) and (.*)$")
    public void iEnterUserNameAndPassword(String userName, String password)
    {
        signonPage = new SignonPage();
        signonPage.loginDetails(userName,password);
    }

    @And("^I click on submit button$")
    public void iClickOnSubmitButton()
    {
        signonPage.clickSubmit();
    }

    @Then("^I am on the HomePage$")
    public void iAmOnTheHomePage()
    {
        String actualResult = signonPage.msg_header.getText();
        String expectedResult = "Login Successfull";
        checkResult.accept(expectedResult,actualResult);
    }

    @After
    public void quitBrowser(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            Allure.addAttachment("Failure_Screenshot",new ByteArrayInputStream(((TakesScreenshot)SeleniumDriver.getDriver()).getScreenshotAs(OutputType.BYTES)));
        }
        SeleniumDriver.tearDown();
    }



}
