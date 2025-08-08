import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class TemaSesiunea1 {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.out.println("Rulam metoda de setup...");
        // Acest cod se va executa INAINTEA FIECAREI metode @Test
//            System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testTitluEmag() {
        System.out.println("Rulam testul pentru titlul Emag...");
        driver.get("https://www.emag.ro/");
    String titluActual = driver.getTitle();
    String titluAsteptat = "eMAG.ro - Căutarea nu se oprește niciodată";
    Assert.assertEquals(titluActual, titluAsteptat, "Titlul paginii Emag nu este corect!");
}


    @Test
    public void testUrlImdb() {

        System.out.println("Rulam testul pentru imdb...");
        driver.navigate().to("https://www.imdb.com/");
        Assert.assertTrue(driver.getCurrentUrl().contains("imdb.com"), "URL-ul curent contine caracterele asteptate.");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Rulam metoda de teardown...");
        // Acest cod se va executa DUPA FIECARE metoda @Test
        if (driver != null) {
            driver.quit();
        }
    }

}


