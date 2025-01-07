package Pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_ProductPage {
    SHAFT.GUI.WebDriver driver;

    //Constructor
    public P03_ProductPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By productsCard = By.xpath("//div[@class=\"productinfo text-center\"]");
    By continueShoppingButton = By.xpath("//button[@data-dismiss=\"modal\"]");
    By cart = By.xpath("(//a[@href=\"/view_cart\"])[1]");

    //Methods
    @Step("add products less than 100")
    public P03_ProductPage addProducts() {
        List<WebElement> products = driver.getDriver().findElements(productsCard);
        System.out.println("size is : "+products.size());
        for (int i = 0; i < products.size(); i++)
            try {
                {
                    if(i==7){
                        break;
                    }
                    int productPrice = Integer.parseInt(driver.getDriver().findElement(By.xpath("(//div[@class=\"productinfo text-center\"]//h2)["+(i+1)+"]")).getText().replaceAll("[^0-9]", ""));
                    System.out.println("Price of product "+ (i + 1)+" : " + productPrice);
                    if (productPrice < 1000) {
                        driver.element().click(By.xpath("(//div[@class=\"productinfo text-center\"])["+(i + 1)+"]/a"))
                                .click(continueShoppingButton);
                        System.out.println("Added product with price " + productPrice + " to the cart");
                    }
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);

            }
        return this;
    }
    @Step("Go to cart to verify added producys")
    public void viewCart()
    {
        driver.element().scrollToElement(cart).click(cart)
                .and().browser().captureScreenshot();
    }

}