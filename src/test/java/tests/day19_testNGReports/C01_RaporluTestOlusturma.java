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
        /*
            Raporlu olmasini istedigimiz her test method'unda
            1- class'in TestbaseRapor'a child yapilmasi
            2- extentTest objesinin olusturulmasi
            3- raporda cikmasini istedigimiz test adimlarini
               extentTest objesi ile islemeliyiz
         */

        extentTest = extentReports.createTest("arama testi","test otomasyonunda phone aranabilmeli");
        // test otomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("kullanici test otomasyonu ana sayfaya gider");
        // testotomasyonu sayfasina gittiginizi test edin

        String expectedUrl = ConfigReader.getProperty("toUrl")+"/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        //Assert.assertEquals(actualUrl,expectedUrl);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualUrl,expectedUrl,"URL testi failed"); // 1.assertion
        extentTest.info("testotomasyonu sayfasina gittigini test eder");
        // phone icin arama yapin

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        extentTest.info("phone icin arama yapar");
        // bulunan urun sayisinin 3'den fazla oldugunu test edin
        int expectedMinUrunSayisi = 3;
        int actualUrunSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();

        //Assert.assertTrue(actualUrunSayisi > expectedMinUrunSayisi);
        softAssert.assertTrue(actualUrunSayisi > expectedMinUrunSayisi,"Urun sayisi testi failed"); // 2.assertion
        extentTest.info("bulunan urun sayisinin 3'den fazla oldugunu test eder");
        // ilk urune tiklayin
        ReusableMethods.bekle(2);
        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();
        extentTest.info("ilk urune tiklar");
        // acilan urun sayfasinda, urun isminin
        // case sensitive olmadan phone icerdigini test edin

        String expectedurunisimIcerik = "phone";
        String actualUrunIsmiKucukHarf= testOtomasyonPage
                .urunSayfasindaUrunIsimElementi
                .getText()
                .toLowerCase();
        extentTest.info("urun isminin case sensitive olmadan phone icerdigini test eder");
        // Assert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedurunisimIcerik));
        softAssert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedurunisimIcerik),"urun ismi testi failed"); // 3.assertion
        ReusableMethods.bekle(2);
        softAssert.assertAll();
        extentTest.pass("softassert ile yapilan tum assertionlar raporlanir");

        // sayfayi kapatin

        Driver.quitDriver();
        extentTest.info("sayfayi kapatir");

    }
}
