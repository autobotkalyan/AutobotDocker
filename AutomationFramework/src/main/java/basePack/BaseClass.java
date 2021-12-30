package basePack;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.jayway.jsonpath.JsonPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class BaseClass
{
    WebDriver driver;

    public List<String> getResultFromXL() throws FilloException {

        List<String> list = new ArrayList<>();
        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection("src/main/resources/HealthData.xlsx");
        String strQuery="Select * from Sheet1";
        Recordset recordset=connection.executeQuery(strQuery);

        while(recordset.next()){
            list.add(recordset.getField("Endpoint"));
        }

        recordset.close();
        connection.close();

        return list;
    }

    public void writeXL(String result, int TestCaseNo) throws FilloException {
        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection("src/main/resources/HealthData.xlsx");
        String strQuery;

        strQuery = "Update Sheet1 Set Result='"+result+"' where TestCase = " + String.valueOf(TestCaseNo) + "";

        connection.executeUpdate(strQuery);

        connection.close();
    }

    public String getProperties(String value) throws IOException {
        File file = new File("src/main/resources/Data.properties");

        FileInputStream fileInputStream = null;

        try
        {
            fileInputStream = new FileInputStream(file);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }

        Properties properties = new Properties();
        properties.load(fileInputStream);

        return properties.getProperty(value);

    }

    public static BiFunction<String,String,Integer> retrieveIntegerFromResponse = (a,b) -> JsonPath.read(a,b);

    public static BiFunction<String,String,String> retrieveStringFromResponse = (a,b) -> JsonPath.read(a,b);

    public static BiConsumer<Integer,Integer> checkStatusCode = (a,b)-> {
                                                            assertSoftly(softAssertions ->{
                                                                softAssertions.assertThat(a)
                                                                        .isNotNull()
                                                                        .isEqualTo(b);
                                                                });
                                                            };

    public static BiConsumer<String,String> checkResult = (a,b)-> {
        assertSoftly(softAssertions ->{
            softAssertions.assertThat(a)
                    .isNotNull()
                    .isEqualTo(b);
        });
    };



//    public WebDriver ChromeDriver()
//    {
//        //Adding Key value of Chrome driver
//        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver");
//        //Initializing WebDriver
//        return new ChromeDriver();
//    }

}
