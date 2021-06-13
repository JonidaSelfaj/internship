package internship.steps;

import internship.driver.Driver;
import internship.page.ShopingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShoppingCartSteps {

    private ShopingCartPage shopingCartPage;
    private WebDriverWait driverWait = new WebDriverWait(Driver.getDriver(), 7);

    public ShoppingCartSteps() {
        this.shopingCartPage = new ShopingCartPage();
    }

    public void hoverShoppingCartMenu() {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(shopingCartPage.shoppingCart).perform();
    }

    public void verifyGoToCartButton() {
        if (shopingCartPage.goToCartBtn.isDisplayed()) {
            shopingCartPage.goToCartBtn.click();
        } else {
            System.out.println("Buttoni Go to Cart nuk eshte shfaqur");
        }
    }

    public void verifyTitle() {
        String currentTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(currentTitle, Driver.getTitle());
    }

    public void verifyButtonDisplayed() {
        Assert.assertTrue(shopingCartPage.updateShoppingCart.isDisplayed(), "Update Button is not displayed");
        Assert.assertTrue(shopingCartPage.continueShipping.isDisplayed(), "Continue Button is not displayed");
        Assert.assertTrue(shopingCartPage.estimateShoppingCart.isDisplayed(), "Estimate Button is not displayed");
    }

    public void sumSubTotalPrice() {
        String valueTotal = shopingCartPage.totalValue.getText().substring(1, shopingCartPage.totalValue.getText().length() - 1).replace(",", "");
        double valueTotalPrice = Double.parseDouble(valueTotal);

        double sum = 0;
        for (final WebElement element : shopingCartPage.subTotalPrice) {
            String value = element.getText().substring(1, element.getText().length() - 1).replace(",", "");
            double price = Double.parseDouble(value);
            sum = sum + price;
        }
        Assert.assertEquals(sum, valueTotalPrice);
    }

    public void removeItemToShoppingCart() {
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(ShopingCartPage.GO_TO_CART_BUTTON_CSS)));
        int size = shopingCartPage.deleteItem.size();
        while (size > 0) {
            shopingCartPage.deleteItem.get(0).click();
            size--;
            if (size > 0) {
                int actualSize = shopingCartPage.deleteItem.size();
                Assert.assertEquals(actualSize, size);
            }
        }
        Assert.assertEquals(size, 0);
    }
}
