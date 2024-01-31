package tests.day16_TestNG_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_PageClassIlePozitifLoginTesti {

    @Test(groups = "smoke")
    public void pozitifLoginTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");
        //2- account linkine basin

        //POM'de page class'larinda locate ettigimiz webElementlere ulasmak icin
        // PageClass'larindan obje olustururuz

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.accountLinki.click();

        //3- Kullanici email'i olarak “wise@gmail.com”girin
        testOtomasyonPage.emailKutusu.sendKeys("wise@gmail.com");
        //4- Kullanici sifresi olarak “12345” girin
        testOtomasyonPage.passwordKutusu.sendKeys("12345");
        //5- Login butonuna basarak login olun
        testOtomasyonPage.loginButonu.click();
        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testOtomasyonPage.logoutButonu.isDisplayed());
        ReusableMethods.bekle(5);
        Driver.quitDriver();
    }
}
