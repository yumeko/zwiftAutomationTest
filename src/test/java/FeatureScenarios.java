import com.zwift.automation.model.ZwiftEventPage;
import com.zwift.automation.model.ZwiftMainPage;
import com.zwift.automation.support.Environment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class FeatureScenarios {
    private WebDriver webDriver;

    @Test
    public void homePageLoadsAndWelcomeMsgDisplayed() {
        ZwiftMainPage mp = new ZwiftMainPage(webDriver);
        assertTrue(mp.onPage());
        boolean welcomeMsgDisplayed = webDriver.findElement(By.tagName("body")).getText().contains("WELCOME TO ZWIFT");
        assertTrue(welcomeMsgDisplayed);
    }

    @Test
    public void eventPageLoadsAndFiltersEvents() {
        ZwiftMainPage mainPage = new ZwiftMainPage(webDriver);
        mainPage.clickEvents();
        ZwiftEventPage eventPage = new ZwiftEventPage(webDriver);
        assertTrue(eventPage.onPage());
        int defaultResultNum = eventPage.getNumberOfEventResults();
        eventPage.getEventPicklist("Sports").selectByVisibleText("Cycling");
        eventPage.getEventPicklist("Intensities").selectByVisibleText("B");
        eventPage.getEventPicklist("Start Times").selectByVisibleText("Morning");
        int currentResultNum = eventPage.getNumberOfEventResults();
        System.out.println("Previous Result Num: " + defaultResultNum + "\nCurrent Result Num: " + currentResultNum);
        assert(defaultResultNum != currentResultNum);
    }


    @Before
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", Environment.chromeDriverPath);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(Environment.url);
    }

    @After
    public void endDriver() {
        webDriver.quit();
    }

}
