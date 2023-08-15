package org.fgimeno.qachallenge.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.By.*;

public class GetGithubRepoPage {
    public static final String TITLE = "Get Github Repos";

    //WebElements locators
    By messageArea = new ByClassName("message-area");
    By inputUserName = new ById("username");
    By goButton = new ByXPath("/html/body/div/div/main/form/button");
    String repoListBaseXpath = "//section[@class='output-area']//li";
    By repoListLinks = new ByXPath(repoListBaseXpath + "//p[1]/a");
    By repoListNames = new ByXPath(repoListBaseXpath + "//p[1]");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public GetGithubRepoPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterGithubUser(String username){
        WebElement userNameField = driver.findElement(inputUserName);
        userNameField.clear();
        userNameField.sendKeys(username);
    }

    public void clickGoButton(){
        wait.until(ExpectedConditions.elementToBeClickable(goButton));
        driver.findElement(goButton).click();
    }

    public String getSearchSuccessActionMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageArea));
        return driver.findElement(messageArea).findElement(new ByTagName("p")).getText();
    }

    public Map<String, List<WebElement>> getReposInfo() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(repoListLinks));

        Map<String, List<WebElement>> reposInfo = new HashMap<>();
        List<WebElement> resultNames = new ArrayList<>(driver.findElements(repoListNames));
        List<WebElement> resultLinks = new ArrayList<>(driver.findElements(repoListLinks));
        reposInfo.put("names", resultNames);
        reposInfo.put("links", resultLinks);

        return reposInfo;
    }

}


