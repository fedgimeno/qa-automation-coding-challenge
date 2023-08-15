package org.fgimeno.qachallenge.tests;

import org.fgimeno.qachallenge.dataproviders.GetGithubRepoDataProviders;
import org.fgimeno.qachallenge.pages.GetGithubRepoPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestGithubRepoSearch extends TestBase{


    /**
     * @param username - The Github username
     * @param expectedMessage - The expected message for search action
     *
     * Verify whether the expected success / failure message is displayed when searching a Github user
     */
    @Test (dataProviderClass = GetGithubRepoDataProviders.class, dataProvider = "githubMixedUserNames")
    public void testGithubUserSearchResultMessage (String username, String expectedMessage) {
        getGithubRepoPage.enterGithubUser(username);
        getGithubRepoPage.clickGoButton();
        Assert.assertEquals(getGithubRepoPage.getSearchSuccessActionMessage(), expectedMessage);
    }


    /**
     * @param username - The Github username
     *
     * Verify whether the listed repos' links, lead the user to the corresponding, valid Github url
     */
    @Test (dataProviderClass = GetGithubRepoDataProviders.class, dataProvider = "githubValidUsers")
    public void testGithubUserRepoLinks (String username) {
        getGithubRepoPage.enterGithubUser(username);
        getGithubRepoPage.clickGoButton();
        Map<String, List<WebElement>> reposInfo = getGithubRepoPage.getReposInfo();
        for (int i = 0; i < reposInfo.get("names").size(); i++) {
            WebElement link = reposInfo.get("links").get(i);
            String repoName = reposInfo.get("names").get(i).getText();
            String url = String.format("https://github.com/%s/%s", username, repoName);
            Assert.assertEquals(link.getAttribute("href"), url, "Link does not lead to a Github repository");
            link.click();
            Set<String> handles = driver.getWindowHandles();            //Get the handles of all currently open windows (tabs)
            driver.switchTo().window(handles.toArray()[1].toString());  //Switch to the newly opened tab
            wait.until(ExpectedConditions.titleContains(repoName));
            driver.close();                                             //Close tab
            driver.switchTo().window(handles.toArray()[0].toString());  //Return to the first tab
            wait.until(ExpectedConditions.titleIs(GetGithubRepoPage.TITLE));
        }
    }
}

