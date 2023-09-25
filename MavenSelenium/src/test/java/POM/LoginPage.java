package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*
* driver.findElement(By.name("username")).sendKeys("Admin");

        driver.findElement(By.name("password")).sendKeys("admin123");

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        Thread.sleep(5000);*/
public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    By txtUserName =By.name("username");
    By txtPassword = By.name("password");
    By imgLogo = By.xpath("//img[@alt='company-branding']");
    By loginBtn= By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");

    public void setUserName(String username){
        driver.findElement(txtUserName).sendKeys(username);
    }
    public void setPassWord(String passWord){
        driver.findElement(txtPassword).sendKeys(passWord);
    }
    public void ClickLoginButton(){
        driver.findElement(loginBtn).click();
    }
    public boolean verifyLogoPresence(){
        boolean logoStatus = driver.findElement(imgLogo).isDisplayed();
        return logoStatus;
    }

}
