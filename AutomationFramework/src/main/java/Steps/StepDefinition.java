package Steps;

import basePack.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class StepDefinition extends BaseClass
{
    BaseClass baseClass;
    Response response;

    @Given("I am on Regres application")
    public void iAmOnRegresApplication() throws IOException {
        baseClass = new BaseClass();
        RestAssured.baseURI = baseClass.getProperties("baseURI");
    }

    @When("^I check all the (.*)$")
    public void iCheckAllTheEndPoints(String endPoints) throws IOException
    {
        response = given().when().header("Content-Type","application/json").get(endPoints);
    }


    @Then("^I verify the (.*)$")
    public void iVerifyTheStatusCode(int expectedResult)
    {
        int actualResult = response.getStatusCode();
        checkStatusCode.accept(actualResult,expectedResult);
    }
}
