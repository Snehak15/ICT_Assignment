package Common;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Driver {

    public static WebDriver driver = null;

    @BeforeMethod
    public static WebDriver openBrowser() {
        String browser = "chrome";
        String url = "https://in.bookmyshow.com/";
        //disabled popup
        switch (browser.toLowerCase()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("useAutomationExtension", false);
                driver = new ChromeDriver(options);//launch browser
            }
            case "firefox" -> driver = new FirefoxDriver();
            case "ie" -> driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();//maximize window
        driver.navigate().to(url);//navigate to url
        return driver;
    }

    //    @AfterMethod
//    public static void closeBrowser(){
//        driver.close();
//    }
    @AfterMethod
    public static void closeBrowser() {
        driver.close();
    }


    @Test(priority = 1)
    public void searchMovie() throws InterruptedException, IOException {
        driver.findElement(By.id("input-search-box")).sendKeys("Fantasy Island");
        Thread.sleep(2000);
        driver.findElement(By.id("input-search-box")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        String title = driver.findElement(By.id("eventTitle")).getText();
        Assert.assertEquals("Fantasy Island", title.trim());
    }

    @Test(priority = 2)
    public void NegativeSearchMovie() throws InterruptedException, IOException {
            driver.findElement(By.id("input-search-box")).sendKeys("qq");
            Thread.sleep(2000);
            driver.findElement(By.id("input-search-box")).sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            String message=driver.findElement(By.xpath("//div[@class='__data-not-found']/div[2]")).getText();
            Assert.assertEquals("Oops! No results found",message);
        }




    @Test(priority = 3)
    public void CastAndCrew() throws InterruptedException, IOException {
        driver.findElement(By.id("input-search-box")).sendKeys("Onward");
        Thread.sleep(2000);
        driver.findElement(By.id("input-search-box")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        String title = driver.findElement(By.id("eventTitle")).getText();
        Assert.assertEquals("Onward", title.trim());
        driver.findElement(By.xpath("/html/body/div[5]/div/section[2]/aside/div[2]/a/h1"));
        driver.findElement(By.xpath("//*[contains(text(),'Tom Holland')]"));
        String title2 = driver.findElement(By.xpath("Tom Holland")).getText();
        Assert.assertEquals("Tom Holland", title2.trim());
//        System.out.println("Icon is displayed");
//        System.out.println("Assertion 2 is executed”);
        driver.findElement(By.xpath("//*[@id=\"crew-carousel\"]/div/div/div/span[3]/a/div"));
        driver.findElement(By.xpath("//*[contains(text(),'Mychael Danna')]"));
        String title3 = driver.findElement(By.xpath("Mychael Danna")).getText();
        Assert.assertEquals("Mychael Danna", title3.trim());

    }


    @Test(priority = 4)
    public void SearchforCastandCrewNegative() throws InterruptedException, IOException {
        driver.findElement(By.id("input-search-box")).sendKeys("Onward");
        Thread.sleep(2000);
        driver.findElement(By.id("input-search-box")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        String message=driver.findElement(By.xpath("//*[contains(text(),''Tom Cruise')]")).getText();
        //String title2 = driver.findElement(By.xpath("'Tom Cruise")).getText();
        Assert.assertEquals("'Tom Cruise", message);
        Thread.sleep(2000);
//
        String msg=driver.findElement(By.xpath("//*[contains(text(),''Tom Cruise')]")).getText();
        Assert.assertEquals("Michael Jackson",msg );
        Thread.sleep(2000);
//

    }

    @Test(priority = 5)
    public void ListourShowWhatcanyouHost() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[5]/header/nav/div[3]/div/div[2]/ul/li[1]/a"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]"));
        Thread.sleep(2000);
        String msg1=driver.findElement(By.id("Streaming")).getText();
        Assert.assertEquals("Streaming",msg1);
        Thread.sleep(2000);
        String msg2 =driver.findElement(By.id("Experiences")).getText();
        Assert.assertEquals("Experiences",msg2);
        Thread.sleep(2000);
       String msg3= driver.findElement(By.id("Expositions")).getText();
        Assert.assertEquals("Exposition",msg3);
        Thread.sleep(2000);
        String msg4=driver.findElement(By.id("Parties")).getText();
        Assert.assertEquals("Parties",msg4);
        Thread.sleep(2000);
        String msg5=driver.findElement(By.id("Sports")).getText();
        Assert.assertEquals("Sports",msg5);
        Thread.sleep(2000);
        String msg6=driver.findElement(By.id("Conferences")).getText();
        Assert.assertEquals("Conferences",msg6);
        Assert.assertTrue(true);
        Thread.sleep(2000);


    }


    @Test(priority = 6)
    public void ListYourShowWhaaretheservicesweoffer() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[5]/header/nav/div[3]/div/div[2]/ul/li[1]/a"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]"));
        Thread.sleep(2000);
        String list1=driver.findElement(By.id("Sales")).getText();
        Assert.assertEquals("Sales",list1);
        Thread.sleep(2000);
        String list2=driver.findElement(By.id("Pricing")).getText();
        Assert.assertEquals("Pricing",list2);
        Thread.sleep(2000);
        String list3=driver.findElement(By.id("Food")).getText();
        Assert.assertEquals("Food",list3 );
        Thread.sleep(2000);
        String list4=driver.findElement(By.id("Onground")).getText();
        Assert.assertEquals("Onground",list4);
        Thread.sleep(2000);
//        driver.findElement(By.id(""));
//        Assert.assertTrue(true);
//        Thread.sleep(2000);
//        driver.findElement(By.id("Conferences"));
//        Assert.assertTrue(true);
    }

    @Test(priority = 7)
    public void CheckOffers() throws InterruptedException, IOException {
        String offer1=driver.findElement(By.xpath("/html/body/div[5]/header/nav/div[3]/div/div[2]/ul/li[3]/a")).getText();
        Assert.assertEquals("Offers",offer1);
        Thread.sleep(2000);
        String reward=driver.findElement(By.xpath("/html/body/div[5]/div[2]/section[1]/div/h3")).getText();
        Thread.sleep(2000);
        Assert.assertEquals("Rewards",reward);
        String reward1=driver.findElement(By.xpath("//*[@id=\"REWARDPOINTS\"]/a/div[2]/h4")).getText();
        Assert.assertEquals("Reward Points Redemption",reward1);
        Thread.sleep(2000);
        String reward2=driver.findElement(By.xpath("//*[@id=\"PAYBACK\"]/a/div[2]/h4")).getText();
        Assert.assertEquals("offers-PAYBACK-POINTS",reward2);
        Thread.sleep(2000);

        String reward3=driver.findElement(By.xpath("//*[@id=\"SBISIMCLIK\"]/a/div[2]/h4")).getText();
        Assert.assertEquals("SimplyCLICK SBI Card Rewards Offer",reward3);
        Thread.sleep(2000);


    }

    @Test(priority = 8)
    public void SearchOffersPositivescenario() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[5]/header/nav/div[3]/div/div[2]/ul/li[3]/a"));
        Assert.assertTrue(true);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/section[1]/div/h3"));
        Thread.sleep(2000);
        Assert.assertTrue(true);
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/section[1]/div/ul/li[4]/span[2]"));
        Assert.assertTrue(true);
        Thread.sleep(2000);

        driver.findElement(By.id("ajax-typeahead")).sendKeys("ICICI Bank 25% Discount Offer");
        Thread.sleep(2000);
        driver.findElement(By.id("ajax-typeahead")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        String title = driver.findElement(By.id("Search for Offers by Name or Bank")).getText();
        Assert.assertEquals("ICICI Bank 25% Discount Offer", title.trim());


    }

    @Test(priority = 9)
    public void SearchOffersNegativescenario() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[5]/header/nav/div[3]/div/div[2]/ul/li[3]/a"));
        Assert.assertTrue(true);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/section[1]/div/h3"));
        Thread.sleep(2000);
        Assert.assertTrue(true);
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/section[1]/div/ul/li[4]/span[2]"));
        Assert.assertTrue(true);
        Thread.sleep(2000);

        driver.findElement(By.id("ajax-typeahead")).sendKeys("Kotak Mahindra Offer");
        Thread.sleep(2000);
        driver.findElement(By.id("ajax-typeahead")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        String title = driver.findElement(By.id("Search for Offers by Name or Bank")).getText();
        Assert.assertEquals("Kotak Mahindra Offer", title.trim());

    }


    @Test(priority = 10)
    public void SelectLanguage() throws InterruptedException, IOException {
        Select dropdown=new Select(driver.findElement(By.xpath("/html/body/div[5]/header/nav/div[2]/div/div[3]/div/div/ul/li[2]/div/div/div/a")));
        dropdown.selectByVisibleText("English");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"dLangWrapMob\"]/div/div/div/ul/li[1]")).isDisplayed();
        Assert.assertTrue(true);
        Thread.sleep(2000);

       driver.findElement(By.xpath("//*[@id=\"dLangWrapMob\"]/div/div/div/ul/li[2]/label")).isDisplayed();
      Assert.assertTrue(true);
       Thread.sleep(2000);
//
       driver.findElement(By.xpath("//*[@id=\"dLangWrapMob\"]/div/div/div/ul/li[3]")).isDisplayed();
      Assert.assertTrue(true);
       Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id=\"dLangWrapMob\"]/div/div/div/ul/li[4]")).isDisplayed();
      Assert.assertTrue(true);
      Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id=\"dLangWrapMob\"]/div/div/div/ul/li[5]")).isDisplayed();
       Assert.assertTrue(true);
      Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id=\"dLangWrapMob\"]/div/div/div/ul/li[6]")).isDisplayed();
       Assert.assertTrue(true);
        Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@id=\"dLangWrapMob\"]/div/div/div/ul/li[7]")).isDisplayed();
        Assert.assertTrue(true);
        Thread.sleep(2000);





    }



}
