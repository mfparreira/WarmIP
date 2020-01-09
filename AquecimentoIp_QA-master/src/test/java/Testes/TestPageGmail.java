
package Testes;


import Pages.*;
import Suporte.Web;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith( DataDrivenTestRunner.class )
@DataLoader(filePaths = "massaEmailGmail.csv")


public class TestPageGmail {
    private WebDriver driver;



    @Before
    public void setUp() {

        driver = Web.createChrome();

    }



    @After
    public void TearDown(){
    driver.quit();

    }



        @Test
        public void acessarGmailTemplate1 (@Param( name = "email") String auxiliar1, @Param( name = "senha" ) String auxiliar2) throws InterruptedException {


            driver.get ("https://gmail.com.br");
        new LoginGmail( driver )
                .acessarEmail( auxiliar1, auxiliar2 );
        Thread.sleep( 5000 );
        new AbrirEmailGmail( driver )
                .verificarInboxGmail();


    }



}







