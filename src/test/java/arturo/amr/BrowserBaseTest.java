package arturo.amr;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserBaseTest {
    AndroidDriver driver;
    AppiumDriverLocalService service;

    @BeforeClass
    public void configuration() throws MalformedURLException {
        /*this.service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();*/
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("420088406aca34b1");
        options.setChromedriverExecutable("D:\\AITBOL\\Appium\\src\\test\\java\\resources\\95\\chromedriver.exe");
        options.setCapability("browserName", "Chrome");
        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
