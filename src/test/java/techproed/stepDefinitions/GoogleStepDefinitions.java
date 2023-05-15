package techproed.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class GoogleStepDefinitions {
    GooglePage googlePage = new GooglePage();

    @Given("kullanici_Google_Anasayfaya_gider")
    public void kullanici_google_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("google_url"));
    }

    @When("kullanici Googleda {string} aratir")
    public void kullanici_googleda_aratir(String aranacakKelime) {
        googlePage.aramaKutusu.sendKeys(aranacakKelime + Keys.ENTER);
    }

    @Then("title'in {string} icerdigini dogrula")
    public void title_in_icerdigini_dogrula(String titleDegeri) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(titleDegeri));
    }

}
