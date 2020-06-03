# new feature
# Tags: optional

Feature: As a user I want to login when I input correct credentials


  Scenario: Login should be successful
    Given the user opens the gmail website
    When the user type the username "shtonoyan.test"
    When click the next button
    When the user type password "april192020"
    When click the next button
    Then gmail inbox page is displayed