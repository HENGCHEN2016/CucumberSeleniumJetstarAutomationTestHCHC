$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Buy a ticket on JetStart Website and login in",
  "description": "",
  "id": "buy-a-ticket-on-jetstart-website-and-login-in",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Buy a one way ticket whose destination is Christchurch",
  "description": "",
  "id": "buy-a-ticket-on-jetstart-website-and-login-in;buy-a-one-way-ticket-whose-destination-is-christchurch",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I open the JetStart website",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I choose a destination \"Christchurch\"",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I want buy a one way ticket and choose date",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I select flight time",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I have no bundle and baggage",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I dont mind where i sit and dont book hotel",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I log in and enter the right username and password",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "I should get login_in",
  "keyword": "Then "
});
formatter.match({
  "location": "WebAutomationSteps.i_open_the_JetStart_website()"
});
formatter.result({
  "duration": 16395367802,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Christchurch",
      "offset": 24
    }
  ],
  "location": "WebAutomationSteps.i_choose_a_destination(String)"
});
formatter.result({
  "duration": 22635112609,
  "status": "passed"
});
formatter.match({
  "location": "WebAutomationSteps.i_want_buy_a_one_way_ticket_and_choose_date()"
});
formatter.result({
  "duration": 4581137172,
  "status": "passed"
});
formatter.match({
  "location": "WebAutomationSteps.i_select_flight_time()"
});
formatter.result({
  "duration": 28268188339,
  "status": "passed"
});
formatter.match({
  "location": "WebAutomationSteps.i_have_no_bundle_and_baggage()"
});
formatter.result({
  "duration": 19308404344,
  "status": "passed"
});
formatter.match({
  "location": "WebAutomationSteps.i_dont_mind_where_i_sit_and_dont_book_hotel()"
});
formatter.result({
  "duration": 17027110650,
  "status": "passed"
});
formatter.match({
  "location": "WebAutomationSteps.i_log_in_and_enter_the_right_username_and_password()"
});
formatter.result({
  "duration": 17032108609,
  "status": "passed"
});
formatter.match({
  "location": "WebAutomationSteps.i_should_get_login_in()"
});
formatter.result({
  "duration": 76045,
  "status": "passed"
});
});