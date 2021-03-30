Feature: Admin Login Scenarios - POSITIVE
  As an admin I want to be able to successfully login

  @dev
  Scenario Outline: Successfully being able to login as an admin user
    Given the current user is on the admin login page
    When the user logs in using username "<username>" and password "<password>"
    And the user clicks on the login button
    Then the user should successfully log in into the admin panel
    And after that I logout from the admin panel
    Examples:
      | username | password   |
      | admin    | parola123! |
      | admin2   | parola123! |