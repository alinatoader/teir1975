package Laborator5.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("file:///D:/Facultate/Semestrul%206/Verificare%20si%20validare/teir1975/Lab5/index.html")
public class DictionaryPage extends PageObject {

    @FindBy(name="Enunt")
    private WebElementFacade enunt;

    @FindBy(name="Raspuns1")
    private WebElementFacade raspuns1;

    @FindBy(name="Raspuns2")
    private WebElementFacade raspuns2;

    @FindBy(name="Raspuns3")
    private WebElementFacade raspuns3;

    @FindBy(name="RaspunsCorect")
    private WebElementFacade raspunsCorect;

    @FindBy(name="Domeniu")
    private WebElementFacade domeniu;

    @FindBy(name="Save")
    private WebElementFacade saveButton;

    public void enter_keywords(String enunt, String raspuns1, String raspuns2, String raspuns3, String raspunsCorect, String domeniu) {
        this.enunt.type(enunt);
        this.raspuns1.type(raspuns1);
        this.raspuns2.type(raspuns2);
        this.raspuns3.type(raspuns3);
        this.raspunsCorect.type(raspunsCorect);
        this.domeniu.type(domeniu);
    }

    public void save() {
        saveButton.click();
    }

    public List<String> getQuestions() {
        WebElementFacade definitionList = find(By.tagName("table"));
        return definitionList.findElements(By.name("enuntCol")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }
}