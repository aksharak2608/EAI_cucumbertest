Feature: your store

  Background: below are common steps
    Given user launch "chrome" browser with "https://admin-demo.nopcommerce.com/login "
    Then user navigates to "Your store. Login"
    And user enters email as "admin@yourstore.com" and password as "admin"
    Then CLick on login

  @nop
  Scenario: sucessfull login
    And user lands on "Dashboard / nopCommerce administration" page

  @nop
  Scenario Outline: sucessfull login
    And user lands on "Dashboard / nopCommerce administration" page
    Then user clicks on "<menu>" menu
    When user clicks on customer Button
    Then user lands on "<customer search>" page

    Examples: 
      | menu      | customer search                        |
      | Customers | Customers / nopCommerce administration |

  @sanity
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
      @sanity
      Scenario: sucessfull login
    And user lands onsdf "Dashboard / nopCommerce administration" page
    Then user clicks onsdf "menu" menu
    When user clicks onsdfd customer Button
