Feature: Negative test for facebook login functionality


  Scenario: Testing incorrect login credentials
    Given user navigates to Facebook webpage
    When  user enters "username" in the username box
    And   user enters "password" in the password box
    And   user clicks on login button
    Then  user unable to login and receives an error message containing "Find your account and log in."
