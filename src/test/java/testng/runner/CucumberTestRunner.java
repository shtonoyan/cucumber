package testng.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "@Smoke",
        glue = "testng",
        features = "src/test/resources/features"
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
