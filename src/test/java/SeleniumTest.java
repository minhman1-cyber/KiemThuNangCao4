import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest {
    WebDriver driver;
    String searchContent = "áo";

    @BeforeClass
    public void beforeClass() {
        // Khởi tạo ChromeDriver (WebDriverManager có thể tự setup nếu bạn đã cài)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void yc1() throws InterruptedException {
        driver.get("https://vitimex.com.vn/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@data-id = 'js-click-search']")).click();
        driver.findElement(By.id("inputSearchAuto")).sendKeys(searchContent);
        driver.findElement(By.id("search-header-btn")).click();
        Thread.sleep(4000);
    }

    @Test(dependsOnMethods = {"yc1"})
    public void yc2() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        driver.get("https://vitimex.com.vn/search?q=" + searchContent);
        Thread.sleep(3000);
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@href='/products/atr5029']")
        ));
        actions.moveToElement(product).perform();
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-variantid = '1157243028' and @data-handle='/products/atr5029']")
        ));
        button.click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
