package stepdefinitions;

import factory.BaseClass;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

public class LoginStepDefinitions {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;


    @Given("the user is on the OpenCart login page")
    public void the_user_is_on_the_open_cart_login_page() {
        BaseClass.getLogger().info("Initializing the browser and navigating to the OpenCart login page");
        homePage = new HomePage(BaseClass.getDriver());
        homePage.clickMyAccount();
        homePage.clickLogin();
        BaseClass.getLogger().info("Navigated to the login page");
    }

    @When("the user enters a valid credentials\\(email: {string}, password: {string})")
    public void the_user_enters_a_valid_credentials(String email, String pwd) {
        BaseClass.getLogger().info("Entering valid credentials: Email - " + email + ", Password - " + pwd);
        loginPage = new LoginPage(BaseClass.getDriver());
        loginPage.setEmail(email);
        loginPage.setPassword(pwd);
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        BaseClass.getLogger().info("Clicking the login button");
        loginPage.clickLogin();
    }

    @Then("the user should be redirected to the account page")
    public void the_user_should_be_redirected_to_the_account_page() {
        BaseClass.getLogger().info("Verifying if the user is redirected to the account page");
        myAccountPage = new MyAccountPage(BaseClass.getDriver());
        Assertions.assertTrue(myAccountPage.isMyAccountPageExists());
        BaseClass.getLogger().info("User is successfully redirected to the account page");
    }

}
