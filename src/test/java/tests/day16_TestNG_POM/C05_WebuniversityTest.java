package tests.day16_TestNG_POM;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebuniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_WebuniversityTest {

    @Test(groups = {"smoke","e2e","regression"})
    public void webUniversityTest(){

        //1."https://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/");

        String ilkSayfaWHD = Driver.getDriver().getWindowHandle();


        //2."Login Portal" a  kadar asagi inin
        // portal yazisina kadar asagi inmek icin JS Executor kullanalim
        WebuniversityPage webuniversityPage = new WebuniversityPage();

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        //jse.executeScript("arguments[0].scrollIntoView(true);",webuniversityPage.loginPortalElementi);

        ReusableMethods.bekle(1);
        //3."Login Portal" a tiklayin
        webuniversityPage.loginPortalElementi.click();

        //4.Diger window'a gecin
        ReusableMethods.titleIleWindowDegistir("WebDriver | Login Portal",Driver.getDriver());
        //5."username" ve  "password" kutularina deger yazdirin
        Faker faker = new Faker();
        webuniversityPage.usernameKutusu.sendKeys(faker.name().username());
        webuniversityPage.passwordKutusu.sendKeys(faker.internet().password());
        //6."login" butonuna basin
        webuniversityPage.loginButonu.click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin

        String expectedAlertYazisi = "validation failed";
        String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();

        Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi);

        //8.Ok diyerek Popup'i kapatin

        Driver.getDriver().switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        Driver.getDriver().switchTo().window(ilkSayfaWHD);

        //10.Ilk sayfaya donuldugunu test edin
        String expectedUrl = "https://webdriveruniversity.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);


        Driver.quitDriver();
    }
}
