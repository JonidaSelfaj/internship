Feature: CommercialFeature

  Scenario: Register functionality

    Given Browser is open in CommercialPage
    And You click login Button and  click register Button
    And you select gender "F"
    And you enter "Jonida" in firstName Field and  lastName Field "Selfaj"
    And you select "24" as birthDay
    And you select "June" as birthMonth
    And you select "1996" as birthYear
    And you enter "joni2011@gmail.com" in email Field and companyName Field "lhind"
    And you enter "jonida123" in password Field and confirmPass Field "jonida123"
    When You click registerAccount Button
    And verify Result is displayed
    Then log Out Button  click
    And Close the browser

  Scenario: Login functionality

    Given Browser is open in CommercialPage
    And You enter email "joni2011@gmail.com" and password "jonida123"
    When we verify loginPage
    Then Log out button should exist
    And Close the browser

  Scenario: MyAccountTest functionality

    Given Browser is open in CommercialPage
    And click in LoginButton and enter email "joni2011@gmail.com" and password "jonida123"
    And click to myAccount button and check the title
    And verify gender "F"
    And verify selected birthDay "24",selected birthMonth "June" and selected birthYear "1996"
    And verify firstName "Jonida" , lastname "Selfaj" and email "joni2011@gmail.com"
    And verify companyName "lhind"
    Then log Out Button  click
    And Close the browser

  Scenario: Dashboard functionality

    Given Browser is open in CommercialPage
    And click in LoginButton and enter email "joni2011@gmail.com" and password "jonida123"
    And hover ComputerMenu  and click Notebook
    And check title of web page , display size "9" and check item displayed of webpage "6"
    And check the Memory "16 GB"
    And check item Displayed "1" and check Memory "16 GB"
    And add Item to shoppingCart "4", "5", "6"
    And add Item to wishList "2","3"
    And check Qty cart "3" and check Qty wishlist "2"
    And Close the browser






