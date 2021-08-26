Feature: Adding discounted perfumes 
  I want to be able to add the perfumes with discount

  
  Scenario: Add the perfumes with percentage discounts to the cart
    Given User is on omorny website
    And user will choose women fragrances from fragrances menu
    When user add all perfumes with percentage discounts in first five pages
    Then make sure that the total cost