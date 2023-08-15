package org.fgimeno.qachallenge.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.fgimeno.qachallenge.pages.GetGithubRepoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected GetGithubRepoPage getGithubRepoPage;

    @BeforeClass (alwaysRun = true)
    protected void classSetup() {
        driver = WebDriverManager.firefoxdriver().create();
        driver.get("http://localhost:3000");
        wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        getGithubRepoPage = new GetGithubRepoPage(driver, wait);
        wait.until(ExpectedConditions.titleIs(GetGithubRepoPage.TITLE));
    }

    @AfterClass (alwaysRun = true)
    protected void classTearDown(){
        driver.quit();
    }
}
