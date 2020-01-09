
package Testes;


import Pages.AbriremailHotmail;
import Pages.AbriremailOutlook;
import Pages.LoginOutlook;
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
@DataLoader(filePaths = "massaEmailHotmail.csv")


public class TestPageHotmail {
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
         public void acessarHotmailTempleate1(@Param( name = "email") String auxiliar3, @Param( name = "senha" ) String auxiliar4) throws InterruptedException {
             driver.get ("https://outlook.live.com/mail/inbox");
            new LoginOutlook( driver )
                .LoginOutlook(auxiliar3, auxiliar4 );
            new AbriremailHotmail( driver )
                    .verificarSpamHotmail();

         }


}








