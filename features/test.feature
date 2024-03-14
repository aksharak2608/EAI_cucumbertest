Feature: Title of your feature
  I want to use this template for my feature file

  Background: 
    Given user opens "chrome" browser with "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    Then verify the title is "Your store. Login"
    And enter the username "admin@yourstore.com" and password "admin"
    Then click on login

  @sanity
  Scenario Outline: Title of your scenario
    And user lands on "Dashboard / nopCommerce administration"
    Then user clicks on "<menu>" menu
    When user clicks on customer Button
    Then user lands on "<customer search>" page

    Examples: 
      | menu      | customer search                        |
      | Customers | Customers / nopCommerce administration |

  @sanity @reg
  Scenario: Title of your scenario
    And user lands on "Dashboard / nopCommerce administration"
    @reg
  Scenario Outline: sucessfull login
    And user lands on "Dashboard / nopCommerce administration" page
    Then user clicks on "<menu>" menu
    When user clicks on customer Button
    Then user lands on "<customer search>" page
    Then CLick on "email" field
    And insert "<emailId>" as email
    Then Click on search button
    And Email should be visible as "<emailId>"

    Examples: 
      | menu      | customer search                        | emailId                   |
      | Customers | Customers / nopCommerce administration | james_pan@nopCommerce.com |
    
