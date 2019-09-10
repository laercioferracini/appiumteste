package cursoselenium.test;

import com.aventstack.extentreports.ExtentReports;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.UnsupportedEncodingException;

@RunWith(Cucumber.class)
//@CucumberOptions(
//        format = {"pretty", "json:target/json/output.json"},
//        features = {"C:\\Users\\laercio.ferracini\\IdeaProjects\\git\\treinamento\\src\\test\\features\\treinamento\\CampoDeTreinamento.feature"},
//        glue = {"step_definitions"},
//        dryRun = false)
//https://automationissues.wordpress.com/2017/09/29/cucumber-extent-reporting/

@CucumberOptions(
        //tags = "@182" ,
        format = {"pretty", "json:target/json/output.json"},
        features = {"C:\\Users\\laercio.ferracini\\IdeaProjects\\git\\treinamento\\src\\test\\features\\outgoing\\GestaoBins.feature"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/output/report.html"},
        //glue = {"step_definitions"},
        dryRun = false
        )

public class RunFeaturesTest {

    @BeforeClass
    public static void antes() throws UnsupportedEncodingException {
        ExtentReports reports = new ExtentReports();
        reports.setGherkinDialect("pt");
    }

    @AfterClass
    public static void teardown() {


        Reporter.loadXMLConfig(new File("configs/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Windows");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }

}

//@CucumberOptions(
//        plugin = {"pretty", "html:target/cukes", "json:target/cukes/report.json", "junit:target/cukes/junit.xml"},
//        features = "src/test/features/intercambio.feature",
//        dryRun = true
//)