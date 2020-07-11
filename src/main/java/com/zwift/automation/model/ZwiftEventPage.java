package com.zwift.automation.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ZwiftEventPage extends BasePage {
    By eventHeader = By.tagName("header");
    By eventPicklists = By.id("filter-location");
    By eventResults = By.className("tab-listing");
    By eventBody = By.id("zwift-events");

    public ZwiftEventPage(WebDriver driver) {
        super(driver);
    }

    public boolean onPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(eventHeader));
        return true;
    }

    public int getNumberOfEventResults(){
        wait.until(ExpectedConditions.or(
                ExpectedConditions.numberOfElementsToBeMoreThan(eventResults,0),
                ExpectedConditions.textToBePresentInElementLocated(eventBody, "Event series completed")));
        List<WebElement> results = driver.findElements(eventResults);
        return results.size();
    }

    public Select getEventPicklist(String picklistName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(eventPicklists));
        List<WebElement> picklists = driver.findElements(eventPicklists);
        for (WebElement picklist : picklists) {
            Select pl = new Select(picklist);
            if (picklistName.equals(pl.getOptions().get(0).getText())) {
                return pl;
            }
        }
        return null;
    }


}
