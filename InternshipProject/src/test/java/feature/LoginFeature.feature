Feature: CommercialFeature


  Scenario Outline: Register functionality

    Given Browser is open in CommercialPage
    And You click login Button and  click register Button
    And you select gender <gender>
    And you enter <firstname> in firstName Field and lastName Field <lastname>
    And you select "24" as birthDay
    And you select "June" as birthMonth
    And you select "1996" as birthYear
    And you enter <email> in email Field and companyName Field <company>
    And you enter <password> in password Field and confirmPass Field <password>
    When You click registerAccount Button
    And verify Result is displayed
    Then log Out Button  click
    And Close the browser

  Examples:
    | firstname  | lastname  | email                | password  |  gender |  company |
    | Jonida     | Selfaj    | jonida3007@gmail.com | jonida123 |    F    |  lhind   |

  Scenario Outline: Login functionality
    Given Browser is open in CommercialPage
    And click in LoginButton and enter email <email> and password <password>
    When we verify loginPage
    Then Log out button should exist
    And Close the browser

  Examples:
    | email                | password  |
    | jonida3007@gmail.com | jonida123 |

  Scenario Outline: MyAccountTest functionality
    Given Browser is open in CommercialPage
    And click in LoginButton and enter email <email> and password <password>
    And click to myAccount button and check the title
    And verify gender <gender>
    And verify selected birthDay "24",selected birthMonth "June" and selected birthYear "1996"
    And verify firstName <firstname> , lastname <lastname> and email <email>
    And verify companyName <company>
    Then log Out Button  click
    And Close the browser

  Examples:
    | firstname  | lastname  | email                | password  |  gender |  company |
    | Jonida     | Selfaj    | jonida3007@gmail.com | jonida123 |    F    |  lhind   |
    
  Scenario Outline: Dashboard functionality

    Given Browser is open in CommercialPage
    And click in LoginButton and enter email <email> and password <password>
    And hover ComputerMenu  and click Notebook
    And check title of web page , display size "9" and check item displayed of webpage "6"
    And check the Memory "16 GB"
    And check item Displayed "1" and check Memory "16 GB"
    And add Item to shoppingCart "4", "5", "6"
    And add Item to wishList "2","3"
    And check Qty cart "3" and check Qty wishlist "2"
    And Close the browser
    
  Examples:
    | email                | password  |
    | jonida3007@gmail.com | jonida123 |

  Scenario Outline: ShoppingCart  functionality

    Given Browser is open in CommercialPage
    When click in LoginButton and enter email <email> and password <password>
    And hover ShoppingCartMenu  and verify goToCart Button
    And check title of web page
    And verify if the buttons are Displayed
    And check the subTotal price of items
    And Close the browser
  
  Examples:
  | email                | password  |
  | jonida3007@gmail.com | jonida123 |
    
  Scenario Outline: RemoveItems  functionality

    Given Browser is open in CommercialPage
    When click in LoginButton and enter email <email> and password <password>
    And remove items from shoppingCart
    Then log Out Button  click
    And Close the browser

  Examples:
    | email                | password  |
    | jonida3007@gmail.com | jonida123 |




