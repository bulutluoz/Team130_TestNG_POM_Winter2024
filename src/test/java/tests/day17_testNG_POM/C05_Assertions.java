package tests.day17_testNG_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_Assertions {

    @Test
    public void aramaTesti(){

        // test otomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // testotomasyonu sayfasina gittiginizi test edin

        String expectedUrl = ConfigReader.getProperty("toUrl")+"/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

        // phone icin arama yapin

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // bulunan urun sayisinin 3'den fazla oldugunu test edin
        int expectedMinUrunSayisi = 3;
        int actualUrunSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();

        Assert.assertTrue(actualUrunSayisi > expectedMinUrunSayisi);
        // ilk urune tiklayin
        ReusableMethods.bekle(2);
        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();
        // acilan urun sayfasinda, urun isminin
        // case sensitive olmadan phone icerdigini test edin

        String expectedurunisimIcerik = "phone";
        String actualUrunIsmiKucukHarf= testOtomasyonPage
                                        .urunSayfasindaUrunIsimElementi
                                        .getText()
                                        .toLowerCase();

        Assert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedurunisimIcerik));
        // sayfayi kapatin

        Driver.quitDriver();
    }
}
