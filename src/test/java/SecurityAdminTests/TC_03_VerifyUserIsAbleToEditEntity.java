package SecurityAdminTests;

import BaseTest.TestData;
import Pages.EntitiesPage;
import Pages.HomePage;
import org.testng.annotations.Test;

public class TC_03_VerifyUserIsAbleToEditEntity {
    @Test(enabled = true, groups = {"Entity"}, dataProviderClass = TestData.class, dataProvider = "EditEntity")
    public void TC_003_VerifyUserIsAbleToEditEntity(String name, String entityType, String description, String externalEntityId, String subscribedApplications, String assignedAuthenticationTypes,
                                                               String activePassive, String message) {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.homePageIsDisplayed();
        EntitiesPage entitiesPage = new EntitiesPage();
        entitiesPage.clickEditButton();
        entitiesPage.addEntitiesButtonIsDisplayed();
        entitiesPage.enterName(name);
        entitiesPage.enterEntityType(entityType);
        entitiesPage.enterDescription(description);
        entitiesPage.enterExternalEntityId(externalEntityId);
        entitiesPage.enterSubscribedApplications(subscribedApplications);
        entitiesPage.enterAssignedAuthenticationTypes(assignedAuthenticationTypes);
        entitiesPage.enterActivePassive(activePassive);
        entitiesPage.clickSubmitButton();
        entitiesPage.verifySuccessMessage(message);
        entitiesPage.verifyEntityIsUpdatedSuccessfully();
    }
}
