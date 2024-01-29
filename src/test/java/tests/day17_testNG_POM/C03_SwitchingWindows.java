package tests.day17_testNG_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import pages.ToAddRemovePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_SwitchingWindows {

    @Test
    public void windowTesti(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("toAddUrl"));
        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.

        String expectedYazi = "Add/Remove Elements";

        ToAddRemovePage toAddRemovePage = new ToAddRemovePage();
        String actualYazi = toAddRemovePage.addRemoveYaziElementi.getText();

        Assert.assertEquals(actualYazi,expectedYazi);

        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.

        String expectedTitle = "Test Otomasyonu";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
        String addRemoveSayfasiWhd = Driver.getDriver().getWindowHandle();

        //● ’Please click for Electronics Products’ linkine tiklayin.
        ReusableMethods.bekle(1);
        toAddRemovePage.electronicsLinki.click();

        //● Electronics sayfasinin acildigini test edin

        // link tiklandiginda electronics sayfasi ayri bir tab olarak aciliyor
        // once webDriver objemizi o window'a gecirmeliyiz

        ReusableMethods.titleIleWindowDegistir("Test Otomasyonu - Electronics",Driver.getDriver());

        ReusableMethods.bekle(1);
        Assert.assertTrue(toAddRemovePage.electronicsSayfasiDogrulama.isDisplayed());

        //● Bulunan urun sayisinin 16 olduğunu test edin
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();

        int expectedUrunSayisi = 16;
        int actualUrunSayisi = toAddRemovePage.bulunanUrunElementleriList.size();

        Assert.assertEquals(actualUrunSayisi,expectedUrunSayisi);

        //● Ilk actiginiz addremove sayfasina donun

        Driver.getDriver().switchTo().window(addRemoveSayfasiWhd);
        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik = "addremove";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        Driver.quitDriver();
    }
}
