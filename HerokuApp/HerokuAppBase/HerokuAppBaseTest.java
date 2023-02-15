package HerokuApp.HerokuAppBase;

import HerokuApp.HerokuAppPages.HerokuAppLoginPage;
import HerokuApp.HerokuAppPages.HerokuAppLogoutPage;
import HerokuApp.HerokuAppTests.HerokuAppLoginTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class HerokuAppBaseTest {
    public static WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String LoginURL;
    public HerokuAppLoginPage herokuAppLoginPage;
    public HerokuAppLogoutPage herokuAppLogoutPage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("src/test/java/HerokuApp/TestData.xlsx");
        LoginURL = excelReader.getStringData("URL", 1, 0);
    }
}
