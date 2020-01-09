package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AbrirEmailGmail<emailNoSpam2> extends BasePage {
    public AbrirEmailGmail(WebDriver driver) {
        super( driver );
    }

    //Tempo de espera do elemento em tela
    WebDriverWait espera = new WebDriverWait( driver,25 );

    boolean existeEmail = false;



    public void verificarInboxGmail() throws InterruptedException {



        while (1 == 1 || existeEmail == false) {


            if  (existeEmail == true) {
                System.out.println( "Saindo" );

                break;

            }

            List<WebElement> listElement = driver.findElements( By.name( "teste teste" ) );
            System.out.println( "passou aqui" );

            if (listElement.size() <= 1 ) {
                System.out.println( "Você não tem esse email no inbox!" );
                verificarSpamGmail();

            }

            else {



                WebElement element2 = listElement.get( 1 );
                System.out.println( "INBOX = " + listElement.size() );
                if (element2.getText().equals( "teste teste" )) //to click on a specific mail.
                {

                    element2.click();
                    WebElement EmailNF2 = espera.until( ExpectedConditions.elementToBeClickable( By.cssSelector( "[name*='alvo']" ) ) );
                    ((JavascriptExecutor) driver).executeScript( "arguments[0].click()",EmailNF2 );

                    List<String> abas = new ArrayList<>( driver.getWindowHandles() );
                    driver.switchTo().window( abas.get( 0 ) );

                        try {
                            WebElement lixoBtn = espera.until( ExpectedConditions.elementToBeClickable(By.cssSelector("div[aria-label='Mais']")));
                            lixoBtn.click();

                            }
                        catch (Exception e){
                                WebElement lixoBtn2 = espera.until( ExpectedConditions.elementToBeClickable(By.cssSelector("div[aria-label='More']")));
                                lixoBtn2.click();
                            }

                            WebElement excluir = espera.until( ExpectedConditions.elementToBeClickable(By.id("tm")));
                            excluir.click();
                            Thread.sleep( 5000 );

                    excluirEmails();
                }
            }

        }

    }

    public void verificarSpamGmail() throws InterruptedException {



            driver.get( "https://mail.google.com/mail/#spam" );
            List<WebElement> listElement2 = driver.findElements( By.name( "teste teste" ) );

            while (1 == 1) {

                Thread.sleep( 5000 );

                if  (listElement2.size() >= 2) {
                        System.out.println( "SPAM = " + listElement2.size() );
                        WebElement element2 = listElement2.get( 1 );
                        element2.getText().equals( "teste teste");
                        element2.click();
                        Thread.sleep( 3000 );
                        WebElement reportNoSpamBtn = driver.findElement( By.xpath( "//*[@class='bzq bzr IdsTHf']" ) );

                        reportNoSpamBtn.click();
                        Thread.sleep( 3000 );
                        System.out.println( "jogando o email pro inbox" );

                    driver.get( "https://mail.google.com/mail/#inbox" );
                    driver.navigate().refresh();
                    verificarInboxGmail();

                }

                else {

                    System.out.println("Voce não recebeu esse email");
                    existeEmail = true;
                    System.out.println( existeEmail );
                    break;

                }
            }
    }

    public void excluirEmails() throws InterruptedException {


        driver.get( "https://mail.google.com/mail/#trash" );
        Thread.sleep( 2000 );

        List<WebElement> listElement3 = driver.findElements( By.name( "teste teste" ) );
        WebElement element3 = listElement3.get( 1 );
        Actions action = new Actions(driver);
        action.contextClick(element3).perform();


        WebElement confirmaExclusao = espera.until( ExpectedConditions.elementToBeClickable((By.className("Bn"))));
        System.out.println (confirmaExclusao);
        confirmaExclusao.click();


        System.out.println( "Emails excluidos" );
        existeEmail = true;
        Thread.sleep( 2000 );


    }
}











