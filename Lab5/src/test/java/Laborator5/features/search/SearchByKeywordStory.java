package Laborator5.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Laborator5.steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Test
    public void adding_valid_questions_should_display_new_item() {
        anna.is_the_home_page();
        anna.type("Ce faci?", "bine", "rau", "nu stiu", "1", "social");
        anna.should_see_new_item("Ce faci?");
    }

    @Test
    public void adding_invalid_questions_should_not_display_new_item() {
        anna.is_the_home_page();
        anna.type("", "bine", "rau", "nu stiu", "1", "social");
        anna.should_not_see_new_item("");
    }

} 