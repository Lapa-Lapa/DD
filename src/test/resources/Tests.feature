@Tests
Feature: Tests

  @Test
  Scenario: [1] Drop-down menu sections check
    Given Open home page
    When Click hamburger menu button
    Then Verify that all menu sections present

  @Test @run
  Scenario Outline: [2] Pages under menu sections check
    Given Open home page
    And Click hamburger menu button
    When Click "<Page>" menu section
    Then Verify new page is open

    Examples:
      | Page    |
      | AFISHA  |


  @Test
  Scenario: [4] Search pre-results
    Given Open home page
    And Type "телефон" in Search Field
    Then Verify "10" results appear