package tests.day18_softAssertions_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_SoftAssertion {

    /*
        TestNG JUnit'deki assertion class'inin aynisina sahiptir

        Ancak bu assertion'da , bir test method'unun icinde birden fazla assertion oldugunda
        ilk FAILED olan assertion'da kodlarin calismasi durdugu icin,
        geriye assertion'larin sonuclarini gorme sansimiz OLMAZ

        EGER birden fazla assertion olan bir test method'unda
        tum assertion'lari yapip,
        en sonda varsa failed tum assertion'lari raporlamasini istersek
        TestNG'deki SoftAssert class'ini kullanabiliriz

        Soft assert 3 adimda calistirilir
        1- softAssert objesi olusturma
        2- olusturdugumuz obje uzerinden assertion'lari yapma
        3- assertAll() ile yapilan tum assertion'lari rapolama

        softAssert hatayi assertAll() method'unun calistigi satirda raporlar
        birden fazla assertion olan bir method'da
        failed olan assertion'i rahat bulabilmek icin
        assertion kodlarina, mesaj da eklemek isabetli bir tercih olacaktir

        softAssert ile hazirlanan bir test method'unun sonunda
        assertAll() demezsek
        failed olan assertion olsa bile
        testimiz PASSED olur
     */

    @Test
    public void softAssertAramaTesti(){

        // test otomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // testotomasyonu sayfasina gittiginizi test edin

        String expectedUrl = ConfigReader.getProperty("toUrl")+"/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        //Assert.assertEquals(actualUrl,expectedUrl);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualUrl,expectedUrl,"URL testi failed"); // 1.assertion

        // phone icin arama yapin

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // bulunan urun sayisinin 3'den fazla oldugunu test edin
        int expectedMinUrunSayisi = 3;
        int actualUrunSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();

        //Assert.assertTrue(actualUrunSayisi > expectedMinUrunSayisi);
        softAssert.assertTrue(actualUrunSayisi > expectedMinUrunSayisi,"Urun sayisi testi failed"); // 2.assertion

        // ilk urune tiklayin
        ReusableMethods.bekle(2);
        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();
        // acilan urun sayfasinda, urun isminin
        // case sensitive olmadan phone icerdigini test edin

        String expectedurunisimIcerik = "phoneDDD";
        String actualUrunIsmiKucukHarf= testOtomasyonPage
                .urunSayfasindaUrunIsimElementi
                .getText()
                .toLowerCase();

        // Assert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedurunisimIcerik));
        softAssert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedurunisimIcerik),"urun ismi testi failed"); // 3.assertion

        softAssert.assertAll();

        // sayfayi kapatin

        Driver.quitDriver();
    }
}
