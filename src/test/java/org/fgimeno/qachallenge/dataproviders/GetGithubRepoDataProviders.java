package org.fgimeno.qachallenge.dataproviders;

import org.testng.annotations.DataProvider;

public class GetGithubRepoDataProviders {

    @DataProvider(name = "githubMixedUserNames")
    public Object[][] mixedUserNames() {
        return new Object [][] {
                {"6436trssdfgf", "Github user not found"},
                {"fedgimeno", "Success!"},
                {"aL4ix", "Success!"},
                {"aaaertrdsytfrdf", "Github user not found"}
        };
    }

    @DataProvider(name = "githubValidUsers")
    public Object[][] validUsers() {
        return new Object [][] {
                {"fedgimeno"},
                {"aL4ix"},
        };
    }
}
