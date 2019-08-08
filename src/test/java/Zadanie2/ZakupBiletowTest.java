package Zadanie2;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/home/robert/Pulpit/aaa/ProjektKoncowyRobert/src/test/java/Zadanie2/phptravelsStory.feature",
        plugin = {"pretty", "html:out"})

public class ZakupBiletowTest {
}