package runTest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by thinkpad on 2017/2/6.
 */
@CucumberOptions(
        features = "src/test/features/first_feature.feature",
        format = {
                "pretty",
                "html:target/site/cucumber-pretty",
                "rerun:target/sige/rerun.txt",
                "json:target/cucumber1.json"
        },
        tags = "@P0",
        glue = {"Steps"}


)

public class RunDemo extends AbstractTestNGCucumberTests {
}
