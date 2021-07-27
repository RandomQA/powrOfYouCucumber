@search @EndToEnd

Feature:System should allow any user to make some product search

  @TC01
  Scenario:TC01 Making product search
    Given User goes to the HomePage
    When User login to the Account.
    Then User User write search term "best baby sunscreen" to the search textbox.
    And User Select the first item that shows up.
    And User Clicks add to cart.
    Then User Select view Cart.
    Then User Select Checkout Cart.

    @TC01
    Scenario: TC02 Installing Chrome GoFullPage Extension.
      When User open a browser and install the GoFullPage Extension.

