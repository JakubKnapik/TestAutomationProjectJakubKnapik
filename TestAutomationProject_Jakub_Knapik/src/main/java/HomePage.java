import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    String card = "//h5[contains(text(),'<<var>>')]";
    By banner = By.id("close-fixedban");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openSpecificCard(String cardName)
    {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200);");
        driver.findElement(By.xpath(card.replace("<<var>>",cardName))).click();
    }

    public void closeBanner(){
        driver.findElement(banner).click();
    }

    public String getTitle(){
        return driver.getTitle();
    }



}
