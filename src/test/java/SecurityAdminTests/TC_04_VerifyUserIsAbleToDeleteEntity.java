package SecurityAdminTests;

import Pages.EntitiesPage;
import Pages.HomePage;
import org.testng.annotations.Test;

public class TC_04_VerifyUserIsAbleToDeleteEntity {
    @Test(enabled = true, groups = {"Entity"})
    public void TC_004_VerifyUserIsAbleToDeleteEntity() {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.homePageIsDisplayed();
        EntitiesPage entitiesPage = new EntitiesPage();
        entitiesPage.clickDeleteEntity();
        entitiesPage.clickConfirmDeleteBtton();
        entitiesPage.verifyDeleteMessage("Entity Is Deleted");
        entitiesPage.verifyEntityIsDeleted();
    }
}
