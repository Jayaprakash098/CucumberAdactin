$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:adactin.feature");
formatter.feature({
  "name": "To Automate Adactin hotel booking",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "To generate order no in adactin hotel page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User must be in adactin hotel booking page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.user_must_be_in_adactin_hotel_booking_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Login using valid username and password",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.user_Login_using_valid_username_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enter booking details",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinition.user_enter_booking_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User must click selected hotel",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.user_must_click_selected_hotel()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User must enter card details for payment",
  "rows": [
    {
      "cells": [
        "key",
        "value"
      ]
    },
    {
      "cells": [
        "first name",
        "jayaprakash"
      ]
    },
    {
      "cells": [
        "last name",
        "baskaran"
      ]
    },
    {
      "cells": [
        "address",
        "chennai,india"
      ]
    },
    {
      "cells": [
        "card no",
        "1564812567858546"
      ]
    },
    {
      "cells": [
        "cvv no",
        "584"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.user_must_enter_card_details_for_payment(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check whether the order No is generated",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.check_whether_the_order_No_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To high light the order No",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.to_high_light_the_order_No()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});