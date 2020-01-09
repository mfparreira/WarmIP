package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AbriremailHotmail extends BasePage {
    public AbriremailHotmail(WebDriver driver) {
        super( driver );
    }

    //Tempo de espera do elemento em tela
    WebDriverWait espera = new WebDriverWait( driver,20 );


    public boolean verificarInboxHotmail() {

        boolean existeEmail = false;

        while (1 == 1) {


            List<WebElement> listElement2 = driver.findElements( By.cssSelector( "[title*='marcelinhoboladao555@gmail.com']" ) );

            System.out.println( listElement2.size() );

            if (listElement2.size() == 0) {

                break;
            } else {



                WebElement element = listElement2.get( 0 );

                if (element.getText().equals( "teste teste" )) //to click on a specific mail.
                {
                    existeEmail = true;
                    element.click();
                    WebElement EmailNF = espera.until( ExpectedConditions.elementToBeClickable( By.cssSelector( "[name*='alvo']" ) ) );
                    ((JavascriptExecutor) driver).executeScript( "arguments[0].click()",EmailNF );

                    List<String> abas = new ArrayList<>( driver.getWindowHandles() );
                    driver.switchTo().window( abas.get( 0 ) );



                        Actions actions = new Actions(driver);
                        WebElement lixoBtn = espera.until( ExpectedConditions.elementToBeClickable( (By.cssSelector( "[title*='marcelinhoboladao555@gmail.com']" ))));
                        actions.contextClick(lixoBtn).perform();

                        WebElement lixoBtn2 = espera.until( ExpectedConditions.elementToBeClickable( (By.name( "Excluir" ))));
                        lixoBtn2.click();



                    String validar = driver.findElement( By.className("screenReaderOnly")).getText();
                    try {
                        Assert.assertEquals( validar,"Painel de navegação" );

                    }
                    catch (Exception e){

                    }
                }
            }

        }
        return existeEmail;

    }

    public void verificarSpamHotmail () throws InterruptedException {



            driver.get( "https://outlook.live.com/mail/junkemail/" );

            while (1 == 1) {

                Thread.sleep( 5000 );
                List<WebElement> listElement2 = driver.findElements( By.cssSelector( "[title*='marcelinhoboladao555@gmail.com']"  ) );

                System.out.println( "spam-" + listElement2.size() );


                if (listElement2.size() == 0) {
                    System.out.println("Voce não tem esse e-mail");
                    break;

                } else {

                    WebElement element2 = listElement2.get(0 );
                    if (element2.getText().equals( "teste teste" )) {
                        element2.click();
                        Thread.sleep( 3000 );

                        Actions actions = new Actions( driver );
                        WebElement lixoBtn = espera.until( ExpectedConditions.elementToBeClickable( (By.cssSelector( "[title*='marcelinhoboladao555@gmail.com']" )) ) );
                        actions.contextClick( lixoBtn ).perform();

                        WebElement naoLixoEletronico = espera.until( ExpectedConditions.elementToBeClickable( By.name("Marcar como não é lixo eletrônico")));
                        naoLixoEletronico.click();
                    }

                }



        }

        driver.get( "https://outlook.live.com/mail/inbox" );
        driver.navigate().refresh();
        verificarInboxHotmail();


    }



}







