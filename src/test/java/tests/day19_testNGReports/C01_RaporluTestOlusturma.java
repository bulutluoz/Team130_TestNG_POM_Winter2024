package tests.day19_testNGReports;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_RaporluTestOlusturma extends TestBaseRapor {

    @Test
    public void aramaTesti(){

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
