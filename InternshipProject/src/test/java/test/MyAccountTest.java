package test;

import internship.driver.Driver;
import internship.driver.DriverOption;
import internship.global.GlobalVariables;
import internship.steps.LoginPageSteps;
import internship.steps.MyAccountPageSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTest {

    @BeforeMethod
    public void before() {
        Driver.start(DriverOption.CHROME);
    }

    @Test
    public void execute() {
        Driver.go(GlobalVariables.APP_URL);

        LoginPageSteps login = new LoginPageSteps();
        login.loginClick();
        login.login(GlobalVariables.EMAIL, GlobalVariables.PASSWORD);

        MyAccountPageSteps myAccount = new MyAccountPageSteps();
        myAccount.myAccountClick();
        myAccount.checkTitleAccount();
        myAccount.radioButtonGenderVerify(GlobalVariables.GENDER);
        myAccount.verifyBirthDay(GlobalVariables.BIRTH_DAY);
        myAccount.verifyBirthMonth(GlobalVariables.BIRTH_MONTH);
        myAccount.verifyBirthYear(GlobalVariables.BIRTH_YEAR);
        myAccount.verifyFirstName(GlobalVariables.FIRSTNAME);
        myAccount.verifyLastName(GlobalVariables.LASTNAME);
        myAccount.verifyEmail(GlobalVariables.EMAIL);
        myAccount.verifyCompany(GlobalVariables.COMPANY_NAME);

        login.verifyLogOut();
    }

    @AfterMethod
    public void after() {
        Driver.close();
    }
}
