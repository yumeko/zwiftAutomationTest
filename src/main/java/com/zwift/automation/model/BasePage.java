package com.zwift.automation.model;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    public WebDriver driver;
    By zwiftLogo = By.id("znv-header-logo-link");
    By zwiftEventLink = By.xpath("//a[@id='znv-header-logo-link']/following-sibling::div/a[@href='/events']");
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.wait = new WebDriverWait(driver,5);
        this.driver = driver;
    }

    public boolean onPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(zwiftLogo));
        return true;
    }

    public void clickEvents(){
        wait.until(ExpectedConditions.elementToBeClickable(zwiftEventLink));
        driver.findElement(zwiftEventLink).click();
    }
}
