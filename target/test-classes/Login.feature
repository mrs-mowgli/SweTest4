Feature: Sign In user should be able to sign in to the webpage

  @testing
  Scenario Outline: Sign in with a existing account
    Given I am at the login page
    When I fill in <username> in username field
    And I fill in <password> in password field
    And I click sign in
    Then I am signed in
  Examples:
      | username               | password  |
      | andreas.jensen@iths.se | test123   |

  @testing
  Scenario Outline: Sign in with a non-existing account
    Given I am at the login page
    When I fill in <username> in username field
    And I fill in <password> in password field
    And I click sign in
    Then authentication failed message is displayed
    Examples:
      |username                | password |
      | andreas.jen@iths.se    | test13   |
      | andreas.jensen@iths.se | test13   |
      | andreas.jensn@its.se   | test123  |


  @testing
  Scenario Outline: The user should be able to choose if the password should be shown or hidden
   Given I am at the login page
    When I fill in <username> in username field
    And I fill in <password> in password field
    And I click <show> button
    Then the password is <show> in password field
  Examples:
      |password | username | show   |
      | Test123 | TestUser | show   |
      | Test123 | TestUser | hidden |

    @testing
    Scenario: User logs into account and decides to logout
      Given I am at the login page
      When I fill in andreas.jensen@iths.se in username field
      And I fill in test123 in password field
      And I click sign in
      And I click sign out
      Then I am logged out from account

    @testing
    Scenario Outline: User logs in and changes password
      Given I am at the login page
      When I fill in test_password@hotmail.com in username field
      And I fill in <old password> in password field
      And I click sign in
      And I change <old password> to <new password>
      And I click sign out
      And I close browser
      And I am at the login page
      And I fill in test_password@hotmail.com in username field
      And I fill in <new password> in password field
      And I click sign in
      And I am signed in
      Then Restore <new password> with <old password>
    Examples:
      |old password|new password|
      |test123     |test1234    |
