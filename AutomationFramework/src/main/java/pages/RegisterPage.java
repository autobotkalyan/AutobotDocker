package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage
{

    Faker faker;

    @FindBy(linkText="REGISTER")
    public WebElement lnk_Register;

    @FindBy(name="firstName")
    public WebElement txt_firstName;

    @FindBy(name="lastName")
    public WebElement txt_lastName;

    @FindBy(name="phone")
    public WebElement txt_phone;

    @FindBy(id="userName")
    public WebElement txt_email;

    @FindBy(name="address1")
    public WebElement txt_address;

    @FindBy(name="city")
    public WebElement txt_city;

    @FindBy(name="state")
    public WebElement txt_state;

    @FindBy(name="postalCode")
    public WebElement txt_zipCode;

    @FindBy(id="email")
    public WebElement txt_userName;

    @FindBy(name="password")
    public WebElement txt_password;

    @FindBy(name="confirmPassword")
    public WebElement txt_confirmPassword;

    @FindBy(name="country")
    public WebElement cbo_country;

    @FindBy(name="submit")
    public WebElement btn_submit;

    public RegisterPage()
    {

        PageFactory.initElements(SeleniumDriver.getDriver(),RegisterPage.this);
    }

    public void clickRegister()
    {
        this.lnk_Register.click();
    }

    public void enterRegisterPageDetails()
    {
        faker = new Faker();

        this.txt_firstName.sendKeys(faker.name().firstName());
        this.txt_lastName.sendKeys(faker.name().lastName());
        this.txt_phone.sendKeys(faker.phoneNumber().cellPhone());
        this.txt_email.sendKeys(faker.internet().emailAddress());
        this.txt_address.sendKeys(faker.address().streetAddress());
        this.txt_city.sendKeys(faker.address().cityName());
        this.txt_state.sendKeys(faker.address().state());
        this.txt_zipCode.sendKeys(faker.address().zipCode());
        Select cbo_country = new Select(this.cbo_country);
        cbo_country.selectByVisibleText("UNITED STATES");
        this.txt_userName.sendKeys(faker.name().username());
        this.txt_password.sendKeys(faker.internet().password());
        this.txt_confirmPassword.sendKeys(faker.internet().password());
        this.btn_submit.click();
    }

}
