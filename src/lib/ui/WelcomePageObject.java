package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject{
    public static final String
            STEP_LEARN_MORE_LINK = "xpath://*[@name='Learn more about Wikipedia']",
            STEP_NEW_WAYS_TO_EXPLORE_TEXT = "xpath://*[@name='New ways to explore']",
            STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "xpath://*[@name='Add or edit preferred languages']",
            STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "xpath://*[@name='Learn more about data collected']",
            NEXT_BUTTON = "xpath://*[@name='Next']",
            GET_STARTED_BUTTON = "xpath://*[@name='Get started']";



    public WelcomePageObject(AppiumDriver driver){
        super(driver);
    }

    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK,
                "Cannot find 'Learn more about Wikipedia' link", 10);
    }
    public void waitForNewWaysToExploreText()
    {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT,
                "Cannot find 'New ways to explore' text", 10);
    }
    public void waitForAddOrEditPreferredLangLink()
    {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK,
                "Cannot find 'Add or edit preferred languages' link", 10);
    }
    public void waitForLearnMoreAboutDataCollectedLink()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK,
                "Cannot find 'Learn more about data collected' link", 10);
    }

    public void clickNextButton()
    {
        this.waitForElementAndClick(NEXT_BUTTON,
                "Cannot find 'Next' button", 10);
    }
    public void clickGetStartedButton()
    {
        this.waitForElementAndClick(GET_STARTED_BUTTON,
                "Cannot find 'Get started' button", 10);
    }
}