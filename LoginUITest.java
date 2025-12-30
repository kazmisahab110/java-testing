package com.example.demo;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LoginUITest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void validLoginShowsSuccess() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.id("loginBtn")).click();

        String msg = driver.findElement(By.id("message")).getText();
        assertEquals("Login successful!", msg);
    }

    @Test
    void invalidLoginShowsError() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("wrong");
        driver.findElement(By.id("loginBtn")).click();

        String msg = driver.findElement(By.id("message")).getText();
        assertEquals("Invalid credentials", msg);
    }
}
