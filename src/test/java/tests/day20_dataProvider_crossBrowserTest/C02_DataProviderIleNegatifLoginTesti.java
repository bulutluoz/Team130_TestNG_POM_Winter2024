package tests.day20_dataProvider_crossBrowserTest;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DataProviderIleNegatifLoginTesti {


    /* test otomasyonu anasayfaya gidin
       account linkine tiklayin
       liste olarak verilen kullanici adi ve password'ler ile
       giris yapilamadigini test edin

        banu@gmail.com     898989
        sedat@yahoo.com    989887
        orkong@tmail.com   122334
        fatih@hotmail.com  454545
        arzu@senmail.com   676767
        mehmet@mynet.com   878987
     */

    @DataProvider
    public static Object[][] emailVePasswordProvider() {

        String[][] emailVeSifreler = {  {"banu@gmail.com","898989"},
                                        {"sedat@yahoo.com","989887"},
                                        {"orkong@tmail.com","122334"},
                                        {"wise@gmail.com","12345"},
                                        {"fatih@hotmail.com","454545"},
                                        {"arzu@senmail.com","676767"},
                                        {"mehmet@mynet.com","878987"}};

        return emailVeSifreler;
    }


    @Test(dataProvider = "emailVePasswordProvider")
    public void topluNegatifLoginTesti(String email , String password){

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        ReusableMethods.bekle(2);

        testOtomasyonPage.accountLinki.click();

        testOtomasyonPage.emailKutusu.sendKeys(email);
        testOtomasyonPage.passwordKutusu.sendKeys(password);
        ReusableMethods.bekle(2);
        testOtomasyonPage.loginButonu.click();

        try {
            Assert.assertTrue(testOtomasyonPage.emailKutusu.isDisplayed());
        } catch (NoSuchElementException e) {

            testOtomasyonPage.logoutButonu.click();
            Assert.assertTrue(false);
        }

        Driver.quitDriver();

    }

}
