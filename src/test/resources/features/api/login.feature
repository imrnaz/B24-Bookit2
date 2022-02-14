Feature: BookIt API Login verification

  Scenario: verify login with valid credentials
    Given User logged in BookIt api as teacher role
    And User sends request to "/api/users/me"
    Then status code should be 200
    And content type is "application/json"
    And role is "teacher"

    @ui
  Scenario: verify user details with ui and api
    Given User logged in BookIt api as teacher role
    And User sends request to "/api/users/me"
    And Given user logged in to BookIt app as teacher role
    And user is on self page
    Then User should see same info on UI and API


