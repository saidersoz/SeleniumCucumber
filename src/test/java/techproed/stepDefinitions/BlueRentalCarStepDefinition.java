package techproed.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import techproed.pages.BlueRentalCarPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.util.List;
import java.util.Map;

public class BlueRentalCarStepDefinition {

    BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();

    @Given("kullanici blue rental car sayfasina gider")
    public void kullanici_blue_rental_car_sayfasina_gider() {
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
}
