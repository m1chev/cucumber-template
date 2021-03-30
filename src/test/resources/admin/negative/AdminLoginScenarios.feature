Feature: Admin Login Scenarios - NEGATIVE
  As an admin I want to be able to successfully login

  Scenario: Can't login using non existing admin username
    Given the current user is on the admin login page
    When the user logs in using username "blablabla" and password "parola1231"
    And the user clicks on the login button
    Then the user login should be unsuccessful and the error message should contain "No match for Username and/or Password."