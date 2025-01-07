package Pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P02_HomePage {
    SHAFT.GUI.WebDriver driver;

    //Constructor
    public P02_HomePage (SHAFT.GUI.WebDriver driver)
    {
        this.driver =driver;
    }

    //Locators
    By menListButton =By.xpath("//a[@href=\"#Men\"]");
    By tshirtsButton =By.xpath("//a[contains(.,\"Tshirts \")]");


    //Methods
    @Step("Go to the main page")
    public P03_ProductPage navigateToProducts()
    {
        driver.element().click(menListButton).
                and().element().click(tshirtsButton);
        return new P03_ProductPage(driver);

    }

}
