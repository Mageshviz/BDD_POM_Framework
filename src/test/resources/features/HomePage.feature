Feature: Home Page Interaction

  Background:
    Given I am on the demo qa homepage

  Scenario Outline: Validate the card click landing page
    When I click on the <cardName>
    Then I should be navigated to the <cardName> page

  Examples:
    | cardName   |
    | "Elements" |

