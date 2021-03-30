package com.bdd.BDDFundTransfer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AdminCatalogSteps {

    private static final By LOC_CATALOG = By.cssSelector("#menu-catalog>a");
    private static final By LOC_PRODUCTS = By.cssSelector("#collapse1 li:nth-child(2)");
    private static final By LOC_PRODUCT_NAME = By.cssSelector("input[name='filter_name']");
    private static final By LOC_FILTER = By.cssSelector("#button-filter");
    private static final By LOC_SEARCH_RESULT_TEXT = By.cssSelector("tbody td:nth-child(3)");
    private static final By LOC_MANUFACTURER = By.cssSelector("#menu-catalog a[href*='manufacturer']");
    private static final By LOC_MANUFACTURER_LIST = By.cssSelector("tbody td:nth-child(2)");

    @When("clicks on the {string}")
    public void clicksOnThe(String button) {
        By buttonToClick = toByElement(button);
        Browser.driver.findElement(buttonToClick).click();
    }

    /**
     * Picks up the correct locator on pre-defined String values.
     * Meant to be used for clicking on specific buttons.
     * @param buttonText Pre-defined text could be "Catalog", "Products", "Filter"
     * @return By element unless different than the pre-defined values, where will return NULL
     */
    private By toByElement(String buttonText) {
        switch (buttonText){
            case "Catalog":
                return LOC_CATALOG;
            case "Products":
                return LOC_PRODUCTS;
            case "Filter":
                return LOC_FILTER;
            case "Manufacturer":
                return LOC_MANUFACTURER;
            default:
                return null;
        }
    }

    @And("enter value {string} in field Product Name")
    public void enterValueInFieldProductName(String text) {
        Browser.driver.findElement(LOC_PRODUCT_NAME).sendKeys(text);
    }

    @Then("all elements in the list should contain {string} in the text")
    public void allElementsInTheListShouldContainInTheText(String searchedText) {

        List<WebElement> foundResults = new ArrayList<>(Browser.driver.findElements(LOC_SEARCH_RESULT_TEXT));

        for(WebElement i : foundResults) {
            if(i.getText().contains(searchedText)) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false,
                        "Expected: "
                                + searchedText
                                + " but Found is: "
                                + Browser.driver.findElement(LOC_SEARCH_RESULT_TEXT).getText()
                );
            }
        }
    }

    @Then("I should see manufacturer name {string}")
    public void iShouldSeeManufacturerName(String manufacturerName) {
        List<WebElement> listResults = new ArrayList<>(Browser.driver.findElements(LOC_MANUFACTURER_LIST));

        for(WebElement i : listResults) {
            if(i.getText().contains(manufacturerName)) {
                Assert.assertTrue(true);
                return;
            }
        }
        Assert.assertTrue(false,
                "Expected: "
                        + manufacturerName
                        + " but Found none"
        );
    }
}
