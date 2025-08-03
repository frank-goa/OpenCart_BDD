Feature: User Login

  Scenario: Successful login with valid credentials
    Given the user is on the OpenCart login page
    When the user enters a valid credentials(email: "franson@rediffmail.com", password: "Erica@0815")
    And clicks the login button
    Then the user should be redirected to the account page
