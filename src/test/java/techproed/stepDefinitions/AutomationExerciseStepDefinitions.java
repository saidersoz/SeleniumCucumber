package techproed.stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import techproed.pages.AutomationExercisePage;

import static techproed.utilities.ReusableMethods.bekle;


public class AutomationExerciseStepDefinitions {
    AutomationExercisePage automationExercisePage = new AutomationExercisePage();

    @Given("ana sayfanin basariyla goruntulendigini dogrular")
    public void ana_sayfanin_basariyla_goruntulendigini_dogrular() {
        Assert.assertTrue(automationExercisePage.AutomationExerciseLogo.isDisplayed());
    }

    @Given("Products butonuna tiklar")
    public void products_butonuna_tiklar() {
        automationExercisePage.productsButton.click();
    }

    @Given("ALL PRODUCT sayfasina yonlendirildigini dogrular")
    public void all_product_sayfasina_yonlendirildigini_dogrular() {
        String expectedText = "All Products";
        String actualText = automationExercisePage.allProductText.getText();
        Assert.assertEquals(actualText, expectedText);
        Assert.assertTrue(automationExercisePage.allProductText.isDisplayed());
    }

    @Given("arama butonuna urun adini girer ve ara butonuna tiklar")
    public void arama_butonuna_urun_adini_girer_ve_ara_butonuna_tiklar() {
        automationExercisePage.searchProductBox.sendKeys("Java");
        bekle(1);
        automationExercisePage.searchProductBoxButton.click();
    }

    @Given("SEARCHED PRODUCTS yazisinin goruldugunu dogrular")
    public void searched_products_yazisinin_goruldugunu_dogrular() {
        assert automationExercisePage.searchedProducts.isDisplayed();
    }

    @Given("arama ile ilgili tum urunlerin gorunur oldugunu dogrulayın")
    public void arama_ile_ilgili_tum_urunlerin_gorunur_oldugunu_dogrulayın() {
        Assert.assertTrue(automationExercisePage.urunler.isDisplayed());
    }


}
