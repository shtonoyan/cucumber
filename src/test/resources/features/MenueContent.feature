# new feature
# Tags: optional

Feature: As a user I want to use left menu sections

  Background: User is Logged In
    Given the user opens the gmail website
    When the user type the username "shtonoyan.test"
    When click the next button
    When the user type password "april192020"
    When click the next button
    Then gmail inbox page is displayed

  @Smoke
  Scenario Outline: Left menu should contain appropriate sections
    When user clicks on the "<title>" section
    Then the title "<title>" is displayed
    Examples:
      | title     |
      | Starred   |
      | Snoozed   |
      | Important |
      | Sent      |
