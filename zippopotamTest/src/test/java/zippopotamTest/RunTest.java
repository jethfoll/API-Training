package zippopotamTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		dryRun = false,
		snippets = SnippetType.CAMELCASE,
		features = "src/test/resources/features",
		glue ={"classpath:RequestTest" },
		plugin = {"pretty"},
		monochrome = true,
		publish = false
		)
public class RunTest {

}
