package com.bdd.BDDFundTransfer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AdminLoginSteps {


    private static final By LOC_USERNAME = By.id("input-username");
    private static final By LOC_PASSWORD = By.id("input-password");
    private static final By LOC_LOGIN_BUTTON = By.cssSelector("button.btn.btn-primary");
    private static final By LOC_LOGOUT_BUTTON = By.cssSelector("i.fa.fa-sign-out");
    private static final By LOC_ERR_VALID_MSG = By.cssSelector("div.alert-danger");


    /**
     * Use this step to open the admin login page.
     */
    @Given("the current user is on the admin login page")
    public void theCurrentUserIsOnTheAdminLoginPage() {
        Browser.driver.get("http://shop.pragmatic.bg/admin/");
    }

    /**
     * Use this step to fill the admin credentials in the admin login form
     *
     * @param username the text used to fill the username field
     * @param password the text used to fill the password field
     */
    @When("the user logs in using username {string} and password {string}")
    public void theUserLogsInUsingUsernameAndPassword(String username, String password) {
        Browser.driver.findElement(LOC_USERNAME).sendKeys(username);
        Browser.driver.findElement(LOC_PASSWORD).sendKeys(password);
    }

    /**
     * Use this step to click on the admin login button.
     */
    @And("the user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        Browser.driver.findElement(LOC_LOGIN_BUTTON).click();
    }

    /**
     * Use this step to check whether the login was successful based on the page title!
     */
    @Then("the user should successfully log in into the admin panel")
    public void theUserShouldSuccessfullyLogInIntoTheAdminPanel() {
        String actualDashboardTitle = Browser.driver.getTitle();
        Assert.assertEquals(actualDashboardTitle, "Dashboard", "The login was not successful!");
    }

    /**
     * Use this method to logout out of the admin panel.
     */
    @And("after that I logout from the admin panel")
    public void afterThatILogoutFromTheAdminPanel() {
        Browser.driver.findElement(LOC_LOGOUT_BUTTON).click();
    }

    /**
     * Use this step to check whether the login was unsuccessful based on the error validation message!
     */
    @Then("the user login should be unsuccessful and the error message should contain {string}")
    public void theUserLoginShouldBeUnsuccessfulAndTheErrorMessageShouldContain(String errorMessage) {
        String actualError = Browser.driver.findElement(LOC_ERR_VALID_MSG).getText();
        Assert.assertTrue(actualError.contains(errorMessage));
    }
}