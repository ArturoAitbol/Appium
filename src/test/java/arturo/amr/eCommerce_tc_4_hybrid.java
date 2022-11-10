package arturo.amr;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class eCommerce_tc_4_hybrid extends BaseTest {
    @Test
    public void fillForm() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Arturo");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scrollUsingGoogleEngine("Argentina");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        scrollABit();
//        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
        driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int productListSize = productPrices.size();
        double total = 0;
        for (int i=0; i<productListSize; i++){
            String productPrice = productPrices.get(i).getText();
            double price = Double.parseDouble(productPrice.substring(1));
            total = total + price;
        }
        System.out.println(total);
        String displayedTotal = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        double displayedTotalDouble = convertPriceToDouble(displayedTotal);
        Assert.assertEquals(total, displayedTotalDouble);

        WebElement conditionButton = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPress(conditionButton);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(6000);
        Set<String> contextNames = driver.getContextHandles();
        for (String context:contextNames) {
            System.out.println(context);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Tekvizion");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
    }
}
