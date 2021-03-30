@testTags
Feature: Using Product Filter

  In order to see only products from specific brand
  as administrator
  I should be able to filter using key word

  Background: I am successfully logged in on the site as administrator
    Given the current user is on the admin login page
    When the user logs in using username "admin" and password "parola123!"
    And the user clicks on the login button

  Scenario Outline: See only Apple products
    When clicks on the "Catalog"
    And clicks on the "Products"
    And enter value "<search>" in field Product Name
    And clicks on the "Filter"
    Then all elements in the list should contain "<result>" in the text

    Examples: Search Table
    | search|result|
    | apple |Apple |
    | ipod  |iPod  |
