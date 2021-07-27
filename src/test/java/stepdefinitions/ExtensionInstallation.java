package stepdefinitions;

import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.A_Home_Page;
import utilities.ReusableMethods;
import utilities.WriteToText;

import java.io.File;
import java.util.Set;

public class ExtensionInstallation {

    @When("User open a browser and install the GoFullPage Extension.")
    public void userOpenABrowserAndInstallTheGoFullPageExtension() {

        A_Home_Page a_Home_Page=new A_Home_Page();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");


        //Add my downloaded crx file path below.
        options.addExtensions(new File("goFullPage.crx"));


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);


        options.merge(capabilities);


        //Setting up ChromeDriver with WebDriver Manager.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);


        driver.get("chrome-extension://fdpohaocaechififmbbbbbknoalclacl/html/popup.html");


        String firstHandle=driver.getWindowHandle();
        Set<String> handles=driver.getWindowHandles();

        for (String w:handles) {
            if (!w.equals(firstHandle)) {
                driver.close();
                driver.switchTo().window(w);
            }
        }


        String fileName = "extensionPage";
        String url = driver.getCurrentUrl().toString();
        WriteToText.write(fileName, "1. EXTENSION PAGE URL : \n" + url);


        String pageTitle = driver.getTitle();
        WriteToText.write(fileName, "2. EXTENSION HOMEPAGE MESSAGE : \n" + pageTitle);
        ReusableMethods.wait(3);
    }
}


