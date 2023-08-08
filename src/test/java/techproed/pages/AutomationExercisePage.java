package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class AutomationExercisePage {

    public AutomationExercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Automation Exercise Logosu
    @FindBy(xpath = "//div[@class='shop-menu pull-right']]")
    public WebElement AutomationExerciseLogo;

    //Products button
    @FindBy(xpath = "//*[text()=' Products']")
    public WebElement productsButton;

    //ALL PRODUCT Text
    @FindBy(xpath = "//*[text()='All Products']")
    public WebElement allProductText;

    //Search Product Box
    @FindBy(id = "search_product")
    public WebElement searchProductBox;

    //Search Product Box Button
    @FindBy(id = "submit_search")
    public WebElement searchProductBoxButton;

    //SEARCHED PRODUCTS text
    @FindBy(xpath = "//*[text()='Searched Products']")
    public WebElement searchedProducts;

    //urunler
    @FindBy (xpath = "//div[@class='productinfo text-center']")
    public WebElement urunler;
}
