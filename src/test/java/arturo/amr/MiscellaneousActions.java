package arturo.amr;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MiscellaneousActions extends BaseTest{
    @Test
    public void Miscellaneous() throws MalformedURLException, InterruptedException {
        // adb shell dumpsys window | find "mCurrentFocus"
        Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
        driver.startActivity(activity);
//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        //Rotation
        DeviceRotation landScapeMode = new DeviceRotation(0, 0, 90);
        driver.rotate(landScapeMode);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String actualTittle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(actualTittle, "WiFi settings");
        //Set and Get clipboard
        driver.setClipboardText("Arturo");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        //Insert new line using buttons
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
