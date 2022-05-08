$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/userStory.feature");
formatter.feature({
  "name": "Get num of blog posts for a user",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Get unique ids of posts",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.step({
  "name": "User goes to the end url",
  "keyword": "When "
});
formatter.match({
  "location": "count_posts_steps.user_goes_to_the_end_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify each post has unique id",
  "keyword": "Then "
});
formatter.match({
  "location": "count_posts_steps.verifyEachPostHasUniqueId()"
});
formatter.result({
  "status": "passed"
});
});