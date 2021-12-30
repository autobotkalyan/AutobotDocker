package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignonPage
{
    @FindBy(name="userName")
    public WebElement txt_userName;

    @FindBy(name="password")
    public WebElement txt_password;

    @FindBy(name="submit")
    public WebElement btn_submit;

    @FindBy(xpath = "//*[text()='Login Successfully']")
    public WebElement msg_header;

    public SignonPage()
    {
        PageFactory.initElements(SeleniumDriver.getDriver(),SignonPage.this);
    }

    public void loginDetails(String userName, String password)
    {
        this.txt_userName.sendKeys(userName);
        this.txt_password.sendKeys(password);
    }

    public void clickSubmit()
    {
        this.btn_submit.click();
    }
}
