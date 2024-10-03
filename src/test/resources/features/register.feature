Feature: User Registration
  Scenario: Successful User Registration
    Given I navigate to the signup page
    When I enter the following details:
    | firstName | Ezra |
    | middleName | Alebel |
    | lastName | Arega |
    | email | ezraarega@gmail.com |
    | password | password123 |
    | role | Admin|
    And I click the "Submit" button
    Then I should see the user detail page