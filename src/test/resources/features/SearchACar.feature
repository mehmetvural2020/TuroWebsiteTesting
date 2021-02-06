Feature: Verifying the Search
  Scenario Outline: User fill the search option
    Given user is in landing page
    Then User enter "location" in Where text box
    Then User select "date" and "time" under From
    Then User select "date" and "time" under Until
    Then User clicks Search button
    Examples:
      |  |