package stepdefinitions;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pageobjects.AccountRegistrationPage;
import pageobjects.HomePage;

import java.util.Map;

public class RegisterStepDefinitions {

    HomePage homePage;
    AccountRegistrationPage accountRegistrationPage;

    @Given("the user navigates to Register Account page")
    public void the_user_navigates_to_register_account_page() {
        homePage=new HomePage(BaseClass.getDriver());
        homePage.clickMyAccount();
        homePage.clickRegister();
    }

    @When("the user enters the details into below fields")
    public void the_user_enters_the_details_into_below_fields(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class,String.class);

        accountRegistrationPage = new AccountRegistrationPage(BaseClass.getDriver());
        accountRegistrationPage.setFirstName(dataMap.get("firstName"));
        accountRegistrationPage.setLastName(dataMap.get("lastName"));
        accountRegistrationPage.setEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
        accountRegistrationPage.setPassword(dataMap.get("password"));
    }

    @When("the user selects Privacy Policy")
    public void the_user_selects_privacy_policy() {
        accountRegistrationPage.setPrivacyPolicy();
    }

    @When("the user clicks on Continue button")
    public void the_user_clicks_on_continue_button() {
       accountRegistrationPage.clickContinue();
    }

    @Then("the user account should get created successfully")
    public void the_user_account_should_get_created_successfully() {
        Assertions.assertTrue(accountRegistrationPage.isConfirmationMessageDisplayed(),
                "Account creation failed: Confirmation message not displayed.");

    }
}
