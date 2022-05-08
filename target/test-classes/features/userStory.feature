Feature: Get num of blog posts for a user

  Scenario: Counting posts for user
    Given User goes to the end url
    When User enters user "7"
    Then User verifies number of posts


  @wip
  Scenario: Get unique ids of posts
    When User goes to the end url
    Then Verify each post has unique id


