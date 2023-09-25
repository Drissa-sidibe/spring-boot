package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "//a[normalize-space()='Insurance Project']")
    WebElement insuranceProjectTab;
    @FindBy(xpath ="//a[normalize-space()='Register']" )
    WebElement registerBtn;
    public void setInsuranceProject(){
        insuranceProjectTab.click();
    }

}
