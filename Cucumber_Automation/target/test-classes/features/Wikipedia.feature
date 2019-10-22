Feature: Search in Wikipedia

  Scenario Outline: Search for few fruits in wikipedia
    Given User opens wikipedia website
    When User enters search phrase as "<Fruits>"
    Then Page title should contain "<Fruits>"
    And I verify "<Fruits>" search entity in the searched page
    And Application is closed

    Examples: 
      | Fruits |
      | Apple  |
      | Orange |
      | Mango  |

  Scenario: Search with invalid searchitem
    Given User opens wikipedia website
    When User enters search phrase as "Gpes"
    Then Result is shown for "Gpes"
    And Application is closed
