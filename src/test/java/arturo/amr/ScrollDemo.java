package arturo.amr;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class ScrollDemo extends BaseTest{
    @Test
    public void ScrollDemoTest() throws IOException, InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
        scrollUsingGoogleEngine("WebView");
        scrollToEnd();
    }
}
