import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest {
    static WebDriver webDriver;
    HomePage homePage = new HomePage(webDriver);

    @BeforeAll
    public static void setup() {
        webDriver = new ChromeDriver();
    }

    @BeforeEach
    public void beforeEach(){
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://demoqa.com");
    }

    @AfterAll
    public static void teardown() {
        webDriver.quit();
    }

    @Test
    public void checkIfWebsiteTitleIsCorrect(){
        assertEquals("DEMOQA", homePage.getTitle());
    }
}