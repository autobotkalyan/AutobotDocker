package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumDriver
{
    //Object declaration
    private static SeleniumDriver seleniumDriver;

    private static WebDriver driver;

    private final static int TIMEOUT = 30;

    private SeleniumDriver()
    {
        //Adding Key value of Chrome driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    }

    public static void openPage(String URL)
    {
        driver.get(URL);
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

    public static void setUpDriver()
    {
        if(seleniumDriver == null)
        {
            seleniumDriver = new SeleniumDriver();
        }
    }

    public static void tearDown()
    {
        if(driver !=null)
        {
            driver.close();
            driver.quit();
        }

        seleniumDriver = null;
    }
}
