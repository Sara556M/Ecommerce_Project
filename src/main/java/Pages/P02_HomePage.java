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
    public void navigateToProducts()
    {
        driver.element().click(menListButton).click(tshirtsButton);

    }

}
