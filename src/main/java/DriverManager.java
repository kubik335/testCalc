import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alexandra Kolpakova on 28.07.2018.
 */
public class DriverManager {
    private static DriverManager instance;
    public static RemoteWebDriver webDriver;

    private DriverManager() {
        getWebDriver();
    }

    public static RemoteWebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public static void loadWebPage(String url) {
        webDriver = new ChromeDriver();
        webDriver.get(url);
    }

    public static void closeBrowser() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }

    /**
     * @param by
     * @param timeout
     */
    public void waitForElement(final By by, long timeout) {
        Wait<WebDriver> wait = new WebDriverWait(webDriver, timeout);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(by).isDisplayed();
            }
        });
    }

}
