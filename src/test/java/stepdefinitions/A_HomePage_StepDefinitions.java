package stepdefinitions;

import com.sun.tools.jxc.ConfigReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.A_Home_Page;
import utilities.*;

import java.util.List;

public class A_HomePage_StepDefinitions {
    A_Home_Page a_Home_Page;
    String fileName = "products";



    @Given("User goes to the HomePage")
    public void user_goes_to_the_HomePage(){
        a_Home_Page = new A_Home_Page();
        Log4j.startLog("Test  is Starting");   // I used Log4j for taking logs.
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));   // Opening Amazon URL
        Log4j.info("Opening Page : " + ConfigurationReader.getProperty("url"));
    }


    @When("User login to the Account.")
    public void user_login_to_the_Account() {
        a_Home_Page = new A_Home_Page();


        ReusableMethods.hover(a_Home_Page.signInMenu);
        Log4j.info("Hower over to the Sign In Menu");


        ReusableMethods.wait(3);
        Log4j.info("Waiting for loading of page");


        a_Home_Page.signInButton.click();
        Log4j.info("Sign In button is Clicked");


        a_Home_Page.emailTextBox.sendKeys(ConfigurationReader.getProperty("email"));
        Log4j.info("Email Entered.");


        a_Home_Page.continueButton.click();
        Log4j.info("Continue button Clicked");


        a_Home_Page.passwordTextBox.clear();
        Log4j.info("Password TextBox cleared.");


        a_Home_Page.passwordTextBox.sendKeys(ConfigurationReader.getProperty("password"));
        Log4j.info("Password Entered.");


        a_Home_Page.LastSingInButton.click();
        Log4j.info("Sign In button is Clicked");

    }

    @Then("User User write search term {string} to the search textbox.")
    public void user_User_write_search_term_to_the_search_textbox(String searchTerm) {
        a_Home_Page = new A_Home_Page();


        a_Home_Page.searchTextBox.sendKeys(searchTerm);
        Log4j.info("Search term typed to the textbox");


        String termOfSearch = Driver.getDriver().findElement(By.id("twotabsearchtextbox")).getAttribute("value");
        Log4j.info("Search term taken from the search textbox.");


        WriteToText.write(fileName, "2b. SEARCH TERM : \n" + termOfSearch);
        Log4j.info("Product details taken from Website to products txt file.");


        ReusableMethods.waitForPageToLoad(3);
        Log4j.info("Waiting for loading of page");


        a_Home_Page.searchButton.click();
        Log4j.info("Clicked the search button");


        ReusableMethods.wait(2);
        Log4j.info("Waiting for loading of page");

    }

    @Then("User Select the first item that shows up.")
    public void user_Select_the_first_item_that_shows_up() {

        a_Home_Page = new A_Home_Page();


        List<WebElement> allProducts = Driver.getDriver().findElements(By.xpath("//div[@class='sg-col-4-of-12 s-result-item s-asin sg-col-4-of-16 AdHolder sg-col sg-col-4-of-20']"));
        allProducts.get(0).click();
        Log4j.info("Clicked the first product");


        WriteToText.write
                (fileName, "======================\n======================\n2c. ITEM NAME : \n"
                        + a_Home_Page.productTitle.getText());
        Log4j.info("Product Name added to the products txt file.");



    }

    @Then("User Clicks add to cart.")
    public void user_Clicks_add_to_cart() {

        a_Home_Page = new A_Home_Page();


        a_Home_Page.addToCart.click();
        Log4j.info("Product added to cart.");





    }

    @Then("User Select view Cart.")
    public void user_Select_view_Cart() {

        a_Home_Page = new A_Home_Page();


        a_Home_Page.showCart.click();
        Log4j.info("Cart button is clicked.");


        ReusableMethods.wait(4);
        Log4j.info("Waiting for loading of page");


        WriteToText.write(fileName,
                "======================\n======================\n2e. PRODUCT NAME ON CART : \n"
                        + a_Home_Page.productName.getText());
        Log4j.info("Product Name added to the products txt file.");


        WriteToText.write(fileName,
                "\nPRODUCT VALUE ON CART: \n"
                        + a_Home_Page.productValue.getText());
        Log4j.info("Product Value added to the products txt file.");


        WriteToText.write(fileName,
                "\nPRODUCT QUANTITY ON CART: \n"
                        + a_Home_Page.productQuantity.getText());
        Log4j.info("Product Quantity added to the products txt file.");


        WriteToText.write(fileName,
                "\nTOTAL VALUE OF PRODUCT ON CART : \n"
                        + a_Home_Page.totalValueOfProduct.getText());
        Log4j.info("Product Total Value added to the products txt file.");


        WriteToText.write(fileName,
                "\nTOTAL NUMBER OF PRODUCT ON CART : \n"
                        + a_Home_Page.totalProduct.getText());
        Log4j.info("Counts of Product added to the products txt file.");


        Driver.getDriver().navigate().back();
        Log4j.info("Navigate back to the homePage ");

    }

    @Then("User Select Checkout Cart.")
    public void user_Select_Checkout_Cart() {

        a_Home_Page = new A_Home_Page();


        a_Home_Page.proceedToCheckout.click();
        Log4j.info("Proceed to the checkout page");


        a_Home_Page.adressButton.click();
        Log4j.info("Adress entered to the system.");


        String fileName = "products";
        WriteToText.write(fileName,
                "======================\n======================\n2f. PRODUCT NAME ON CHECKOUT: \n"
                        + a_Home_Page.productNameCheckout.getText());
        Log4j.info("Product Value added to the products txt file.");


        WriteToText.write(fileName,
                "\nPRODUCT VALUE ON CHECKOUT : \n"
                        + a_Home_Page.priceCheckout.getText());
        Log4j.info("Product Value added to the products txt file.");


        WriteToText.write(fileName,
                "\nPRODUCT QUANTITY ON CHECKOUT: \n"
                        + a_Home_Page.totalProductonCheckout.getText());
        Log4j.info("Product Quantity added to the products txt file.");


        WriteToText.write(fileName,
                "\nTOTAL VALUE ON CHECKOUT : \n"
                        + a_Home_Page.priceCheckout.getText());
        Log4j.info("Product Value added to the products txt file.");


        Driver.closeDriver();
    }
}
