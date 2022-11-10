package arturo.amr;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    AndroidDriver driver;
    AppiumDriverLocalService service;

    @BeforeClass
    public void configuration() throws MalformedURLException {
        /*this.service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();*/
        UiAutomator2Options options = new UiAutomator2Options();
//        options.setDeviceName("Nexus2");
//        options.setUdid("emulator-5554");
        options.setDeviceName("420088406aca34b1");
        options.setApp(getAppPath());
        options.setChromedriverExecutable("D:\\AITBOL\\Appium\\src\\test\\java\\resources\\chromedriver.exe");
        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public String getAppPath(){
        String path = System.getProperty("user.dir");
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("win"))
//            path =  path + "\\src\\test\\java\\resources\\ApiDemos-debug.apk";
            path =  path + "\\src\\test\\java\\resources\\General-Store.apk";
        else if (os.contains("nix") || os.contains("nux") || os.contains("aix"))
            path =  path + "/src/test/java/resources/ApiDemos-debug.apk";
        else if (os.contains("mac"))
            path =  path + "/src/test/java/resources/ApiDemos-debug.apk";
        return path;
    }

    public void longPress(WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)element).getId(),
                "duration", 2000));
    }

    public void scrollWebElement(WebElement element){
//        WebElement webView = driver.findElement(AppiumBy.accessibilityId("WebView"));
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "percent", 3.0
        ));
    }

    public void scrollToEnd(){
        boolean canScrollMore;
        do{
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        } while(canScrollMore);
    }

    public void scrollABit(){
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", "down",
                "percent", 3.0
        ));
    }

    public void scrollUsingGoogleEngine(String text){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))"));
    }

    public void swipeAction(WebElement element, String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    public double convertPriceToDouble(String amount){
        return Double.parseDouble(amount.substring(1));
    }

    @AfterClass
    public void tearDown(){
        this.driver.quit();
//        service.stop();
    }
}
