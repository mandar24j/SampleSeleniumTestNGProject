package BaseTest;

import Helpers.LocalDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    public static WebDriver driver;

    @BeforeMethod
    @Parameters({"app", "browser"})
    public void setup(@Optional String app, @Optional String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            LocalDriverManager.setWebDriver(driver);
        } else {
            Assert.fail("Provide Browser Name");
        }
        driver.get(app);
    }

    @AfterMethod
    public void close() {
        LocalDriverManager.getDriver().quit();
    }


}
