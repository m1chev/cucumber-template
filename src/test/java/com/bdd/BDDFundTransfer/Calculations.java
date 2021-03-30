package com.bdd.BDDFundTransfer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Calculations {
    private static final By LOC_HEIGHT = By.id("cheightmeter");
    private static final By LOC_WEIGHT = By.id("ckg");
    private static final By LOC_CALCULATE = By.cssSelector("input[alt='Calculate']");
    private static final By LOC_CATEGORY = By.cssSelector("#content > div.rightresult > div > font > b");

    @Given("the User on the correct page")
    public void theUserOnTheCorrectPage() {
        Browser.driver.get("https://www.calculator.net/bmi-calculator.html");
    }

    @When("User enters {string}, {string}, {string}, {string}")
    public void user_enters(String age, String gender, String height, String weight) {
        // Write code here that turns the phrase above into concrete actions
        Browser.driver.findElement(LOC_HEIGHT).clear();
        Browser.driver.findElement(LOC_HEIGHT).sendKeys(height);

        Browser.driver.findElement(LOC_WEIGHT).clear();
        Browser.driver.findElement(LOC_WEIGHT).sendKeys(weight);
        throw new cucumber.api.PendingException();
    }

//    @When("the User enters the information")
//    public void theUserEntersTheInformation() {
//        Browser.driver.findElement(LOC_HEIGHT).clear();
//        Browser.driver.findElement(LOC_HEIGHT).sendKeys("180");
//
//        Browser.driver.findElement(LOC_WEIGHT).clear();
//        Browser.driver.findElement(LOC_WEIGHT).sendKeys("70");
//    }

    @And("clicks calculate")
    public void clicksCalculate() {
        Browser.driver.findElement(LOC_CALCULATE).click();
    }

    @Then("the User should be able to see the info")
    public void theUserShouldBeAbleToSeeTheInfo() {
        Assert.assertEquals(
                Browser.driver.findElement(LOC_CATEGORY).getText(),
                "Normal"
        );
        
    }

    @And("quit")
    public void quit() {
        Browser.driver.quit();
    }

}
