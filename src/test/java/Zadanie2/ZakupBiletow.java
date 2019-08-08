package Zadanie2;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ZakupBiletow {

    WebDriver driver;


    @Given("^Przegladarka otwarta na stronie https://www\\.phptravels\\.net/$")
    public void przegladarkaOtwartaNaStronieHttpsWwwPhptravelsNet() {
        System.setProperty("webdriver.gecko.driver",
                "/home/robert/Pulpit/aaa/ProjektKoncowyRobert/src/main/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/");
    }

    @When("^Przyciskam przycisk 'FLIGHTS' widoczny na stronie$")
    public void przyciskamPrzyciskFLIGHTSWidocznyNaStronie() {
        WebElement flightbutton = driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/ul/li[2]/a"));
        flightbutton.click();
    }

    @When("^Wybieram opcje 'Round Trip'$")
    public void wybieramOpcjeRoundTrip() {
        WebElement roundTrip = driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div[1]/div[3]/form/div[9]/div[2]/div/div/ins"));
        roundTrip.click();

    }

    @When("^Naciskam pierwsze pole 'Enter Location'$")
    public void naciskamPierwszePoleEnterLocation() {
        WebElement flyFrom = driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div[1]/div[3]/form/div[1]/div/div[2]/a"));
        flyFrom.click();
    }

    @And("^Wpisuje WAW oraz wybieram lotnisko z listy wyboru$")
    public void wpisujeWAWOrazWybieramLotniskoZListyWyboru() {
        WebElement flyFrom = driver.findElement(By.xpath("/html/body/div[18]/div/input"));
        flyFrom.sendKeys("WAW");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement waw = driver.findElement((By.xpath("/html/body/div[18]/ul/li[1]/div")));
        waw.click();
    }

    @When("^Naciskam drugie pole 'Enter Location'$")
    public void naciskamDrugiePoleEnterLocation() {
        WebElement flyTo = driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div[1]/div[3]/form/div[2]/div/div[2]/a/span[1]"));
        flyTo.click();
    }

    @And("^Wpisuje JFK oraz wybieram lotnisko z listy wyboru$")
    public void wpisujeJFKOrazWybieramLotniskoZListyWyboru() {
        WebElement flyTo = driver.findElement(By.xpath("/html/body/div[19]/div/input"));
        flyTo.sendKeys("JFK");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement jfk = driver.findElement((By.xpath("/html/body/div[19]/ul/li/div")));
        jfk.click();
    }

    @When("^Wpisuje date wylotu oraz przylotu w pola do tego wyznaczone$")
    public void wpisujeDateWylotuOrazPrzylotuWPolaDoTegoWyznaczone() {
        WebElement departureDate = driver.findElement(By.id("departure"));
        departureDate.click();
        departureDate.clear();
        departureDate.sendKeys("2019-09-10");
        WebElement arrivalDate = driver.findElement(By.id("arrival"));
        arrivalDate.click();
        arrivalDate.click();
        arrivalDate.sendKeys("2019-09-17");
    }

    @And("^Wybieram ilość pasażerów z okna wyboru$")
    public void wybieramIlośćPasażerówZOknaWyboru() {
        WebElement persons = driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div[1]/div[3]/form/div[5]/div/input"));
        persons.click();
        persons.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div[1]/div[3]/form/div[7]/div/div/div[2]/section/div/div[1]/div[1]/select/option[1]")).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        persons.findElement(By.xpath("//*[@id=\"sumManualPassenger\"]")).click();
    }

    @And("^Naciskam przycisk 'Search'$")
    public void naciskamPrzyciskSearch() {
        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div[1]/div[3]/form/div[6]/button"));
        searchButton.click();

    }

    @Then("^Czekam aż załaduje się przycisk 'BOOK NOW' oraz naciskam go$")
    public void czekamAżZaładujeSięPrzyciskBOOKNOWOrazNaciskamGo() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        String xpathGuzika = "/html/body/div[5]/div[4]/div[2]/div[1]/div[1]/div[3]/form/div/button";
        WebElement guzikOczekiwany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathGuzika)));
        guzikOczekiwany.click();
        //Sprawdzam czy na Stronie pojawił się napis "GUEST BOOKING"
        String guestbtn = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/a")).getText();
        Assert.assertTrue(guestbtn.contains("GUEST BOOKING"));

    }

    @When("^Naciskam przycisk 'Guest Booking'$")
    public void naciskamPrzyciskGuestBooking() {
        WebElement guestBooking = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/a"));
        guestBooking.click();
    }

    @And("^Wypełniam pola danymi \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void wypełniamPolaDanymi(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) {
        //arg0 = Name
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(arg0);
        //arg1 = Surname
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys(arg1);
        //arg2 = Email
        driver.findElement(By.name("email[]")).clear();
        driver.findElement(By.name("email[]")).sendKeys(arg2);
        //arg3 = Phone
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).sendKeys(arg3);
        //arg4 = Birthday
        driver.findElement(By.id("birthday")).clear();
        driver.findElement(By.id("birthday")).sendKeys(arg4);
        //arg5 = Card Number1
        driver.findElement(By.id("cardno")).clear();
        driver.findElement(By.id("cardno")).sendKeys(arg5);
        //arg6 = Expiration
        driver.findElement(By.id("expiration")).clear();
       driver.findElement(By.id("expiration")).sendKeys(arg6);

    }

    @And("^Wybieram 'POLAND' w polu Nationality$")
    public void wybieramPOLANDWPoluNationality() {
//        WebElement nationality = driver.findElement(By.xpath("/html/body/div[11]/div/input"));
//        nationality.click();
//        nationality.sendKeys("POLAND");
//        WebElement poland = driver.findElement(By.className("select2-result-label"));
//        poland.click();

    }

    @And("^W polu 'Card Type' wybieram 'Visa'$")
    public void wPoluCardTypeWybieramVisa() {
        WebElement cardType = driver.findElement(By.id("cardtype"));
        cardType.click();
        WebElement visa = driver.findElement(By.id("/html/body/div[5]/form/div/div[2]/div[2]/section/div/div[1]/div/select/option[5]"));
        visa.click();

    }

    @And("^Wpisuje dane karty płatniczej danymi \"([^\"]*)\" \"([^\"]*)\"$")
    public void wpisujeDaneKartyPłatniczejDanymi(String arg0, String arg1) {
        //arg0 = CardNumber
        WebElement cardNumber = driver.findElement(By.id("card-number"));
        cardNumber.clear();
        cardNumber.sendKeys(arg0);
        //arg1 = CardCVV
        WebElement cardCVV = driver.findElement(By.id("cvv"));
        cardCVV.clear();
        cardCVV.sendKeys(arg1);


    }

    @And("^W polu 'Expiration Date' wyberam 'Sep(\\d+)' oraz '(\\d+)'$")
    public void wPoluExpirationDateWyberamSepOraz(int arg0, int arg1) {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        // Wybieram z listy September
        WebElement expiryMonth = driver.findElement(By.id("expiry-month"));
        expiryMonth.click();
        expiryMonth.findElement(By.xpath("/html/body/div[5]/form/div/div[2]/div[2]/section/div/div[3]/div/select/option[10]")).click();
        //Wybieram z listy rok 2023
        WebElement expiryYear = driver.findElement(By.id("expiry-year"));
        expiryYear.click();
        expiryYear.findElement(By.xpath("/html/body/div[5]/form/div/div[2]/div[2]/section/div/div[4]/div/select/option[6]")).click();
    }

    @Then("^Naciskam przycisk 'COMPLETE BOOKING'$")
    public void naciskamPrzyciskCOMPLETEBOOKING() {
        WebElement confirmButton = driver.findElement(By.xpath("//*[@id=\"confirmBooking\"]"));
        confirmButton.click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

        confirmButton.getScreenshotAs(OutputType.FILE);




        //  driver.close();
    }
}
