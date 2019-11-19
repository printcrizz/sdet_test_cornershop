# Cornershop’s SDET Test

Cornershop has operations in several cities and countries, delivering thousands of orders every day. In order to deliver these orders on time we depend on good quality control tools and techniques.

In this technical test you will be creating a small suite of automated functional tests to ensure the Web version of our application performs as expected.

## Before you begin
You will need to create a private GitHub repository using the information that we provide in this README and invite as collaborators to: @sebagarate, @mgaleano, @omenar and @varellanov. In case you have any technical question, please contact mgaleano@cornershopapp.com, email subject: SDET-Test-Last Name.

## Aspects to be evaluated
* Documentation on how to run the tests (minimum)
* Code logic
* Programming style
* Use of Design Patterns
* Use of OOP concepts (we assume you will use an OOP language…)
* Test assertions
* Use of libraries or frameworks
* Code comments 
* Repository history

## Aspects to be ignored
Programming language used for this test. This mean, you can use any lenguage, but it is a plus if you use Python or  Java.

## Restrictions
The use of a test recorder is prohibited.

## The test
### Application under test
**Web application:** https://web.cornershopapp.com

### Test Cases
#### Create an account
##### Steps
1. Navigate to the site
2. Click on “Sign up” button
3. Complete the sign up form with valid data and submit it
	* Enter a valid email
	* Enter a Name
	* Enter a Last name
	* Enter a Password
	* Click on “Sign up” button

##### Expected result
A message should be present stating “We have sent you an email”. A second message should be present indicating extra instructions for the sign up process to be completed: “Click on the email that we just sent to <email-entered> to activate your account.”

#### Create a new address
##### Pre-conditions
Have an account of an existing user.
##### Steps
1. Navigate to the site
2. Click on “Log in” button
3. Login with a valid account
	* Enter an existing user email address
	* Enter its password
	* Click on “Log in”
	
4. Dismiss starter tutorial (this is shown only for new accounts with no address)
5. Complete the “Add address” form and submit it
	* Enter a name for the address
	* Select the address tupe
	* Enter the street address
	* Select a city, locality and country
	* Click on “Continue”
6. Click on “Save” in the “Adjust location” step

##### Expected result
The new address added should be shown at the top left corner next to a blue house icon.

#### Add items to the cart
##### Steps
1. Navigate to the site
2. Login with a valid account
3. Click on “Lider” store
4. Search for “coca cola light”
5. Click on the “Add” button in one of the following product cards:
	* Coca-Cola · Bebida light (Botella 591 ml)
	* Coca-Cola · Bebida light (Botella 1 L)
	* Any other product if the above are not present
6. Verify Cart product count badge is updated with the quantity added
7. Search for “palta”
8. Click on “Add” button of the first result
9. Click on “Cart” button
10. Store the order price to compare with the price in the Checkout step (step 14)
11. Click on “Go to checkout” 
12. Verify Promotions step is presented to the user
13. Click on “Next” button
14. Verify if the total is equal to the store order price (step 10)
15. Verify you have and can click on “Place order” button

##### Expected result
Order Price in Checkout step should be equal to the the price presented to the user in Cart step. “Place order” button should be present and clickable to submit the order.

#### Edit address
##### Pre-conditions
Have an account of a user with an address added.
##### Steps
1. Navigate to the site
2. Login with a valid account
3. Click on “Account” button at the top right corner in the header
4. In the opened modal, click on “Delivery” option
5. Click on the address to edit
6. Add or change the “Apartment” field to be “1010”
7. Click on “Continue” button
8. Click on “Save” in the “Adjust location” step

##### Expected result
“Delivery” modal should refresh and show the address updated, including “Suite 1010” for this case.

## Important note
Please if you face any issue while coding the test, please feel free to share with us. And any feedback too.


