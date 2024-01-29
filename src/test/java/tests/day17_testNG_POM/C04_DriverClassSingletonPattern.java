package tests.day17_testNG_POM;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DriverClassSingletonPattern {

    @Test
    public void test01(){

        /*
            Testlerimizde kullanacagimiz WebDriver objesini
            utilities/ Driver class'indaki
            getDriver() ile olusturuyoruz

            Driver'in class'indaki WebDriver objesi olarak olusturulan
            driver'a Driver Class'indan obje olusturarak da erisebiliriz
            Ancak mahserin 4 atlisi calismadigindan
            driver objesi bir ise yaramaz

            POM dizayninda Driver class'indaki driver objesine
            obje uzerinden erisimi iptal etmek icin singleton pattern tercih edilmis


         */

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // Driver obj = new Driver(); // 'Driver()' has private access in 'utilities.Driver'
        // obj.driver.get(ConfigReader.getProperty("toUrl"));
    }
}
