Feature: Login into application with different users

    @smoke
    Scenario: Login into Swag Labs with standard user
    Given User is on Swag Labs login page
    When User enters "standard user" credentials
    And User clicks login button
    Then User verifies Home page

    @smoke
    Scenario: Login into Swag Labs with locked out user
     Given User is on Swag Labs login page
    And User enters "locked_out_user" credentials
    And User clicks login button
    And User verifies error message "Epic sadface: Sorry, this user has been locked out."

    @smoke
    Scenario: Login into Swag Labs with  problem user
     Given User is on Swag Labs login page
    And User enters "problem_user" credentials
    And User clicks login button

    @smoke
    Scenario: Login into Swag Lads with performance glitch user
     Given User is on Swag Labs login page
    And User enters "performance_glitch_user" credentials
    And User clicks login button
    And User verifies Home page
    And User verifies delay in visibility of Swag Labs logo