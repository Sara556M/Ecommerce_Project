import Pages.P01_Login;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class addProduct {

    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testJson;
    SHAFT.TestData.EXCEL testExcel;

    @Test(description = "login then add products then verify")
    public void AddProduct() {
        new P01_Login(driver).login(testExcel.getCellData("mail"),testExcel.getCellData("password"))
                .navigateToProducts().addProducts().viewCart();


    }


    @BeforeClass
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver();
        testJson = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData() + "testData.json");
        testExcel = new SHAFT.TestData.EXCEL(SHAFT.Properties.paths.testData() + "testData.xlsx");
        driver.browser().navigateToURL("https://automationexercise.com/login");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
