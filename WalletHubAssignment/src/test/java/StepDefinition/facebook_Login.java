package StepDefinition;

import com.facebook.Pages.facebookLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class facebook_Login {
    facebookLoginPage loginPage= new facebookLoginPage();
    @Given("user navigates to Facebook")
    public void userNavigatesToFacebook() {
        loginPage.launchLoginPage();
    }

    @When("I enter Username as {string} and Password as {string}")
    public void iEnterUsernameAsAndPasswordAs(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOcLoginButton();
    }

    @Then("user is able to login and show Hello world")
    public void userIsAbleToLoginAndShowHelloWorld() {
        System.out.println("Hello world");
    }
}
