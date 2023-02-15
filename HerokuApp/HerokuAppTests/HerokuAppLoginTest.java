package HerokuApp.HerokuAppTests;

import HerokuApp.HerokuAppBase.HerokuAppBaseTest;
import HerokuApp.HerokuAppPages.HerokuAppLoginPage;
import HerokuApp.HerokuAppPages.HerokuAppLogoutPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuAppLoginTest extends HerokuAppBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(LoginURL);
        herokuAppLoginPage = new HerokuAppLoginPage();
        herokuAppLogoutPage = new HerokuAppLogoutPage();

    }

    @Test (priority = 10)
    public void userCanLogIn() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLogoutPage.getNotificationText(), "You logged into a secure area!\n" + "×");
    }
    @Test(priority = 20)
    public void userCannotLogInInvalidUsernameAllUppercaseLetters (){
        String invalidUsername = excelReader.getStringData("login", 1,2);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        herokuAppLoginPage.insertUsername(invalidUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
//        System.out.println(herokuAppLoginPage.getErrorMessageText());
        Assert.assertEquals(herokuAppLoginPage.getErrorMessageText(),"Your username is invalid!\n" +
                "×");
    }
    @Test
    public void userCannotLogInInvalidUsernameSpaceSeparation(){
        String invalidUsername = excelReader.getStringData("login", 2,2);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        herokuAppLoginPage.insertUsername(invalidUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorMessageText(),"Your username is invalid!\n" +
                "×");

    }
    @Test
    public void userCannotLogInInvalidUsernameFirstLetterUppercase (){
        String invalidUsername = excelReader.getStringData("login", 3,2);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        herokuAppLoginPage.insertUsername(invalidUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorMessageText(),"Your username is invalid!\n" +
                "×");

    }
    @Test
    public void userCannotLogInInvalidUsernameNumberIncluded (){
        String invalidUsername = excelReader.getStringData("login", 4,2);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        herokuAppLoginPage.insertUsername(invalidUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorMessageText(),"Your username is invalid!\n" +
                "×");
    }
    @Test
    public void  userCannotLogInInvalidUsernameSpecialCharacterIncluded (){
        String invalidUsername = excelReader.getStringData("login", 5,2);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        herokuAppLoginPage.insertUsername(invalidUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorMessageText(),"Your username is invalid!\n" +
                "×");

    }

    @Test
    public void  userCannotLogInInvalidPasswordAllUppercaseLetters () {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String invalidPassword = excelReader.getStringData("Login", 1, 3);
        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(invalidPassword);
        herokuAppLoginPage.clickOnLogInButton();
//        System.out.println(herokuAppLoginPage.getErrorMessageText());
        Assert.assertEquals(herokuAppLoginPage.getErrorMessageText(),"Your password is invalid!\n" +
                "×");

    }
    @Test
    public void  userCannotLogInInvalidPasswordSpaceSeparation (){
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String invalidPassword = excelReader.getStringData("Login", 2, 3);
        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(invalidPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorMessageText(),"Your password is invalid!\n" +
                "×");

    }
    @Test
    public void userCannotLogInInvalidPasswordFirstLetterUppercase (){
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String invalidPassword = excelReader.getStringData("Login", 3, 3);
        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(invalidPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorMessageText(),"Your password is invalid!\n" +
                "×");

    }
    @Test
    public void userCannotLogInInvalidPasswordNumberIncluded (){
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String invalidPassword = excelReader.getStringData("Login", 4, 3);
        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(invalidPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorMessageText(),"Your password is invalid!\n" +
                "×");
    }
    @Test
    public void  userCannotLogInInvalidPasswordNoExclamationSign (){
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String invalidPassword = excelReader.getStringData("Login", 5, 3);
        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(invalidPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorMessageText(),"Your password is invalid!\n" +
                "×");
    }
    @Test
    public void  userCannotLogInInvalidCredentials (){
        String invalidUsername = excelReader.getStringData("Login",1,2);
        String invalidPassword = excelReader.getStringData("Login", 5, 3);
        herokuAppLoginPage.insertUsername(invalidUsername);
        herokuAppLoginPage.inserPassword(invalidPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorMessageText(),"Your username is invalid!\n" +
                "×");
    }

    @Test
    public void userCannotLogInEmptyUsernameAndPasswordField (){
        herokuAppLoginPage.emptyUsername();
        herokuAppLoginPage.emptyPassword();
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorMessageText(),"Your username is invalid!\n" +
                "×");
    }

    @Test
    public void userCannotLogInEmptyUsernameField (){
        String validPassword = excelReader.getStringData("Login", 1, 1);
        herokuAppLoginPage.emptyUsername();
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorMessageText(),"Your username is invalid!\n" +
                "×");

    }
    @Test
    public void userCannotLogInEmptyPasswordField (){
        String validUsername = excelReader.getStringData("Login", 1, 0);
        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.emptyPassword();
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getErrorMessageText(),"Your password is invalid!\n" +
                "×");

    }
}
