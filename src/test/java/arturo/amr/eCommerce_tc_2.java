package arturo.amr;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class eCommerce_tc_2 extends BaseTest {
    @Test
    public void errorToastForm() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//        String text = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getText();  //It also works
        String text = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//        System.out.println(text);
        Assert.assertEquals(text, "Please enter your name");
    }

}
