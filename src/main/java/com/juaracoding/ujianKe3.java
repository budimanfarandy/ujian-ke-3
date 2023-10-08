package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ujianKe3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\juaracoding\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println("Open Browser");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://juice-shop.herokuapp.com/#/login");
        System.out.println("Open URL");

        // Klik Dismiss
        delay(1);
        driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]/span[1]")).click();

        // Login Test
        // Username
        driver.findElement(By.id("email")).sendKeys("budi.farandy@yopmail.com");
        // Password
        driver.findElement(By.id("password")).sendKeys("Farandy123_");
        // Klik Login
        delay(1);
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-login[1]/div[1]/mat-card[1]/div[1]/button[1]")).click();
        // compare text = Imperssive, maka hasilnya passes, jika tidak maka failed
        //Assert menggunakan if
        String txtLogin = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-navbar/mat-toolbar/mat-toolbar-row/button[2]/span[1]/span")).getText();
        System.out.println(txtLogin);
        if (txtLogin.equals("OWASP Juice Shop")) {
            System.out.println("Passes");
        } else {
            System.out.println("Failed");
        }
        System.out.println("Login Test");


        // Product Banana Juice - Add to Basket - Cart - Checkout
        delay(2);
        driver.findElement(By.xpath("(//span[contains(text(),'Add to Basket')])[3]")).click();
        driver.findElement(By.xpath("//mat-icon[normalize-space()='shopping_cart']")).click();
        String txtBasket = driver.findElement(By.xpath("//body//app-root//h1[1]")).getText();
        System.out.println(txtBasket);
        if (txtBasket.equals("Your Basket")) {
            System.out.println("Passes");
        } else {
            System.out.println("Failed");
        }
        System.out.println("Basket Test");

        // Klik Checkout
        delay(4);
        driver.findElement(By.id("checkoutButton")).click();

        // Add New Adress
        driver.findElement(By.xpath("//button[@aria-label='Add a new address']//span[@class='mat-button-wrapper']")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-input-3\"]")).sendKeys("Indonesia");
        driver.findElement(By.xpath("//*[@id=\"mat-input-4\"]")).sendKeys("Farandy");
        driver.findElement(By.xpath("//*[@id=\"mat-input-5\"]")).sendKeys("08123456789");
        driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]")).sendKeys("15112");
        driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("Bintaro");
        driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")).sendKeys("Tangerang Selatan");
        driver.findElement(By.xpath("//*[@id=\"mat-input-9\"]")).sendKeys("Indonesia");

        // Submit Address
        delay(2);
        driver.findElement(By.xpath("//i[normalize-space()='send']")).click();
        delay(2);

        driver.quit();

    }



    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}