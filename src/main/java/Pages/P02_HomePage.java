package Pages;

import com.shaft.driver.SHAFT;
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
    public P03_ProductPage navigateToProducts()
    {
        driver.element().click(menListButton).click(tshirtsButton);
        return new P03_ProductPage(driver);

    }

}
