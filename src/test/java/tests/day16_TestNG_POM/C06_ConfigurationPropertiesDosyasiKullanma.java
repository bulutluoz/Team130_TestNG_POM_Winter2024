package tests.day16_TestNG_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_ConfigurationPropertiesDosyasiKullanma {

    @Test(groups = "regression")
    public void pozitifLoginTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.accountLinki.click();
        //3- Kullanici email'i olarak “wise@gmail.com”girin
        testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        //4- Kullanici sifresi olarak “12345” girin
        testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        //5- Login butonuna basarak login olun
        testOtomasyonPage.loginButonu.click();
        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testOtomasyonPage.logoutButonu.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
}
