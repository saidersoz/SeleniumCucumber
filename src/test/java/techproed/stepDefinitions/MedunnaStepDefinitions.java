package techproed.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import techproed.pages.MedunnaPage;
import techproed.utilities.Driver;

import static org.junit.Assert.assertTrue;

public class MedunnaStepDefinitions {

    MedunnaPage medunnaPage = new MedunnaPage();

    @Given("{string} adresine git")
    public void adresine_git(String url) {

        Driver.getDriver().get(url);

    }

    @When("kullanici simgesini tikla")
    public void kullanici_simgesini_tikla() throws InterruptedException {
        Thread.sleep(500);
        medunnaPage.kullaniciSimgesi.click();

    }

    @When("sign in secenegini tikla")
    public void sign_in_secenegini_tikla() throws InterruptedException {
        Thread.sleep(500);
        medunnaPage.signInSecenegi.click();

    }

    @When("username kutusuna {string} gir")
    public void username_kutusuna_gir(String userName) throws InterruptedException {
        Thread.sleep(500);
        medunnaPage.usernameKutusu.sendKeys(userName);

    }

    @When("password kutusuna {string} gir")
    public void password_kutusuna_gir(String password) throws InterruptedException {
        Thread.sleep(500);
        medunnaPage.passwordKutusu.sendKeys(password);

    }

    @When("remember me radio butonuna tikla")
    public void remember_me_radio_butonuna_tikla() throws InterruptedException {
        Thread.sleep(500);
        medunnaPage.rememberMeRadioButton.click();

    }

    @When("sign in butonuna tikla")
    public void sign_in_butonuna_tikla() throws InterruptedException {
        Thread.sleep(500);
        medunnaPage.signInButton.click();

    }

    @When("items&titles sekmesini tikla")
    public void items_titles_sekmesini_tikla() throws InterruptedException {
        Thread.sleep(500);
        medunnaPage.itemsTitles.click();

    }

    @When("room secenegini tikla")
    public void room_secenegini_tikla() throws InterruptedException {
        Thread.sleep(500);
        medunnaPage.roomSecenegi.click();

    }

    @When("create a new room butonunu tikla")
    public void create_a_new_room_butonunu_tikla() throws InterruptedException {
        Thread.sleep(500);
        medunnaPage.createANewRoom.click();

    }

    @When("room number kutusuna {string} gir")
    public void room_number_kutusuna_gir(String roomNumber) throws InterruptedException {
        Thread.sleep(500);
        medunnaPage.roomNumber.sendKeys(roomNumber);

    }

    @When("Room Type drop downdan {string} sec")
    public void room_type_drop_downdan_sec(String roomType) throws InterruptedException {

        Thread.sleep(500);
        Select select = new Select(medunnaPage.roomTypeDropDown);
        select.selectByVisibleText(roomType);


    }

    @When("price kutusuna {string} gir")
    public void price_kutusuna_gir(String price) throws InterruptedException {
        Thread.sleep(500);
        medunnaPage.roomPrice.sendKeys(price);

    }

    @When("description kutusuna {string} gir")
    public void description_kutusuna_gir(String description) throws InterruptedException {
        Thread.sleep(500);
        medunnaPage.description.sendKeys(description);

    }

    @When("save butonunu tikla")
    public void save_butonunu_tikla() throws InterruptedException {
        Thread.sleep(500);
        medunnaPage.saveButton.sendKeys(Keys.ENTER);

    }

    @Then("kaydedildi alertini dogrula")
    public void kaydedildi_alertini_dogrula() throws InterruptedException {
        Thread.sleep(500);
        assertTrue(medunnaPage.kaydedildiAlerti.getText().contains("A new Room is created"));

    }
}
