package stepdefinitions;

import factory.BaseClass;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import utilities.DataReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginStepDefinitions {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    List<HashMap<String, String>> datamap; //Data driven


    @Given("the user is on the OpenCart login page")
    public void the_user_is_on_the_open_cart_login_page() {
        //BaseClass.getLogger().info("Initializing the browser and navigating to the OpenCart login page");
        homePage = new HomePage(BaseClass.getDriver());
        homePage.clickMyAccount();
        homePage.clickLogin();
        //BaseClass.getLogger().info("Navigated to the login page");
    }

    @When("the user enters a valid credentials")
    public void the_user_enters_valid_credentials() throws IOException {
        String email = BaseClass.getProperties().getProperty("email");
        String pwd = BaseClass.getProperties().getProperty("password");
        loginPage = new LoginPage(BaseClass.getDriver());
        loginPage.setEmail(email);
        loginPage.setPassword(pwd);
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        //BaseClass.getLogger().info("Clicking the login button");
        loginPage.clickLogin();
    }

    @Then("the user should be redirected to the account page")
    public void the_user_should_be_redirected_to_the_account_page() {
        //BaseClass.getLogger().info("Verifying if the user is redirected to the account page");
        myAccountPage = new MyAccountPage(BaseClass.getDriver());
        Assertions.assertTrue(myAccountPage.isMyAccountPageExists());
        //BaseClass.getLogger().info("User is successfully redirected to the account page");
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersAnd(String user, String pwd) {
        //BaseClass.getLogger().info("Entering user credentials: " + user + " and password: " + pwd);
        loginPage = new LoginPage(BaseClass.getDriver());
        loginPage.setEmail(user);
        loginPage.setPassword(pwd);
    }

    /*******   Data Driven test **************/
    @Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows) throws IOException {
        datamap = DataReader.data(System.getProperty("user.dir") + "/testData/Opencart_LoginData.xlsx", "Sheet1");

        int index = Integer.parseInt(rows) - 1;
        String email = datamap.get(index).get("username");
        String pwd = datamap.get(index).get("password");
        String exp_res = datamap.get(index).get("res");

        loginPage = new LoginPage(BaseClass.getDriver());
        loginPage.setEmail(email);
        loginPage.setPassword(pwd);

        loginPage.clickLogin();
        myAccountPage = new MyAccountPage(BaseClass.getDriver());
        try {
            boolean targetpage = myAccountPage.isMyAccountPageExists();
            System.out.println("target page: " + targetpage);
            if (exp_res.equals("Valid")) {
                if (targetpage == true) {
                    MyAccountPage myaccpage = new MyAccountPage(BaseClass.getDriver());
                    myaccpage.clickLogout();
                    Assertions.assertTrue(true);
                } else {
                    Assertions.assertTrue(false);
                }
            }

            if (exp_res.equals("Invalid")) {
                if (targetpage == true) {
                    myAccountPage.clickLogout();
                    Assertions.assertTrue(false);
                } else {
                    Assertions.assertTrue(true);
                }
            }

        } catch (Exception e) {
            Assertions.fail();
        }
    }

}
