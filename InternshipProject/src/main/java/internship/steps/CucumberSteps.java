package internship.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import internship.driver.Driver;
import internship.driver.DriverOption;
import internship.global.GlobalVariables;
import internship.page.LoginPage;
import internship.page.MyAccountPage;
import internship.page.RegisterPage;


public class CucumberSteps {

    private RegisterPageSteps register;
    private RegisterPage registerPage;
    private LoginPageSteps login;
    private LoginPage loginPage;
    private MyAccountPageSteps pageSteps;
    private DashboardSteps dashboardSteps;

    @Given("^Browser is open in CommercialPage$")
    public void browser_is_open_in_CommercialPage() {
        Driver.start(DriverOption.CHROME);
        register = new RegisterPageSteps();
        registerPage = new RegisterPage();
        login = new LoginPageSteps();
        loginPage = new LoginPage();
        pageSteps = new MyAccountPageSteps();
        dashboardSteps = new DashboardSteps();
        Driver.go(GlobalVariables.APP_URL);
    }

    @And("^You click login Button and  click register Button$")
    public void you_click_login_Button_and_click_register_Button() {
        register.loginClick();
        register.registerClick();
    }

    @And("^you select gender \"([^\"]*)\"$")
    public void you_select_gender(final String gender) {
        register.radioButtonGenderClick(gender);
    }

    @And("^you enter \"([^\"]*)\" in firstName Field and  lastName Field \"([^\"]*)\"$")
    public void you_enter_in_firstName_Field_and_lastName_Field(final String firstName, final String lastName) {
        register.fieldFirstName(firstName);
        register.fieldLastName(lastName);
    }

    @And("^you select \"([^\"]*)\" as birthDay$")
    public void you_select_birthDay(final String birthday) {
        register.selectDay(birthday);
    }

    @And("^you select \"([^\"]*)\" as birthMonth$")
    public void you_select_birthMonth(final String birthMonth) {
        register.selectMonth(birthMonth);
    }

    @And("^you select \"([^\"]*)\" as birthYear$")
    public void you_select_birthYear(final String birthYear) {
        register.selectYear(birthYear);
    }

    @And("^you enter \"([^\"]*)\" in email Field and companyName Field \"([^\"]*)\"$")
    public void you_enter_in_email_Field_and_companyName_Field(final String email, final String company) {
        register.fieldEmail(email);
        register.fieldCompany(company);
    }

    @And("^you enter \"([^\"]*)\" in password Field and confirmPass Field \"([^\"]*)\"$")
    public void you_enter_in_password_Field_and_confirmPass_Field(final String password, final String confirmPass) {
        register.fieldPass(password);
        register.fieldConfirmPass(confirmPass);
    }

    @When("^You click registerAccount Button$")
    public void you_click_registerAccount_Button() {
        register.registerAccountClick();
    }

    @And("^verify Result is displayed$")
    public void verify_Result_is_displayed() {
        register.verifyResult();
    }

    @Then("^log Out Button  click$")
    public void log_Out_Button_click() {
        register.logOutClick();
    }

    @Given("^You enter email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void you_enter_email_and_password(final String email, final String password) {
        login.loginClick();
        login.login(email, password);
    }

    @When("^we verify loginPage$")
    public void we_verify_loginPage() {
        login.verifyLogIn();
    }

    @Then("^Log out button should exist$")
    public void log_out_button_should_exist() {
        login.verifyLogOut();
    }

    @And("^Close the browser$")
    public void Close_the_browser() {
        Driver.quit();
    }

    @And("^click in LoginButton and enter email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void click_in_LoginButton_and_enter_email_and_password(String email, String password) {
        login.loginClick();
        login.login(email, password);
    }

    @And("^click to myAccount button and check the title$")
    public void click_to_myAccount_button_and_check_the_title() {
        pageSteps.myAccountClick();
        pageSteps.checkTitleAccount();
    }

    @And("^verify gender \"([^\"]*)\"$")
    public void verify_gender(String gender) {
        pageSteps.radioButtonGenderVerify(gender);
    }

    @And("^verify selected birthDay \"([^\"]*)\",selected birthMonth \"([^\"]*)\" and selected birthYear \"([^\"]*)\"$")
    public void verify_selected_birthDay_selected_birthMonth_and_selected_birthYear(String birthDay, String birthMonth, String birthYear) {
        pageSteps.verifyBirthDay(birthDay);
        pageSteps.verifyBirthMonth(birthMonth);
        pageSteps.verifyBirthYear(birthYear);
    }

    @Given("^verify firstName \"([^\"]*)\" , lastname \"([^\"]*)\" and email \"([^\"]*)\"$")
    public void verify_firstName_lastname_and_email(String firstName, String lastName, String email) {
        pageSteps.verifyFirstName(firstName);
        pageSteps.verifyLastName(lastName);
        pageSteps.verifyEmail(email);
    }

    @And("^verify companyName \"([^\"]*)\"$")
    public void verify_companyName(String companyName) {
        pageSteps.verifyCompany(companyName);
    }

    @And("^hover ComputerMenu  and click Notebook$")
    public void hover_ComputerMenu_and_click_Notebook() {
        dashboardSteps.hoverComputerMenu();
        dashboardSteps.clickNoteBook();
    }

    @And("^check title of web page , display size \"([^\"]*)\" and check item displayed of webpage \"([^\"]*)\"$")
    public void check_title_of_web_page_display_size_and_check_item_displayed_of_webpage(String size, int itemsSize) {
        dashboardSteps.checkTitle();
        dashboardSteps.displaySize(size);
        dashboardSteps.checkItemsDisplayed(itemsSize);
    }

    @And("^check the Memory \"([^\"]*)\"$")
    public void check_the_Memory(String memory) {
        dashboardSteps.checkMemory(memory);
    }

    @And("^check item Displayed \"([^\"]*)\" and check Memory \"([^\"]*)\"$")
    public void check_item_Displayed_and_check_Memory(int item, String memory) {
        dashboardSteps.checkItemsDisplayed(item);
        dashboardSteps.checkMemory(memory);
    }

    @And("^add Item to shoppingCart \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void add_Item_to_shoppingCart(int item4, int item5, int item6) {
        dashboardSteps.addItemToShoppingCart(item4);
        dashboardSteps.addItemToShoppingCart(item5);
        dashboardSteps.addItemToShoppingCart(item6);
    }

    @And("^add Item to wishList \"([^\"]*)\",\"([^\"]*)\"$")
    public void add_Item_to_wishList(int item2, int item3) {
        dashboardSteps.addItemToWishlist(item2);
        dashboardSteps.addItemToWishlist(item3);
    }

    @And("^check Qty cart \"([^\"]*)\" and check Qty wishlist \"([^\"]*)\"$")
    public void check_Qty_cart_and_check_Qty_wishlist(String qtyCart, String qtyWish) {     dashboardSteps.checkQtyCart(qtyCart);
      dashboardSteps.checkQtyWishList(qtyWish);
    }

}


