package Laborator5.steps.serenity;

import Laborator5.pages.DictionaryPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EndUserSteps {

    DictionaryPage dictionaryPage;

    @Step
    public void enters(String enunt, String raspuns1, String raspuns2, String raspuns3, String raspunsCorect, String domeniu) {

        dictionaryPage.enter_keywords(enunt, raspuns1, raspuns2, raspuns3, raspunsCorect, domeniu);
    }

    @Step
    public void try_save() {
        dictionaryPage.save();
    }

    @Step
    public void should_see_new_item(String question) {
        assertThat(dictionaryPage.getQuestions(), hasItem(containsString(question)));
    }

    @Step
    public void should_not_see_new_item(String question) {
        assertThat(dictionaryPage.getQuestions(), contains(not(nullValue())));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void type(String enunt, String raspuns1, String raspuns2, String raspuns3, String raspunsCorect, String domeniu) {
        enters(enunt, raspuns1, raspuns2, raspuns3, raspunsCorect, domeniu);
        try_save();
    }
}