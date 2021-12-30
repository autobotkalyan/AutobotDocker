import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"Steps"},
        tags = {"@Smoke"},
        plugin = { "pretty", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"}
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests
{

}
