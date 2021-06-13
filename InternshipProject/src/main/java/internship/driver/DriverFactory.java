package internship.driver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverFactory {

    private static final String DRIVER_NAME = "webdriver.chrome.driver";
    private static final String CHROME = "src/main/resources/driver/chromedriver.exe";

    public static WebDriver getDriver(final DriverOption driverOption){
        switch (driverOption){
            case CHROME:
                initChrome();
                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            case IE:
                return new InternetExplorerDriver();
            default:
                return new ChromeDriver();
        }
    }

    private static void initChrome(){
        System.setProperty(DRIVER_NAME, CHROME);
    }

}
