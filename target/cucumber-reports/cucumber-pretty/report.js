$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Wizard.feature");
formatter.feature({
  "line": 2,
  "name": "Test Cornershop",
  "description": "",
  "id": "test-cornershop",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3384733,
  "status": "passed"
});
formatter.before({
  "duration": 256019159,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Create a new Address",
  "description": "",
  "id": "test-cornershop;create-a-new-address",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 14,
      "name": "@tag"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "Open Browser and navigate to \"https://web.cornershopapp.com/accounts/login/\"",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "Click on \"LogIn\" button",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "put \"criarave@gmail.com\" and \"T0k3n123\" to login",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "Dismiss starter tutorial",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Add a new Address",
  "rows": [
    {
      "cells": [
        "key",
        "value"
      ],
      "line": 21
    },
    {
      "cells": [
        "name",
        "Casa"
      ],
      "line": 22
    },
    {
      "cells": [
        "AddressType",
        "Casa"
      ],
      "line": 23
    },
    {
      "cells": [
        "StreetAddress",
        "qweasdasdasd"
      ],
      "line": 24
    },
    {
      "cells": [
        "city",
        "Santiago"
      ],
      "line": 25
    },
    {
      "cells": [
        "locality",
        "a"
      ],
      "line": 26
    },
    {
      "cells": [
        "country",
        "b"
      ],
      "line": 27
    }
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "https://web.cornershopapp.com/accounts/login/",
      "offset": 30
    }
  ],
  "location": "StepDefinitions.OpenBrowserAndNavigate(String)"
});
formatter.result({
  "duration": 4289326303,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "LogIn",
      "offset": 10
    }
  ],
  "location": "StepDefinitions.clickButton(String)"
});
formatter.result({
  "duration": 8400335879,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "criarave@gmail.com",
      "offset": 5
    },
    {
      "val": "T0k3n123",
      "offset": 30
    }
  ],
  "location": "StepDefinitions.LogIn(String,String)"
});
formatter.result({
  "duration": 1933657025,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.DismissTutorial()"
});
formatter.result({
  "duration": 6528244553,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.AddAddress(DataTable)"
});
formatter.result({
  "duration": 3708025,
  "error_message": "java.lang.NoSuchMethodException: pageObjects.Address_po.name()\n\tat java.lang.Class.getMethod(Class.java:1786)\n\tat utils.SeleniumUtils.GetXpathByName(SeleniumUtils.java:128)\n\tat stepdefs.StepDefinitions.AddAddress(StepDefinitions.java:84)\n\tat ✽.And Add a new Address(Wizard.feature:20)\n",
  "status": "failed"
});
formatter.after({
  "duration": 15398,
  "status": "passed"
});
});