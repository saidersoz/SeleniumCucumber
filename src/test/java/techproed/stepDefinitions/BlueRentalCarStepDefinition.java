package techproed.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import techproed.pages.BlueRentalCarPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class BlueRentalCarStepDefinition {

    BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();

    @Given("kullanici blue rental car sayfasini gider")
    public void kullanici_blue_rental_car_sayfasini_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));

    }

    @When("login olur")
    public void login_olur(DataTable dataTable) throws InterruptedException {

        blueRentalCarPage.loginButton.click();
        blueRentalCarPage.emailBox.sendKeys(dataTable.row(1).get(0));//2. satırın ilk ve ikinci sütunlarını kullamıyoruz
        blueRentalCarPage.passwordBox.sendKeys(dataTable.row(1).get(1));
        blueRentalCarPage.loginConfirm.click();

        //Çıkış yapıp diğer data ile giriş yapacağız
        blueRentalCarPage.userDropDown.click();
        blueRentalCarPage.logOut.click();
        blueRentalCarPage.OK.click();

        //giriş işlemlerini tekrarlıyorum
        blueRentalCarPage.loginButton.click();
        blueRentalCarPage.emailBox.sendKeys(dataTable.row(2).get(0));//3. satırın ilk ve ikinci sütunlarını kullamıyoruz
        blueRentalCarPage.passwordBox.sendKeys(dataTable.row(2).get(1));
        blueRentalCarPage.loginConfirm.click();
        Thread.sleep(3000);


    }

    @When("login olur map")
    public void loginOlurMap(DataTable dataTable) throws InterruptedException {

        //Datayı birinci satırı Key olarak kabul eden List<Map> data türüne çavirdik.
        List<Map<String, String>> bilgiler = dataTable.asMaps();//[{emailadress=jack@gmail.com, password=12345}, {emailadress=sam.walker@bluerentalcars.com, password=c!fas_art}]
        System.out.println("bilgiler = " + bilgiler);

        for (Map<String, String> w : bilgiler) {//Her bir Map'i alarak "Key değerlerini kullanarak "Value" değerlerini çağırdık ve testimizde kullandık.

            blueRentalCarPage.loginButton.click();
            Thread.sleep(1000);
            blueRentalCarPage.emailBox.sendKeys(w.get("emailadress"));
            Thread.sleep(1000);
            blueRentalCarPage.passwordBox.sendKeys(w.get("password"));
            Thread.sleep(1000);
            blueRentalCarPage.loginConfirm.click();
            Thread.sleep(1000);

            //Çıkış yapıp diğer data ile giriş yapacağız
            blueRentalCarPage.userDropDown.click();
            Thread.sleep(1000);
            blueRentalCarPage.logOut.click();
            Thread.sleep(1000);
            blueRentalCarPage.OK.click();
            Thread.sleep(1000);

        }
    }

    @Then("Verilen_kullanicilar_ile_login_olunur")
    public void verilen_kullanicilar_ile_login_olunur(DataTable data) {
        blueRentalCarPage = new BlueRentalCarPage();
        System.out.println("data.asMaps() = " + data.asMaps()); //Map'lerden oluşan bir list oluşturur
        //FReature file'daki oluşturulmuş tabloyu map olarak listeler.
        //Başlığı key olarak alır altında ki verileri value olarak alır
        for (Map<String, String> w : data.asMaps()) {
            blueRentalCarPage.loginButton.click();
            blueRentalCarPage.emailBox.sendKeys(w.get("emailAdress") + Keys.TAB + w.get("password") + Keys.ENTER);
            ReusableMethods.bekle(2);
            blueRentalCarPage.userDropDown.click();
            ReusableMethods.bekle(2);
            blueRentalCarPage.logOut.click();
            ReusableMethods.bekle(2);
            blueRentalCarPage.OK.click();
        }


    }

    @And("kullanici_exceldeki_{string}_sayfasindaki_kullanici_bilgileri_ile_login_olur")
    public void kullanici_exceldeki__sayfasindaki_kullanici_bilgileri_ile_login_olur(String sayfaAdi) {
        blueRentalCarPage = new BlueRentalCarPage();
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/mysmoketestdata.xlsx", sayfaAdi);
        for (int i = 1; i <= excelUtils.rowCount(); i++) {
            String email = excelUtils.getCellData(i, 0);
            String password = excelUtils.getCellData(i, 1);
            blueRentalCarPage.loginButton.click();
            ReusableMethods.bekle(2);
            blueRentalCarPage.emailBox.sendKeys(email + Keys.TAB, password + Keys.ENTER);
            ReusableMethods.bekle(2);
            blueRentalCarPage.userDropDown.click();
            ReusableMethods.bekle(1);
            blueRentalCarPage.profile.click();
            ReusableMethods.bekle(1);
            Assert.assertEquals(blueRentalCarPage.verifyEmail.getText(), email);
            Driver.getDriver().navigate().back();
            ReusableMethods.bekle(2);
            blueRentalCarPage.userDropDown.click();
            ReusableMethods.bekle(1);
            blueRentalCarPage.logOut.click();
            ReusableMethods.bekle(1);
            blueRentalCarPage.OK.click();
        }

    }

    @Given("kullanici_blueRentACarUrl_sayfasina_gider_exceldeki_verilerle_login_olur")
    public void kullanici_bluerentacarurl_sayfasina_gider_exceldeki_verilerle_login_olur(String url, String sayfaAdi) {
        System.out.println("BlueRentalPage Sayfasına Gidildi Excelde ki Veriler ile Login Olundu");
       // blueRentalCarPage = new BlueRentalCarPage();
       // ExcelUtils excelUtils = new ExcelUtils("src/test/resources/mysmoketestdata.xlsx", sayfaAdi);
       // Driver.getDriver().get(ConfigReader.getProperty(url));
       // for (int i = 1; i <= excelUtils.rowCount(); i++) {
       //     String email = excelUtils.getCellData(i, 0);
       //     String password = excelUtils.getCellData(i, 1);
       //     blueRentalCarPage.emailBox.sendKeys(email + Keys.TAB, password + Keys.ENTER);
       //     ReusableMethods.bekle(1);
       // }
    }
}
