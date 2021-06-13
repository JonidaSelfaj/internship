package test;

import internship.driver.Driver;
import internship.driver.DriverOption;
import internship.global.GlobalVariables;
import internship.steps.RegisterPageSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {

    @BeforeMethod
    public void before(){
        Driver.start(DriverOption.CHROME);
    }

    @Test
    public void execute() {
        Driver.go(GlobalVariables.APP_URL);
        RegisterPageSteps register = new RegisterPageSteps();
        register.loginClick();
        System.out.println("titulli i faqes pasi klikuam buttonin Login ne Menu bar eshte :"+Driver.getTitle());
        register.checkWelcomeLabel();
        register.registerClick();
        System.out.println("titulli i faqes pasi klikuam buttonin Register eshte :"+Driver.getTitle());
        register.radioButtonGenderClick(GlobalVariables.GENDER);
        register.fieldFirstName(GlobalVariables.FIRSTNAME);
        register.fieldLastName(GlobalVariables.LASTNAME);
        register.selectDay(GlobalVariables.BIRTH_DAY);
        register.selectMonth(GlobalVariables.BIRTH_MONTH);
        register.selectYear(GlobalVariables.BIRTH_YEAR);
        register.fieldEmail(GlobalVariables.EMAIL);
        register.fieldCompany(GlobalVariables.COMPANY_NAME);
        register.newsCheck();
        register.fieldPass(GlobalVariables.PASSWORD);
        register.fieldConfirmPass(GlobalVariables.PASSWORD);
        register.registerAccountClick();
        register.verifyResult();
        register.logOutClick();
    }

    @AfterMethod
    public void after() {
        Driver.close();
    }
}
