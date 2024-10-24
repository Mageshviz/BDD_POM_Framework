package org.demoqa.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.demoqa.pages.HomePage;
import org.demoqa.utils.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.slf4j.Logger;

public class HomePageSteps {
    WebDriver driver;
    HomePage homePage;
    private static final Logger logger = LoggerUtil.getLogger(HomePageSteps.class);

    @Given("I am on the demo qa homepage")
    public void i_am_on_the_demoqa_homepage() {
        logger.info("Opening the DemoQA homepage.");
        System.setProperty("webdriver.chrome.driver", "/Users/mageshwaranv/IdeaProjects/DemoQA/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/");
        homePage = new HomePage(driver);
    }

    @When("I click on the {string}")
    public void i_click_on_the_card(String cardName) {
        logger.info("Clicking on the card: {}", cardName);
        homePage.clickCardByName(cardName);
    }

    @Then("I should be navigated to the {string} page")
    public void i_should_be_navigated_to_the_elements_page(String cardName) {
        Assert.assertTrue(driver.getCurrentUrl().contains(cardName.toLowerCase()));
        logger.info("Navigated to the {} page.", cardName);
    }

    @After
    public void afterStep() {
        logger.info("Closing the browser.");
        driver.quit();
    }
}