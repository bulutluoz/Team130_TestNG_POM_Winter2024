package tests.day20_CrossBrowserCalisacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

import java.util.List;

public class C02_CrossBrowserurunSepetiTesti extends TestBaseCross {

    @Test
    public void urunSepetitesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        //2- phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        //3- Listelenen sonuclardan ilkini tiklayin
        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.xpath("//div[@class='product-box my-2  py-1']"));

        ReusableMethods.bekle(1);
        bulunanUrunElementleriList.get(0).click();
        //4- urun ismini kaydedin ve sepete ekleyin
        WebElement urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String sayfadakiUrunIsmi = urunIsimElementi.getText();

        driver.findElement(By.xpath("//button[@class='add-to-cart']")).click();

        //5- your cart linkine tiklayin
        driver.findElement(By.xpath("(//div[@class='cart-bar'])[2]")).click();
        //6- kaydettiginiz urun ismi ile sepetteki urun isminin
        //   case sensitive olmadan ayni oldugunu test edin

        WebElement sepettekiUrunIsimElementi =
                driver.findElement(By.xpath("//*[@*='product-title text-center']"));

        String sepettekiUrunIsmi = sepettekiUrunIsimElementi.getText();

        Assert.assertEquals(sepettekiUrunIsmi.toLowerCase(),sayfadakiUrunIsmi.toLowerCase());
    }
}
