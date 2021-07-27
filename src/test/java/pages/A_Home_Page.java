package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class A_Home_Page {

    public A_Home_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //=======Login Page======//
    @FindBy(xpath = "//span[.='Hello, Sign in']")
    public WebElement signInMenu;

    @FindBy(className = "nav-action-inner")
    public WebElement signInButton;

    @FindBy(id = "ap_email")
    public WebElement emailTextBox;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "ap_password")
    public WebElement passwordTextBox;

    @FindBy(id = "signInSubmit")
    public WebElement LastSingInButton;


//=======Search Term Page======//
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchTextBox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchButton;

    @FindBy(id = "productTitle")
    public WebElement productTitle;


    //=======Add to Cart======//
    @FindBy(id = "add-to-cart-button")
    public WebElement addToCart;

    @FindBy(id = "hlb-view-cart-announce")
    public WebElement showCart;

    @FindBy(className = "a-truncate-cut")
    public WebElement productName;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
    public WebElement productValue;

    @FindBy(id = "nav-cart-count")
    public WebElement productQuantity;

    @FindBy(id = "sc-subtotal-label-activecart")
    public WebElement totalProduct;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]")
    public WebElement totalValueOfProduct;


    //=======Checkout Cart======//
    @FindBy(id = "hlb-ptc-btn-native")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//a[@data-action='page-spinner-show']")
    public WebElement adressButton;

    @FindBy(xpath = "//*[@id='shippingOptionFormId']/div[2]/div/div[1]/div/div/ul/li/div/strong")
    public WebElement productNameCheckout;

    @FindBy(xpath = "//span[@class='a-color-price']")
    public WebElement priceCheckout;

    @FindBy(xpath = "//span[@class='a-color-secondary']")
    public WebElement totalProductonCheckout;


    //=======extension installation======//
    @FindBy(xpath = "//h1")
    public WebElement welcomeMessage;



}
