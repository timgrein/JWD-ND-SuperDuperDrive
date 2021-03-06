package com.udacity.jwdnd.course1.cloudstorage.uitests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "classpath:database/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public abstract class AbstractUiTest {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    @LocalServerPort
    private Integer port;

    private static WebDriver driver;

    private static String baseUrl;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "http://localhost:";
    }

    @AfterEach
    public void afterEach() {
        if (driver != null) {
            driver.quit();
        }
    }

    public Integer getPort() {
        return port;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
}
