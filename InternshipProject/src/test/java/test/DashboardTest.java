package test;

import internship.driver.Driver;
import internship.driver.DriverOption;
import internship.global.GlobalVariables;
import internship.steps.DashboardSteps;
import internship.steps.LoginPageSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest {

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

        DashboardSteps dashboard = new DashboardSteps();
        dashboard.hoverComputerMenu();
        dashboard.clickNoteBook();
        dashboard.checkTitle();
        dashboard.displaySize("9");
        dashboard.checkItemsDisplayed(6);
        dashboard.checkMemory("16 GB");
        dashboard.checkItemsDisplayed(1);
        dashboard.checkMemory("16 GB");
        dashboard.checkItemsDisplayed(6);
        dashboard.addItemToWishlist(2);
        dashboard.addItemToWishlist(3);
        dashboard.addItemToShoppingCart(4);
        dashboard.addItemToShoppingCart(5);
        dashboard.addItemToShoppingCart(6);
        dashboard.checkQtyWishList("2");
        dashboard.checkQtyCart("3");
    }

    @AfterMethod
    public void after() {
        Driver.close();
    }
}
