package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.RegisterPage;

public class RegisterSteps
{

    //Pages declaration
    RegisterPage registerPage;

    @When("I click register link")
    public void iClickRegisterLink()
    {
        registerPage = new RegisterPage();
        registerPage.clickRegister();
    }

    @And("I enter the registeration details")
    public void iEnterTheRegisterationDetails()
    {
        registerPage.enterRegisterPageDetails();
    }
}
