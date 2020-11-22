package com.it;

import org.openqa.selenium.By;

public class Login extends TestCode {
    String xpathToEmailField = "//*[@id=\"login-form\"]/section/div[1]/div[1]/input";
    String xpathToPasswordField = "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input";
    protected void GoToLoginPage()
    {
        driver.get("http://40.76.27.113:8085/en/login?back=my-account");
    }

    protected void EmailFieldClick()
    {
        findElementsByxPath(xpathToEmailField,"click","");
    }

    protected void EmailFieldSendKeys(String username)
    {
        findElementsByxPath(xpathToEmailField,"sendKeys",username);
    }
    protected void PasswordFieldClick()
    {
        findElementsByxPath(xpathToPasswordField,"click","");
    }
    protected void PasswordFieldSendKeys(String password)
    {
        findElementsByxPath(xpathToPasswordField,"sendKeys",password);
    }
    protected void SignInButtonClick()
    {
        String signInButtonID = "submit-login";
        findElementsById(signInButtonID,"click","");
    }
    protected void SignOutButtonClick()
    {
        findElementsByxPath("//*[@id=\"_desktop_user_info\"]/div/a[1]","click","");
    }
    protected void ShowButtonClick()
    {
        String xpathToShowPasswordButton = "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/span/button";

        findElementsByxPath(xpathToShowPasswordButton,"click","");
    }

    protected String GetHeaderOnMyAccountPage()
    {
        String header = driver.findElement(By.xpath("//*[@id=\"main\"]/header/h1")).getText();

        return header;
    }

    protected String GetSignInButtonText()
    {
        String signInButtonText = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[1]")).getText();

        return signInButtonText;
    }

    protected String GetAuthenticationText()
    {
      String authenticationText = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/ul/li")).getText();

      return authenticationText;
    }

    //Gets the text in hide/show password button at login page
    protected String GetHideButtonText()
    {
       String hideButtonText = driver.findElement(By.xpath("//*[@id=\"login-form\"]/section/div[2]/div[1]/div/span/button")).getText();

       return hideButtonText;
    }
}
