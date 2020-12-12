Feature: Sign In user should be able to sign in to the webpage

  @testing
  Scenario Outline: Sign in with a existing account
    Given I am on start page using "<browser>"
    When I click sign in button from start page
    And I fill in <username> in username field
    And I fill in <password> in password field
    And I click sign in
    Then I am signed in
  Examples:
      | username               | password  | browser  |
      | andreas.jensen@iths.se | test123   | chrome   |
      | andreas.jensen@iths.se | test123   | firefox  |

  @testing
  Scenario Outline: Sign in with a non-existing account
    Given I am on start page using "<browser>"
    When I click sign in button from start page
    When I fill in <username> in username field
    And I fill in <password> in password field
    And I click sign in
    Then authentication failed message is displayed
    Examples:
      |username                | password | browser |
      | andreas.jen@iths.se    | test13   | chrome  |
      | andreas.jensen@iths.se | test13   | chrome  |
      | andreas.jensn@its.se   | test123  | chrome  |
      | andreas.jen@iths.se    | test13   | firefox |
      | andreas.jensen@iths.se | test13   | firefox |
      | andreas.jensn@its.se   | test123  | firefox |


  @testing
  Scenario Outline: The user should be able to choose if the password should be shown or hidden
    Given I am on start page using "<browser>"
    When I click sign in button from start page
    When I fill in <username> in username field
    And I fill in <password> in password field
    And I click <show> button
    Then the password is <show> in password field
  Examples:
      |password | username | show   | browser |
      | Test123 | TestUser | show   | chrome  |
      | Test123 | TestUser | hidden | chrome  |
      | Test123 | TestUser | show   | firefox  |
      | Test123 | TestUser | hidden | firefox  |

    @testing
    Scenario Outline: User logs into account and decides to logout
      Given I am on start page using "<browser>"
      When I click sign in button from start page
      When I fill in andreas.jensen@iths.se in username field
      And I fill in test123 in password field
      And I click sign in
      And I click sign out
      Then I am logged out from account
      Examples:
      | browser |
      | chrome  |
      | firefox |

    @testing
    Scenario Outline: User logs in and changes password
      Given I am on start page using "<browser>"
      When I click sign in button from start page
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
      |old password|new password| browser |
      |test123     |test1234    | chrome  |
      |test123     |test1234    | firefox |

      Scenario Outline: User has forgotten password and want to restore password
        Given I am on start page using "<browser>"
        When I click sign in button from start page
        When I click forgotten password
        And I fill in "<email>" on forgotten password page
        And I click reset link
        Then reset password link is sent to "<email>"
        Examples:
        | email           | browser |
        | asd@hotmail.se  | chrome  |
        | asd@hotmail.com | firefox |

    Scenario Outline: User has forgotten password and want to restore password, but has not registered an account
      Given I am on start page using "<browser>"
      When I click sign in button from start page
      When I click forgotten password
      And I fill in "<email>" on forgotten password page
      And I click reset link
      Then reset password link is not sent to "<email>"
    Examples:
      | email                   | browser |
      | andreas.jensen@iths.se  | chrome  |
      | andreas.jensen@iths.se  | firefox |
