Feature: Assignment_2

  Scenario Outline: Submit Review on WalletHub

    Given User is logged in with "<Username>" & "<Password>"
    When light up first start when user hover the first start and click on fourth start
    And select Health Insurance from dropdown on new page and submit your review
    Then review submitted successfully and go to your profile page to confirm the review is submitted

    Examples:
      | Username               | Password    |
      |rajeshranjan82@gmail.com| Vaanya1710~~|


