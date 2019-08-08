package Zadanie1;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/home/robert/Pulpit/aaa/ProjektKoncowyRobert/src/test/java/Zadanie1/CodersGuru.feature",
        plugin = {"pretty", "html:out"})

public class CodersGuruTest {
}
