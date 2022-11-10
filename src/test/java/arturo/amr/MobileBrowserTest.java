package arturo.amr;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {
    @Test
    public void test() throws InterruptedException {
/*        driver.get("http://google.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Tekvizion");
        Thread.sleep(2000);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);*/

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        driver.findElement(By.cssSelector("a[routerlink='/products']")).click();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
        Thread.sleep(2000);
        String actualName = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
        Assert.assertEquals(actualName, "Devops");
    }
}
