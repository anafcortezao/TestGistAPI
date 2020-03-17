package runners;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/"
        , glue = "steps"
        ,plugin = {"pretty", "html:target/cucumber-html-report"})

public class RunAllTests {

}
