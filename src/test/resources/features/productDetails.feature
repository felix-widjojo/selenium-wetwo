Feature: Redirect to Product Details Page from Order Form Page

  Scenario: Successful redirect to Product Details Page from Order Form Page
    Given User on Location List Page
    When User click "Bomboloni Maestro" location
    And User click "Caramel Latte Large" Add Button at Product List Page
    And User click "Caramel Latte Large" Plus Button at Product List Page
    And User click Cart button
    And User see "Caramel Latte Large" with the quantity added
    And User click Minus button at "Caramel Latte Large"
    And User click Product Image at "Caramel Latte Large"
    Then User redirect to Product Details Page of "Caramel Latte Large"