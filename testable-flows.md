(Add your list of flows here)

1) When user visits the application main page, they can see "Get Github Repos" as the page header's value.
2) When user visits the application main page, they can see a form that consists of the following elements:
   * A label field with text "Github Username" 
   * An input text field for entering the Github user name.
   * An action button with the caption "Go".
3) When user enters a value in the "Github Username" text field, they can submit it by performing either of the following actions:
   * Clicking on the "Go" button
   * Pressing the "Enter" key
4) When user submits a valid Github user name in the "Github Username" field, then:
   * An information text indicating that the user was successfully found is displayed for a short amount of time.
5) When user submits a valid Github user name and there are repositories under the found Github user account, a list of the available repos is displayed.
     * Each row contains a column for the name of the repo and another for its description
     * In case of missing description, "-" is displayed instead.
   * If there are no repos under the user's account, the text "No Repos" is displayed indicating empty account.
6) When user clicks on any of the repositories found under the Github user's account, they will be taken to the corresponding repo url in github.com
7) When user submits a non-existent Github user in the "Github Username" field, an error message indicating that the user has not been found is displayed for a short amount of time.
8) When user submits any other invalid input besides non-existent users, a generic error message is displayed for a short amount of time.
