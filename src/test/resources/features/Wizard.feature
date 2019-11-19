
Feature: Test Cornershop

 Scenario: Create an account
   Given Open Browser and navigate to "https://web.cornershopapp.com/"
   When Click on "SignUP" button
   And Complete the form and submit
   |key|value|
   | email | bart.token2@gmail.com |
   | name  | Testing              |
   |lastName | Mister             |
   | password | 123Momia_es       |
   Then Validate message "We have sent you an email"
  @tag
 Scenario: Create a new Address
   Given Open Browser and navigate to "https://web.cornershopapp.com/accounts/login/"
   When Click on "LogIn" button
   And put "criarave@gmail.com" and "T0k3n123" to login
   And Dismiss starter tutorial
   And Add a new Address
   | key | value |
   | name | Casa |
   | AddressType | Casa |
   | StreetAddress | qweasdasdasd |
   | city          | Santiago     |
   | locality      | a            |
   | country       | b            |





