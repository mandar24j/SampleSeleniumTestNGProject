package Pages;

import AbstractClass.BasePage;

public class EntitiesPage extends BasePage {
    String addButton = "//*[text()='Add Entity']";

    public void clickAddButton() {
        dh.click(addButton);
    }

    public void addEntitiesButtonIsDisplayed() {
    }

    public void enterName(String name) {
    }

    public void enterEntityType(String entityType) {
    }

    public void enterDescription(String description) {
    }

    public void enterExternalEntityId(String externalEntityId) {
    }

    public void enterSubscribedApplications(String subscribedApplications) {
    }

    public void enterAssignedAuthenticationTypes(String assignedAuthenticationTypes) {
    }

    public void enterActivePassive(String activePassive) {
    }

    public void clickSubmitButton() {
    }

    public void verifySuccessMessage(String message) {
    }

    public void verifyEntityIsAddedSuccessfully() {
    }

    public void enterPassword(String password) {
    }

    public void enterConfirmPassword(String password) {
    }

    public void verifyErrorMessage(String message) {
    }

    public void verifyEntityIsNotAdded() {

    }

    public void clickEditButton() {
    }

    public void verifyEntityIsUpdatedSuccessfully() {
    }

    public void clickDeleteEntity() {
    }

    public void verifyEntityIsDeleted() {
    }

    public void verifyDeleteMessage(String message) {
    }

    public void clickConfirmDeleteBtton() {
    }
}
