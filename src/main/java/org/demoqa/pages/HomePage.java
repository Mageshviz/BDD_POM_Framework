package org.demoqa.pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    // Locating the search input field
    @FindBy(id = "searchBox")
    WebElement searchInput;

    // Locating the search button
    @FindBy(xpath = "//button[@id='searchButton']")
    WebElement searchButton;

    /**
     * Method to get a dynamic locator for card items.
     *
     * @param cardName The name of the card to locate.
     * @return WebElement of the card.
     */
    public WebElement getCardByName(String cardName) {
        String dynamicXPath = String.format("//h5[text()='%s']", cardName);
        return driver.findElement(By.xpath(dynamicXPath));
    }


    // Constructor to initialize the PageFactory elements
    public HomePage(WebDriver driver) {
        this.driver = driver;
        // Initializing the PageFactory elements
        PageFactory.initElements(driver, this);
    }

    // Method to perform a search
    public void searchProduct(String productName) {
        searchInput.clear();
        searchInput.sendKeys(productName);
        searchButton.click();
    }

    // Method to click on the cart link
    public void clickCardByName(String cardName) {
        WebElement card = getCardByName(cardName);
        Assert.notNull(card, "Given cardName:" + cardName + " not available");
        card.click();
    }
}