@searchBookFeature
Feature: SearchBook

  @searchQaEngineerBook
  Scenario: Search qa engineer book at demo qa
    Given User go to "Books"
    When User in “Book Store” page
    And User search book “qa engineer”
    Then User see “No rows found”

  @searchGitPocketGuideBook
  Scenario: Search book at demo qa
    Given User go to "Books"
    When User in “Book Store” page
    And User search book “Git Pocket Guide”
    And User click book “Git Pocket Guide”
    Then User see “Git Pocket Guide”