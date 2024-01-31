package tests.day16_TestNG_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_PageClassKullanimi {

    @Test(groups = {"smoke","regression"})
    public void aramaTesti(){
        //1- testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");
        //2- phone icin arama yapin
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        //3- Arama sonucunda bulunan urun sayisinin 3’den cok oldugunu test edin

        int actualSonucSayisi = testOtomasyonPage.bulunanUrunElementleriList.size();
        int expectedMinSonucSayisi = 3;

        Assert.assertTrue(actualSonucSayisi>expectedMinSonucSayisi);

        //4- ilk urunu tiklayin
        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();
        //5- acilan urun sayfasinda, urun isminde case sensitive olmadan phone bulundugunu test edin.

        String expectedUrunIsimIcerigi = "phone";
        String actualUrunIsmiKucukHarf = testOtomasyonPage
                                            .urunSayfasindaUrunIsimElementi
                                            .getText()
                                            .toLowerCase();

        Assert.assertTrue(actualUrunIsmiKucukHarf.contains(expectedUrunIsimIcerigi));

        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }
}
