package Suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Web {

    //public static final String USERNAME = "marceloparreira1";
    //public static final String AUTOMATE_KEY = "EsMaJgQPhqxscdEMFzzB";
    //public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome(){


        //abrir o navegador local
        System.setProperty("webdriver.chrome.driver", "C:\\\\Tools\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // navegar para a pagina de teste





        return driver;

    }

    /**public static WebDriver createBrowserStack(){


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Safari");
        caps.setCapability("browser_version", "9.1");
        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "El Capitan");
        caps.setCapability("resolution", "1024x768");

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get ("https://dev.credz.negociafacil.com.br/");
        }
        catch (MalformedURLException e) {
            System.out.println("Houve problema com a URL:" + e.getMessage());
        }

        return driver;
    }*/
}
