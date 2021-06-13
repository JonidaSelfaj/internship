package test;

import internship.driver.Driver;
import internship.driver.DriverOption;
import internship.global.GlobalVariables;
import internship.steps.LoginPageSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    @BeforeMethod
    public void before(){
        Driver.start(DriverOption.CHROME);
    }

    @Test
    public void execute() {
        Driver.go(GlobalVariables.APP_URL);
        LoginPageSteps login = new LoginPageSteps();
        login.loginClick();
        login.login(GlobalVariables.EMAIL, GlobalVariables.PASSWORD);
        login.verifyLogIn();
        login.verifyLogOut();
    }

    @AfterMethod
    public void after() {
        Driver.close();
    }
}
