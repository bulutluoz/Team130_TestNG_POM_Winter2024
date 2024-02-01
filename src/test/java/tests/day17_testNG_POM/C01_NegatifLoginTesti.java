package tests.day17_testNG_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_NegatifLoginTesti {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    //3-  3 farkli test method’u olusturun.
    //	- gecerli email, gecersiz password
    //	- gecersiz email, gecerli password
    //	- gecersiz email, gecersiz password.
    //4- SignIn butonuna basarak login olun
    //5- Basarili olarak giris yapilamadigini test edin


    @Test (groups = {"smoke","E2E","regression"})
    public void gecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        ReusableMethods.bekle(1);
        testOtomasyonPage.accountLinki.click();
        //3-  3 farkli test method’u olusturun.
        //	- gecerli email, gecersiz password
        testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        //4- SignIn butonuna basarak login olun
        ReusableMethods.bekle(1);
        testOtomasyonPage.loginButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());

        Driver.quitDriver();
    }

    @Test
    public void gecersizEmailTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        ReusableMethods.bekle(1);
        testOtomasyonPage.accountLinki.click();
        //3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecerli password
        testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        //4- SignIn butonuna basarak login olun
        ReusableMethods.bekle(1);
        testOtomasyonPage.loginButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());

        Driver.quitDriver();
    }

    @Test(groups = "smoke")
    public void gecersizPasswordGecersizEmailTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        ReusableMethods.bekle(1);
        testOtomasyonPage.accountLinki.click();
        //3-  3 farkli test method’u olusturun.
        //	- gecersiz email, gecersiz password.
        testOtomasyonPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        //4- SignIn butonuna basarak login olun
        ReusableMethods.bekle(1);
        testOtomasyonPage.loginButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());

        Driver.quitDriver();
    }
}
