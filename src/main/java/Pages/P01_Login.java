package Pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P01_Login {
    SHAFT.GUI.WebDriver driver;



    //Constructor
    public P01_Login (SHAFT.GUI.WebDriver driver)
    {
        this.driver =driver;
    }

    //Locators
    By mailInput =By.xpath("//input[@data-qa=\"login-email\"]");
    By passwordInput =By.xpath("//input[@data-qa=\"login-password\"]");
    By loginButton =By.xpath("//button[@data-qa=\"login-button\"]");

    //Methods
    @Step("Login to website")
    public P02_HomePage login(String mail ,String password)
    {
        driver.element().type(mailInput ,mail).
                type(passwordInput,password)
                .click(loginButton);
        return new P02_HomePage(driver);
    }
}
