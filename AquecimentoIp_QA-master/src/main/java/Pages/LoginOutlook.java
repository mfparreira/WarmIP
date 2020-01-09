package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginOutlook extends BasePage {
    public LoginOutlook(WebDriver driver) {
        super( driver );
    }

    //Tempo de espera do elemento em tela
    WebDriverWait espera = new WebDriverWait(driver, 20);

    WebElement BtnEntrarEmail = espera.until( ExpectedConditions.elementToBeClickable( By.className("officeHeaderMenu")));


    public void LoginOutlook(String emailOultook, String senhaOutlook){

        BtnEntrarEmail.click();

        WebElement emailOutlook = espera.until( ExpectedConditions.elementToBeClickable( By.id("i0116")));
        ((JavascriptExecutor) driver).executeScript( "arguments[0].click()",emailOutlook );
        emailOutlook.sendKeys( emailOultook );

        WebElement BtnProximo  = espera.until( ExpectedConditions.elementToBeClickable( By.id("idSIButton9")));
        ((JavascriptExecutor) driver).executeScript( "arguments[0].click()",BtnProximo );

        WebElement campoSenhaOutlook = espera.until( ExpectedConditions.elementToBeClickable( By.id("i0118")));
        ((JavascriptExecutor) driver).executeScript( "arguments[0].click()",campoSenhaOutlook );
        campoSenhaOutlook.sendKeys( senhaOutlook  );

        WebElement BtnEntrar = espera.until( ExpectedConditions.elementToBeClickable( By.id("idSIButton9")));
        ((JavascriptExecutor) driver).executeScript( "arguments[0].click()",BtnEntrar );


    }




}
