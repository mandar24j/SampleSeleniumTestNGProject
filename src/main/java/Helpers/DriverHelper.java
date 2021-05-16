package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverHelper {
    protected int defaultWaitTime = 25;
    WebDriver driver = LocalDriverManager.getDriver();


    public void click(String xpath) {
        waitForElement(xpath);
        driver.findElement(By.xpath(xpath)).click();
    }

    private void waitForElement(String xpath) {
        (new WebDriverWait(driver, defaultWaitTime))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        (new WebDriverWait(driver, defaultWaitTime))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}