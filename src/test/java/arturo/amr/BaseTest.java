package arturo.amr;

import com.google.common.collect.ImmutableMap;
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
/*        this.service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Gustavo Saavedra\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();*/
//        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Nexus");
//        options.setDeviceName("420088406aca34b1");
//        options.setDeviceName("Pixel_3a_API_33_x86_64");
//        options.setApp("D:\\AITBOL\\Tekvizion\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void longPress(WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)element).getId(),
                "duration", 2000));
    }

    @AfterClass
    public void tearDown(){
        this.driver.quit();
//        service.stop();
    }
}
