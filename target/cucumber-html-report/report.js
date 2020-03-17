$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/createGist.feature");
formatter.feature({
  "name": "Create gist",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Create gist",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I have a token",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I add a new gist with files",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "The gist with the files is created",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("file:src/test/java/features/readyGists.feature");
formatter.feature({
  "name": "List gists",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "List gists for a user",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I have an user",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.ListGistsSteps.iHaveAnUser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get a gists list for the user",
  "keyword": "When "
});
formatter.match({
  "location": "steps.ListGistsSteps.iGetAGistsListForTheUser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "All public gists for the user are list",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.ListGistsSteps.allPublicGistsForTheUserAreList()"
});
formatter.result({
  "status": "passed"
});
});