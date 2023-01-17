Feature: Login to website
  Go to 'https://assets2-dev.timelysoft.org/auth/login'



  Scenario: Main page
    Given user is on the main page of Tax Beacon system
    When user should able to see Sign In option
    And user is redirected to the Azure Active Directory authorisation page
    Then user should able to see next page



    Scenario Outline: Login page
    Given user is on the Azure Active Directory authorisation page
    When  user inputs "<username>", "<password>"
    And initiates authorisation process
    Then user is redirected to the "Tax Beacon home" page for authorised users in accordance with the user role
      Examples:
        | username    | password |
        | fvd@jhf.com | dfjkdk12 |

      Scenario:
      Given user is on the Azure Active Directory authorisation page
      When user enters username and password
      And username and password are NOT correct
      And initiates authorisation process
      Then the warning message about not correct username or password is shown