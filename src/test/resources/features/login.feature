Feature: User Login

#  @sanity @regression
#  Scenario: Successful login with valid credentials
#    Given the user is on the OpenCart login page
#    When the user enters a valid credentials
#    And clicks the login button
#    Then the user should be redirected to the account page

    @Regression
    Scenario Outline: Login Data Driven Test
      Given the user is on the OpenCart login page
      When the user enters "<username>" and "<password>"
      And clicks the login button
      Then the user should be redirected to the account page

      Examples:
        | username                   | password    |
        | franson@rediffmail.com  | Erica@0815  |
        | fran@rediffmail.comxx   | Ericaxx     |