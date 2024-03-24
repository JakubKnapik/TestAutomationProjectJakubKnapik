import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;


public class ElementsPageTest {
    static WebDriver webDriver;
    HomePage homePage = new HomePage(webDriver);
    ElementsPage elementsPage = new ElementsPage(webDriver);

    @Test
    public void checkIfInputsAndOutputsAreTheSame() throws InterruptedException {
        elementsPage.openSpecificTabFromElements("Text Box");
        assertEquals("Text Box",elementsPage.getHeaderText());
        elementsPage.insertFullName("Jan Nowak");
        elementsPage.insertEmail("jannowak@test.ok");
        elementsPage.insertCurrentAddress("Test Street 17/17");
        elementsPage.insertPermanentAddress("Test Street 82");
        elementsPage.clickSubmitButton();
        assertTrue(elementsPage.getNameOutput().contains(elementsPage.getFullName()));
        assertTrue(elementsPage.getEmailOutput().contains(elementsPage.getEmail()));
        assertTrue(elementsPage.getCurrentAddressOutput().contains(elementsPage.getCurrentAddress()));
        assertTrue(elementsPage.getPermanentAddressOutput().contains(elementsPage.getPermanentAddress()));
    }

    @Test
    public void checkEmailFieldValidation() throws InterruptedException{
        elementsPage.openSpecificTabFromElements("Text Box");
        assertEquals("Text Box",elementsPage.getHeaderText());
        elementsPage.insertEmail("jannowak@");
        elementsPage.clickSubmitButton();
        assertTrue(elementsPage.checkErrorClass().contains("field-error"));
    }

    //below test will fail which is correct behavior
    @Test
    public void checkIfCheckboxesAreMarked() throws InterruptedException{
        elementsPage.openSpecificTabFromElements("Check Box");
        assertEquals("Check Box",elementsPage.getHeaderText());
        elementsPage.clickCheckbox("home");
        elementsPage.clickToggleButton();
        assertTrue(elementsPage.isTextDisplayed("home"));
        assertTrue(elementsPage.isTextDisplayed("desktop"));
        assertTrue(elementsPage.isTextDisplayed("documents"));
        assertTrue(elementsPage.isTextDisplayed("downloads"));
        elementsPage.clickCheckbox("desktop");
        elementsPage.clickCheckbox("downloads");
        assertTrue(elementsPage.isTextDisplayed("home"));
        assertFalse(elementsPage.isTextDisplayed("desktop"));
        assertFalse(elementsPage.isTextDisplayed("downloads"));
    }

    @Test
    public void checkIfRadioButtonsWorks() throws InterruptedException{
        elementsPage.openSpecificTabFromElements("Radio Button");
        assertEquals("Radio Button",elementsPage.getHeaderText());
        elementsPage.scrollWindowVertically();
        assertTrue(elementsPage.isRadioButtonEnabled("yes"));
        elementsPage.clickRadioButton("yes");
        assertTrue(elementsPage.isRadioButtonEnabled("impressive"));
        elementsPage.clickRadioButton("impressive");
        assertFalse(elementsPage.isRadioButtonEnabled("no"));
    }

    @Test
    public void checkIfButtonsAreClickable() throws InterruptedException{
        elementsPage.openSpecificTabFromElements("Buttons");
        assertEquals("Buttons",elementsPage.getHeaderText());
        elementsPage.scrollWindowVertically();
        elementsPage.clickDoubleClickButton();
        assertTrue(elementsPage.isDoubleClickPerformed());
        elementsPage.clickRightClickButton();
        assertTrue(elementsPage.isRightClickPerformed());
    }

    @BeforeAll
    public static void setup() {
        webDriver = new ChromeDriver();
    }

    @BeforeEach
    public void beforeEach(){
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://demoqa.com");
        homePage.openSpecificCard("Elements");
    }

    @AfterAll
    public static void teardown() {
        webDriver.quit();
    }
}
