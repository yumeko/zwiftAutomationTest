import com.zwift.automation.model.ZwiftEventPage;
import com.zwift.automation.model.ZwiftMainPage;
import com.zwift.automation.support.Environment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.TestCase.*;

public class UnitTests {
    private WebDriver webDriver;

    @Test
    public void testBrowserNavigatesToZwiftMainPage(){
        webDriver.get(Environment.url);
        ZwiftMainPage mainPage = new ZwiftMainPage(webDriver);
        assertTrue(mainPage.onPage());
    }

    @Test
    public void testNavigateToEvent(){
        webDriver.get(Environment.url);
        ZwiftMainPage mainPage = new ZwiftMainPage(webDriver);
        mainPage.clickEvents();
        ZwiftEventPage eventPage = new ZwiftEventPage(webDriver);
        assertTrue(eventPage.onPage());
    }

    @Test
    public void testUpdatePicklist(){
        webDriver.get(Environment.url);
        ZwiftMainPage mainPage = new ZwiftMainPage(webDriver);
        mainPage.clickEvents();
        ZwiftEventPage eventPage = new ZwiftEventPage(webDriver);
        assertTrue(eventPage.onPage());

        Select pl = eventPage.getEventPicklist("Sports");
        assertNotNull(pl);

        int results = eventPage.getNumberOfEventResults();
        assert(results >= 0);
    }

    @Test(expected=TimeoutException.class)
    public void testClickEventButton_negativeTest(){
        webDriver.get(Environment.url);
        ZwiftEventPage eventPage = new ZwiftEventPage(webDriver);
        assertTrue(eventPage.onPage());
    }

    @Test(expected=TimeoutException.class)
    public void testBrowserNavigatesToZwiftMainPage_negativeTest(){
        webDriver.get("https://google.com");
        ZwiftMainPage mainPage = new ZwiftMainPage(webDriver);
        assertTrue(mainPage.onPage());
    }

    @Before
    public void startDriver(){
        System.setProperty("webdriver.chrome.driver",Environment.chromeDriverPath);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @After
    public void endDriver(){
        webDriver.close();
    }




}
