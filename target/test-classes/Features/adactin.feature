Feature: To Automate Adactin hotel booking

  @smoke
  Scenario: To generate order no in adactin hotel page
    Given User must be in adactin hotel booking page
    And User Login using valid username and password
    When User enter booking details
    And User must click selected hotel
    And User must enter card details for payment
      | key        | value            |
      | first name | jayaprakash      |
      | last name  | baskaran         |
      | address    | chennai,india    |
      | card no    | 1564812567858546 |
      | cvv no     |              584 |
    Then Check whether the order No is generated
    Then To high light the order No
