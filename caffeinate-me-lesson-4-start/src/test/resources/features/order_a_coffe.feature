Feature: Order a coffee

  In order to save time when I pick up my morning coffee
  As a coffee lover
  I want to be able to order my coffee in advance

  Scenario: Buyer order a coffee when they are close to the coffee shop
    Given Cathy is 200 metres from the coffee shop
    When Cathy has ordered a large cappuccino
    Then Barry should receive the order
    And Barry should know that the coffee is Urgent