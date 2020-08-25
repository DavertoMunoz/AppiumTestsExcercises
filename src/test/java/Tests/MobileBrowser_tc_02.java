package Tests;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

/***
 Abrir Browser, ir a mercado Libre, realizar una b[usqueda y verificar el resultado
 OPEN BROWSER AND NAVIGATE, CHROMEDRIVER VERSION FOR CHROME 74
 ***/

public class MobileBrowser_tc_02 extends Base {

//    @FindBy(how = How.LINK_TEXT, using = "Our Work")
//    private MobileElement ourWorkLink;

    @Test
    public void openMercadoLibreAndSearch() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Opens device browser and specified page
        driver.get("http://mercadolibre.com/");
        // Select Mexico as the country of preference
        driver.findElementById("MX").click();
        // Click on Zip code to add the ours
        driver.findElementByCssSelector(".nav-header-cp-anchor").click();
        // Send  xip code to locator input field
        driver.findElementByName("zipcode").sendKeys("83200");
        // Confirm the zip code typed
        driver.findElementByXPath("//span[contains(text(),'Usar')]").click();
        // Make a search
        driver.findElementByClassName("nav-search-input").sendKeys("Tenis Puma");
        // Hit enter after sending keys
        driver.findElementByClassName("nav-search-input").sendKeys(Keys.RETURN);
        // Retrieve text from the locator
        String searchPuma = driver.findElementByXPath("//h2[contains(text(),'Tenis Puma Hombre Negro Trainer Evo 36402801')]").getText();
        // Assert our search with the result
        assertTrue(searchPuma.contains("Puma"));


        // Scroll to element "Mi cuenta"
//        WebElement element = driver.findElement(By.xpath("//a[.='Mi cuenta']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);


    }
}