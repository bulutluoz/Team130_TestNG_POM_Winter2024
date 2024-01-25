package tests.day15_TestNG_POM;

import org.testng.annotations.Test;

public class C03_PriorityKurallari {

    /*
        1- eger bizim mudahalemiz olmazsa TestNG testleri isim sirasina gore calistirir
        2- Eger biz testleri siralamak istersek
           (priority = istenenDeger) yazariz
           ve TestNG priority degerlerine bakarak kucukten buyuge dogru calistirir
        3- Bazi test method'larina priority atamasi yapip, bazilarina yapmazsak
           TestNG atama yapilmayanlara default olarak priority = 0 atamasini yapar
           ve bu degere gore priority'leri siralar
        4- Eger ayni priority degerine sahip birden fazla test method'u varsa
           kendi iclerinde harf sirasina gore ca;lisirlar
     */

    @Test(priority = -10)
    public void testOtomasyonTesti(){

        System.out.println("test otomasyonu testi calisti");
    }

    @Test
    public void wiseQuarterTesti(){

        System.out.println("Wise Quarter testi calisti");
    }

    @Test
    public void youtubeTesti(){

        System.out.println("Youtube testi calisti");
    }
}
