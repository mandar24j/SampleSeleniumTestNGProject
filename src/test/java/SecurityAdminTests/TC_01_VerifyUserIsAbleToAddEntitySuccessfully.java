package SecurityAdminTests;

import BaseTest.TestData;
import Pages.EntitiesPage;
import Pages.HomePage;
import org.testng.annotations.Test;

public class TC_01_VerifyUserIsAbleToAddEntitySuccessfully {
    @Test(enabled = true, groups = {"Entity"}, dataProviderClass = TestData.class, dataProvider = "AddEntitySuccessfully")
    public void TC_001_VerifyUserIsAbleToAddEntitySuccessfully(String TCname, String name, String entityType, String description, String externalEntityId, String subscribedApplications, String assignedAuthenticationTypes,
                                                               String activePassive, String password, String message) {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.homePageIsDisplayed();

        EntitiesPage entitiesPage = new EntitiesPage();
        entitiesPage.clickAddButton();
        entitiesPage.addEntitiesButtonIsDisplayed();
        entitiesPage.enterName(name);
        entitiesPage.enterEntityType(entityType);
        entitiesPage.enterDescription(description);
        entitiesPage.enterExternalEntityId(externalEntityId);
        entitiesPage.enterSubscribedApplications(subscribedApplications);
        entitiesPage.enterAssignedAuthenticationTypes(assignedAuthenticationTypes);
        entitiesPage.enterActivePassive(activePassive);
        entitiesPage.enterPassword(password);
        entitiesPage.enterConfirmPassword(password);
        entitiesPage.clickSubmitButton();
        entitiesPage.verifySuccessMessage(message);
        entitiesPage.verifyEntityIsAddedSuccessfully();
    }

}
