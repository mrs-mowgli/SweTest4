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
  #Scenario: The user should be able to choose if the password should be shown or hidden
  #  Given I am at the login page
   # When I fill in <username> in username field
  #  And I fill in <password> in password field
  # And I click show password
   # Then password is shown

  @testing
  Scenario: User should be able to restore password


