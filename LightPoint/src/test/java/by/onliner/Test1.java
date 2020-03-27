package by.onliner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test1 {
    private ChromeDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

    }
    @Test
    public void testApple() throws InterruptedException {

        driver.get("https://www.onliner.by/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        Action sendPageDown = actions.sendKeys(Keys.DOWN).build();
        driver.findElement(By.linkText("Смартфоны")).click();
        sendPageDown.perform();
        sendPageDown.perform();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"schema-filter\"]/div[3]/div[4]/div[2]/ul/li[2]/label/span[1]/span")).click();
        sendPageDown.perform();
        sendPageDown.perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"schema-filter\"]/div[3]/div[4]/div[2]/ul/li[3]/label/span[2]")).click();
        Thread.sleep(3000);
        sendPageDown.perform();
        sendPageDown.perform();

        driver.findElement(By.xpath("//*[@id=\"schema-filter\"]/div[3]/div[5]/div[2]/div/div[1]/input")).sendKeys("100");
        Thread.sleep(5000);

        String xpathAll = "//*[@id=\"schema-products\"]/div";
        List<WebElement> listTotal = driver.findElementsByXPath(xpathAll);
                System.out.println("Общее количество наименований " + listTotal.size());

        WebElement firstOne = driver.findElement(By.xpath("//*[@id=\"schema-products\"]/div[1]/div/div[2]/div[2]/div[1]/a/span"));
        firstOne.click();
        WebElement costIphone = driver.findElement(By.xpath("//*[@id=\"shop-offers-container\"]/div[1]/div/div[1]/div/div[1]/a[1]/span/span"));
            if (Float.parseFloat(costIphone.getText().replace(',','.')) < 100)
                System.out.println("Ошибка — стоимость телефона меньше 100 BYN");
            else
                System.out.println("Стоимость Iphone = " + costIphone.getText() + " BYN" + ". => больше 100 BYN");

    }

    @After
    public void closeUp(){
        driver.quit();
    }}

