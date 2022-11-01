package arturo.amr;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class LongPress extends BaseTest{
    @Test
    public void LongPressGesture() throws IOException, InterruptedException {
        takeScreenshot(this.driver);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        /*driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        longPress(element);
        String menuText = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(menuText, "Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
        Thread.sleep(2000);*/
    }

    public void takeScreenshot(AppiumDriver driver) throws IOException {
        String screenshotBase64 = driver.getScreenshotAs(OutputType.BASE64);
        String replaceBase64 = screenshotBase64.replaceAll("\n","");
        byte[] decodedImg = Base64.getDecoder()
                .decode(replaceBase64.getBytes(StandardCharsets.UTF_8));
        Path destinationFile = Paths.get(System.getProperty("user.dir"), "myImage.jpg");
        Files.write(destinationFile, decodedImg);
    }
}
