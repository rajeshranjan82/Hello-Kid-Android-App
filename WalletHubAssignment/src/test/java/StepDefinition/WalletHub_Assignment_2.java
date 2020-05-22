package StepDefinition;

import com.wallethub.review.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WalletHub_Assignment_2 {

    wallethubLoginPage wallethubLoginPage= new wallethubLoginPage();
    review_Thanks_Page reviewthankspage= new review_Thanks_Page();

    @Given("User is logged in with {string} & {string}")
    public void userIsLoggedInWith(String username, String password) throws InterruptedException {

        wallethubLoginPage.launchLoginPage();
        wallethubLoginPage.login(username,password);

    }

    @When("light up first start when user hover the first start and click on fourth start")
    public void lightUpFirstStartWhenUserHoverTheFirstStartAndClickOnFourthStart() throws InterruptedException {

        wallethubLoginPage.select_star();

    }


    @And("select Health Insurance from dropdown on new page and submit your review")
    public void selectHealthInsuranceFromDropdownOnNewPageAndSubmitYourReview()  {
        wallethubLoginPage.dropdown_selection();
    }


    @Then("review submitted successfully and go to your profile page to confirm the review is submitted")
    public void reviewSubmittedSuccessfullyAndGoToYourProfilePageToConfirmTheReviewIsSubmitted() {

        reviewthankspage.profile_page_redirection();

    }
}
