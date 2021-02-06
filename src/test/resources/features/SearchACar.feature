Feature: Verifying the Search

  Scenario Outline: User fill out the search option
    Given user is on landing page to search
    Then User enter "<location>" in Where text box
    Then User select "<dateFrom>" and "<timeFrom>" under From
    Then User select "<dateUntil>" and "<timeUntil>" under Until
    Then User clicks Search button
    And User clicks on Sort By menu and select an option then clicks on apply
    And User clicks on Price menu and adjust the price range then clicks on view results
    And User clicks on Book instantly menu and clicks on view results
    And User clicks on Delivery menu and adjust the distance range then clicks on view results
    And User clicks on More filters menu and select All-Star Host
#    And select "<Vehicle_types>" and clicks on upper arrow
    And select "<Vehicle_makes>" and clicks on upper arrow
    And adjust the Vehicle years range and select the Transmission
    Then User clicks on view results
    Then User selects the first car in the list
    And Verify that Pickup & return location is present
    Then User selects Pickup & return location
    And User clicks on Continue button
    Examples:
      | location    | dateFrom  | timeFrom | dateUntil | timeUntil |  Vehicle_makes |
      | "New York"  | "02102021"| "1000AM" | "02152021"| "1000AM"  |   "BMW"         |