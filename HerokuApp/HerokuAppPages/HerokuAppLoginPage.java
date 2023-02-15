package HerokuApp.HerokuAppPages;

import HerokuApp.HerokuAppBase.HerokuAppBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppLoginPage extends HerokuAppBaseTest {
    public HerokuAppLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement Username;

    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(css = ".fa.fa-2x.fa-sign-in")
    public WebElement LogInButton;
    @FindBy(id="flash")
    public WebElement errorMessage;

    //----------------------

    public void insertUsername(String username) {
        Username.clear();
        Username.sendKeys(username);
    }

    public void inserPassword(String password) {
        Password.clear();
        Password.sendKeys(password);
    }
    public void emptyUsername() {
        Username.clear();
    }
    public void emptyPassword(){
        Password.clear();
    }


    public void clickOnLogInButton() {
        LogInButton.click();
    }
    public String getErrorMessageText (){
        return errorMessage.getText();
    }

}
