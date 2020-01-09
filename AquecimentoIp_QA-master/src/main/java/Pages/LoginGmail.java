package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginGmail extends BasePage{
    public LoginGmail(WebDriver driver) {
        super( driver );
    }

    //Tempo de espera do elemento em tela
    WebDriverWait espera = new WebDriverWait(driver, 20);


    //Mapear os elementos
    WebElement campoLogin = espera.until( ExpectedConditions.elementToBeClickable( By.id("identifierId")));
    WebElement btnProximo = espera.until( ExpectedConditions.elementToBeClickable( By.id("identifierNext")));

    public void acessarEmail(String email, String senha){

        campoLogin.click();
        campoLogin.sendKeys( email );
        btnProximo.click();
        WebElement campoPassword = espera.until( ExpectedConditions.elementToBeClickable( By.name("password")));


        campoPassword.click();
        campoPassword.sendKeys( senha );

        WebElement btnPassword = espera.until( ExpectedConditions.elementToBeClickable( By.id("passwordNext")));
        btnPassword.click();

    }

}

