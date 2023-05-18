package techproed.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.Driver;

public class Hooks {

    /*
    Her bir Scenario'dan önce yada sonra çalışmasını istediğimiz metotları @Before ve @After kullanarak bu classın içerisine koyuyoruz.
    Burada daha çok raporlama için kodlar kullacağız.
     */
    @Before//import io.cucumber.java.Before; ==> import cucumber'dan alınmalı
    public void setUp() {
        System.out.println("Before Methodu");
    }

    @After
    public void tearDown(Scenario scenario) {

        final byte[] failedScreenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {//Eğer scenario fail olursa alınan ekran görüntüsü rapora eklenecek
            scenario.attach(failedScreenShot, "image/png", "faile_scnenaio" + scenario.getName());
            Driver.closeDriver();
        }
    }

}
