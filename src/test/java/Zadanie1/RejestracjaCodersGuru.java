package Zadanie1;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class RejestracjaCodersGuru {

    WebDriver driver;

    @Given("^Otwarta przegladarka na stronie https://tester\\.codersguru\\.pl/$")
    public void otwartaPrzegladarkaNaStronieHttpsTesterCodersguruPl() {

        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tester.codersguru.pl/");
    }

    @When("^Przyciskam przycisk załuz konto$")
    public void przyciskamPrzyciskZałuzKonto() {

        //registerbutton1 = przycisk "Załóż konto"
        WebElement registerbutton1 = driver.findElement(By.xpath("/html/body/section[3]/div/form/input[2]"));
        registerbutton1.click();
    }

    @Then("^Otwiera sie okno z formularzem rejestracji$")
    public void otwieraSieOknoZFormularzemRejestracji() {

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @When("^Rejestruje uzytkownika danymi \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void rejestrujeUzytkownikaDanymi(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) throws Throwable {

        //arg0 = E-mail
        //czyści pole i podaje adres E-mail
        driver.findElement(By.id("fos_user_registration_form_email")).clear();
        driver.findElement(By.id("fos_user_registration_form_email")).sendKeys(arg0);
        //arg1 = Imię
        //czyści pole i podaje Imię
        driver.findElement(By.id("fos_user_registration_form_name")).clear();
        driver.findElement(By.id("fos_user_registration_form_name")).sendKeys(arg1);
        //arg2 = Nazwisko
        //czyści pole i podaje Nazwisko
        driver.findElement(By.id("fos_user_registration_form_lastname")).clear();
        driver.findElement(By.id("fos_user_registration_form_lastname")).sendKeys(arg2);
        //arg3 = Hasło
        //czyści pole i podaje hasło
        driver.findElement(By.id("fos_user_registration_form_plainPassword_first")).clear();
        driver.findElement(By.id("fos_user_registration_form_plainPassword_first")).sendKeys(arg3);
        //arg4 = Powtórz Hasło
        //czyści pole i podaje hasło
        driver.findElement(By.id("fos_user_registration_form_plainPassword_second")).clear();
        driver.findElement(By.id("fos_user_registration_form_plainPassword_second")).sendKeys(arg4);
        //arg5 = Miasto
        //czyści pole i wpisuje nazwe Miasta
        driver.findElement(By.id("form_city")).clear();
        driver.findElement(By.id("form_city")).sendKeys(arg5);
        //arg6 = Kod Pocztowy
        //czyści pole i wpisuje kod pocztowy
        driver.findElement(By.id("form_postal_code")).clear();
        driver.findElement(By.id("form_postal_code")).sendKeys(arg6);
        //arg7 = Ulica
        //czyści pole i wpisuje nazwe ulicy
        driver.findElement(By.id("form_street")).clear();
        driver.findElement(By.id("form_street")).sendKeys(arg7);
        //arg8 = Numer domu/lokalu
        //czyści pole i wpisuje numer lokalu
        driver.findElement(By.id("form_number")).clear();
        driver.findElement(By.id("form_number")).sendKeys(arg8);
    }

    @And("^Naciskam przycisk akceptacji regulaminu$")
    public void naciskamPrzyciskAkceptacjiRegulaminu() {

        //checkbox regulaminu strony
        WebElement checkbox = driver.findElement(By.xpath("/html/body/div/div/div/form/div[12]/input"));
        checkbox.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @And("^Naciskam przycisk rejestracji$")
    public void naciskamPrzyciskRejestracji() {

        //registerbutton2 = przycisk "Zarejestruj"
        WebElement registerbutton2 = driver.findElement(By.id("register-submit-btn"));
        registerbutton2.click();

    }

    @Then("^Uzytkownik zostaje zarejestrowany na stronie$")
    public void uzytkownikZostajeZarejestrowanyNaStronie() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @And("^Użytkownik zostaje przeniesiony na strone glowna CodersGuru$")
    public void użytkownikZostajePrzeniesionyNaStroneGlownaCodersGuru() {

        //Przeglądarka znajduje imię użytkownika na stronie
        WebElement userName = driver.findElement(By.id("user-name"));
        String UserName = userName.getText();
        //Sprawdzanie czy na Stronie pokazuje się imie użytkownika
        Assert.assertNotNull(UserName);

        System.out.println(UserName);

        //Przeglądarka zostaje zamknięta
        driver.close();

    }

}
