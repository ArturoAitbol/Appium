package arturo.amr;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class eCommerce_tc_1 extends BaseTest {
    @Test
    public void fillForm() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Arturo");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
//        driver.findElement(By.id("android:id/text1")).click();
        scrollUsingGoogleEngine("Argentina");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        scrollUsingGoogleEngine("Jordan 6 Rings");
//        driver.findElement(By.xpath("//android.widget.TextView[@text='Jordan 6 Rings']/following-sibling::android.widget.LinearLayout/child::*[@text='ADD TO CART']")).click();

        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for (int i=0; i<productCount; i++){
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equals("Jordan 6 Rings")){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));

        String checkoutPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(checkoutPageProduct, "Jordan 6 Rings");
        Thread.sleep(2000);
    }
}
