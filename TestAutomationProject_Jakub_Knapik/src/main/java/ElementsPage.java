import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementsPage {
    WebDriver driver;

    String tab = "//span[contains(text(),'<<var>>')]";
    By headerText = By.cssSelector(".text-center");
    By fullNameInput = By.id("userName");
    By emailInput = By.id("userEmail");
    By currentAddressInput = By.id("currentAddress");
    By permanentAddressInput = By.id("permanentAddress");
    By submitButton = By.id("submit");
    By fullNameOutput = By.cssSelector("p[id='name']");
    By emailOutput = By.cssSelector("p[id='email']");
    By currentAddressOutput = By.cssSelector("p[id='currentAddress']");
    By permanentAddressOutput = By.cssSelector("p[id='permanentAddress']");
    String checkbox = "label[for='tree-node-<<var>>'] svg";
    By toggleButton = By.cssSelector("button[aria-label='Toggle']");
    String resultText = "//div[@id='result']/span[contains(text(),'<<var>>')]";
    String radioButtonForClick = "label[for='<<var>>Radio']";
    String radioButtonForEnableCheck = "input[id='<<var>>Radio']";
    By doubleClickButton = By.id("doubleClickBtn");
    By rightClickButton = By.id("rightClickBtn");
    By doubleClickMessage = By.id("doubleClickMessage");
    By rightClickMessage = By.id("rightClickMessage");

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollWindowVertically() throws InterruptedException{
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
        Thread.sleep(1000);
    }

    public void openSpecificTabFromElements(String tabName) {
        driver.findElement(By.xpath(tab.replace("<<var>>", tabName))).click();
    }

    public String getHeaderText() {
        return driver.findElement(headerText).getText();
    }

    public void insertFullName(String fullName) {
        driver.findElement(fullNameInput).sendKeys(fullName);
    }

    public String getFullName() {
        return driver.findElement(fullNameInput).getText();
    }

    public void insertEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public String getEmail() {
        return driver.findElement(emailInput).getText();
    }

    public void insertCurrentAddress(String curAddress) {
        driver.findElement(currentAddressInput).sendKeys(curAddress);
    }

    public String getCurrentAddress() {
        return driver.findElement(currentAddressInput).getText();
    }

    public void insertPermanentAddress(String perAddress) {
        driver.findElement(permanentAddressInput).sendKeys(perAddress);
    }

    public String getPermanentAddress() {
        return driver.findElement(permanentAddressInput).getText();
    }

    public void clickSubmitButton() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
        driver.findElement(submitButton).click();
        Thread.sleep(1000);
    }

    public String getNameOutput() {
        return driver.findElement(fullNameOutput).getText();
    }

    public String getEmailOutput() {
        return driver.findElement(emailOutput).getText();
    }

    public String getCurrentAddressOutput() {
        return driver.findElement(currentAddressOutput).getText();
    }

    public String getPermanentAddressOutput() {
        return driver.findElement(permanentAddressOutput).getText();
    }

    public String checkErrorClass() {
        return driver.findElement(emailInput).getAttribute("class");
    }

    public void clickToggleButton() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");
        driver.findElement(toggleButton).click();
    }

    public void clickCheckbox(String checkboxName) {
        driver.findElement(By.cssSelector(checkbox.replace("<<var>>", checkboxName))).click();
    }

    public boolean isTextDisplayed(String text) throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(By.xpath(resultText.replace("<<var>>", text))).isDisplayed();
    }

    public boolean isRadioButtonEnabled(String text){
        return driver.findElement(By.cssSelector(radioButtonForEnableCheck.replace("<<var>>", text))).isEnabled();
    }

    public void clickRadioButton(String text) {
        driver.findElement(By.cssSelector(radioButtonForClick.replace("<<var>>", text))).click();
    }

    public void clickDoubleClickButton() throws InterruptedException{
        Actions act = new Actions(driver);
        WebElement button = driver.findElement(doubleClickButton);
        act.doubleClick(button).perform();
        Thread.sleep(1000);
    }

    public boolean isDoubleClickPerformed(){
        return driver.findElement(doubleClickMessage).isDisplayed();
    }

    public void clickRightClickButton() throws InterruptedException{
        Actions act = new Actions(driver);
        WebElement button = driver.findElement(rightClickButton);
        act.contextClick(button).perform();
        Thread.sleep(1000);
    }

    public boolean isRightClickPerformed(){
        return driver.findElement(rightClickMessage).isDisplayed();
    }
}