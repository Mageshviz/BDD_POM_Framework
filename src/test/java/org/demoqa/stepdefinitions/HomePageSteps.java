package org.demoqa.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.demoqa.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Assert;

import java.util.logging.Logger;

public class HomePageSteps {
    private static final Logger logger = Logger.getLogger(HomePageSteps.class.getName());
    WebDriver driver;
    HomePage homePage;

    @Given("I am on the demo qa homepage")
    public void i_am_on_the_demoqa_homepage() {
        // Set up the WebDriver path from system property or external configuration
        System.setProperty("webdriver.chrome.driver", "/Users/mageshwaranv/IdeaProjects/DemoQA/src/test/resources/drivers/chromedriver");

        // Add ChromeOptions to run headless if needed
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.navigate().to("https://demoqa.com/");
        homePage = new HomePage(driver);
    }

    @When("I click on the {string}")
    public void i_click_on_the_card(String cardName) {
        homePage.clickCardByName(cardName);
    }

    @Then("I should be navigated to the {string} page")
    public void i_should_be_navigated_to_the_elements_page(String cardName) {
        // Check that the current URL contains the lowercase card name
        Assert.assertTrue("URL does not contain the expected card name!",
                driver.getCurrentUrl().toLowerCase().contains(cardName.toLowerCase()));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("Unable to quit the driver successfully:" + e.getMessage());
            }
        } else {
            System.out.println("Driver is null. Browser might already be closed.");
        }
    }
}