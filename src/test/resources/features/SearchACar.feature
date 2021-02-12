Feature: Verifying the Search

  Scenario Outline: User fill out the search option
    Given user is on landing page to search
    Then User enter "<location>" in Where text box
    Then User select "<dateFrom>" and "<dateUntil>" under From
    Then User select "<timeFrom>" and "<timeUntil>" under Until
    Then User clicks Search button

    And User clicks on More filters menu and select All-Star Host
    And select CAR Vehicle types and select "<Vehicle_makes>" then clicks on upper arrow
    And User adjust the Vehicle years range
    Then User select the Transmission clicks on view results

    And User clicks on Sort By menu and select an option then clicks on apply
    And User clicks on Price menu and adjust the price range then clicks on view results
    And User clicks on Book instantly menu and clicks on view results
    And User clicks on Delivery menu and adjust the distance range then clicks on view results
    And User clicks on Distance included menu and select the distance then clicks on  apply button

    Then User selects the first car in the list and verify the selected car title is present

    Then User selects Pickup location

    And User clicks on Continue button



    Examples:
      | location        | dateFrom | dateUntil | timeFrom | timeUntil |  Vehicle_makes   |
      | Los Angeles, CA | 23       | 25        | 1000AM   | 1000AM    |   Toyota          |