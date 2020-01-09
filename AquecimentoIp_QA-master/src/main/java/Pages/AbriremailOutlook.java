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

public class AbriremailOutlook extends BasePage {
    public AbriremailOutlook(WebDriver driver) {
        super( driver );
    }

    //Tempo de espera do elemento em tela
    WebDriverWait espera = new WebDriverWait( driver,20 );
    boolean existeEmail = false;

    public void verificarInboxOutlook() throws InterruptedException {



        while (1 == 1 || existeEmail == false) {


            List<WebElement> listElement2 = driver.findElements( By.cssSelector( "[title*='marcelinhoboladao555@gmail.com']" ) );

            if (existeEmail == true){
                break;
            }


            System.out.println( listElement2.size() );

            if (listElement2.size() <= 0) {
                System.out.println( "Você não tem essa e-mail inbox" );
                verificarSpamOutlook();
                existeEmail = true ;
            } else {


                WebElement element = listElement2.get( 0 );

                if (element.getText().equals( "teste teste" )) //to click on a specific mail.
                {



                    element.click();
                    WebElement EmailNF = espera.until( ExpectedConditions.elementToBeClickable( By.cssSelector( "[name*='_alvo']" ) ) );
                    ((JavascriptExecutor) driver).executeScript( "arguments[0].click()",EmailNF );

                    List<String> abas = new ArrayList<>( driver.getWindowHandles() );
                    driver.switchTo().window( abas.get( 0 ) );


                    Actions actions = new Actions( driver );
                    WebElement lixoBtn = espera.until( ExpectedConditions.elementToBeClickable( (By.cssSelector( "[title*='marcelinhoboladao555@gmail.com']" )) ) );
                    actions.contextClick( lixoBtn ).perform();

                    WebElement lixoBtn2 = espera.until( ExpectedConditions.elementToBeClickable( (By.name( "Excluir" )) ) );
                    lixoBtn2.click();

                    Thread.sleep( 2000 );
                    excluirEmailOutlook();



                }
            }

        }


    }


    public void verificarSpamOutlook() throws InterruptedException {


        driver.get( "https://outlook.live.com/mail/junkemail/" );

        while (1 == 1) {

            Thread.sleep( 5000 );
            List<WebElement> listElement2 = driver.findElements( By.cssSelector( "[title*='marcelinhoboladao555@gmail.com']" ) );
            System.out.println("Verificando o spam");
            System.out.println( "spam" + listElement2.size() );


            if (listElement2.size() == 0) {
                System.out.println( "Voce não tem esse e-mail no spam" );
                existeEmail = true;
                break;

            } else {

                WebElement element2 = listElement2.get( 0 );
                if (element2.getText().equals( "teste teste" )) {
                    element2.click();

                    Thread.sleep( 3000 );

                    Actions actions2 = new Actions( driver );
                    WebElement lixoBtn = espera.until( ExpectedConditions.elementToBeClickable( (By.cssSelector( "[title*='marcelinhoboladao555@gmail.com']" )) ) );
                    actions2.contextClick( lixoBtn ).perform();

                    WebElement naoLixoEletronico = espera.until( ExpectedConditions.elementToBeClickable( By.name( "Marcar como não é lixo eletrônico" ) ) );
                    naoLixoEletronico.click();
                    Thread.sleep( 1000 );
                    System.out.println("Movendo o email para inbox");
                    break;
                }



            }


        }

        driver.get( "https://outlook.live.com/mail/inbox" );
        driver.navigate().refresh();
        verificarInboxOutlook();

    }

    public void excluirEmailOutlook(){
        driver.get("https://outlook.live.com/mail/deleteditems");


        WebElement btnExcluirDefinitivo = espera.until( ExpectedConditions.elementToBeClickable( By.name( "Esvaziar pasta" ) ) );
        btnExcluirDefinitivo.click();


        WebElement btnExcluirDefinitivo2 = espera.until( ExpectedConditions.elementToBeClickable( By.id( "ok-1" ) ) );
        btnExcluirDefinitivo2.click();

        existeEmail = true;
        System.out.println( "Emails excluidos " );

    }


}








