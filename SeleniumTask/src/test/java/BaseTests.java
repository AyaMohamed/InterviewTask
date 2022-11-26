import Pages.FirstGoogleSearchPage;
import Pages.GoogleHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {

    private static WebDriver webDriver;
    protected static GoogleHomePage homePage;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        goHome();

    }

    private static void goHome() {
        webDriver.get("https://www.google.com/en");
        homePage=new GoogleHomePage(webDriver);
    }

    public static void searchForFirstKeyword(String keyword)
    {
        homePage.setSearchText(keyword);
        homePage.clickSearchButton();
    }

    @AfterAll
    public static void tearDown()
    {
        webDriver.quit();
    }


}
