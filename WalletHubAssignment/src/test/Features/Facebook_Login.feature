Feature: WalletHub Assignment

 Scenario Outline: Login functionality for Facebook

    Given user navigates to Facebook
    When I enter Username as "<username>" and Password as "<password>"
    Then user is able to login and show Hello world
   Examples:
     | username       | password |
     | rajeshranjan82 | Ship4feb |


