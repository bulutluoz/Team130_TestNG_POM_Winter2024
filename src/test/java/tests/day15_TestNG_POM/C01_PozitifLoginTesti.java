package tests.day15_TestNG_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_PozitifLoginTesti extends TestBase {

    @Test
    public void pozitifLoginTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get("https://www.testotomasyonu.com/");
        //2- account linkine basin
        driver.findElement(By.xpath("(//a[@class='e-cart'])[1]"))
                .click();
        //3- Kullanici email'i olarak “wise@gmail.com”girin
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email']"));
        emailKutusu.sendKeys("wise@gmail.com");
        //4- Kullanici sifresi olarak “12345” girin
        WebElement passwordKutusu = driver.findElement(By.xpath("//input[@id='password']"));
        passwordKutusu.sendKeys("12345");
        //5- Login butonuna basarak login olun
        driver.findElement(By.xpath("//*[@id='submitlogin']"))
                .click();
        //6- Basarili olarak giris yapilabildigini test edin

        WebElement logOutButonu = driver.findElement(By.xpath("//span[text()='Logout']"));

        Assert.assertTrue(logOutButonu.isDisplayed());

        ReusableMethods.bekle(2);
    }


}
