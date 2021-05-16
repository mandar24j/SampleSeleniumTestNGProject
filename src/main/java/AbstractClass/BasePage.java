package AbstractClass;

import Helpers.DriverHelper;
import Helpers.LocalDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public WebDriver driver = LocalDriverManager.getDriver();
    public WebDriverWait wait = new WebDriverWait(driver, 10);
    protected DriverHelper dh = new DriverHelper();

}
