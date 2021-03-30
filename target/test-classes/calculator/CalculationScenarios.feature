Feature: Calculating BMI and determine Category
  As a User I should be able to calculate my Body Mass Index

  Scenario Outline: : Successfully calculating my BMI and determine my Category
    Given the User on the correct page
    When User enters <"age">, <"gender">, <"height">, <"weight">
    And clicks calculate
    Then the User should be able to see the info
    And quit
    Examples:
      | "age" | "gender" | "height" | "weight" |
    | "25" | "male" | "182" | "73" |
      | "25" | "male" | "182" | "63" |
