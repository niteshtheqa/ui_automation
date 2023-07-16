Feature: Add Product to cart and verify its name and price

    @cart
    Scenario: Add Sauce Labs Backpack to cart and verify its name and price

        Given User is on Swag Labs login page
        And User enters "standard_user" credentials
        And User searches product "Sauce Labs Backpack"
        And User adds "" to cart
        And User clicks on cart
        Then User verifies name of Product
        And User verifies price of Product
