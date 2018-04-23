package evaluator.controller;

import evaluator.model.Intrebare;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alina on 4/22/2018.
 */
public class AppControllerTest {
    AppController ctrl;

    @Before
    public void setUp() throws Exception {
        ctrl = new AppController();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void BBT_TC1_ECP() {
        try {
            Intrebare i = new Intrebare("Ce inseamna OOP?", "1) Object oriented programming", "2) raspuns gresit", "1", "Programare");
            ctrl.addNewIntrebare(i);
            Assert.assertTrue(ctrl.getIntrebari().size() == 1);
        }
        catch(Exception e){
            Assert.assertEquals("", e.getMessage());
        }
    }

    @Test
    public void BBT_TC2_ECP() {
        try {
            Intrebare i = new Intrebare("intrebare", "432", "324", "342.3", "??");
            ctrl.addNewIntrebare(i);
            Assert.assertTrue(ctrl.getIntrebari().size() == 0);
        }
        catch(Exception e){
            Assert.assertEquals("Prima litera din enunt nu e majuscula!", e.getMessage());
        }
    }
    @Test
    public void BBT_TC3_ECP() {
        try {
            Intrebare i = new Intrebare("", "", "", "", "");
            ctrl.addNewIntrebare(i);
            Assert.assertTrue(ctrl.getIntrebari().size() == 0);
        }
        catch(Exception e){
            Assert.assertEquals("Enuntul este vid!", e.getMessage());
        }
    }
    @Test
    public void BBT_TC4_ECP() {
        try {
            Intrebare i = new Intrebare("ce inseamna OOP?", "1) Object oriented programming", "2) raspuns gresit", "1", "Programare");
            ctrl.addNewIntrebare(i);
            Assert.assertTrue(ctrl.getIntrebari().size() == 0);
        }
        catch(Exception e){
            Assert.assertEquals("Prima litera din enunt nu e majuscula!", e.getMessage());
        }
    }
    @Test
    public void BBT_TC5_ECP() {
        try {
            Intrebare i = new Intrebare("Ce inseamna OOP?", "1) Object oriented programming", "2) raspuns gresit", "1", "");
            ctrl.addNewIntrebare(i);
            Assert.assertTrue(ctrl.getIntrebari().size() == 0);
        }
        catch(Exception e){
            Assert.assertEquals("Domeniul este vid!", e.getMessage());
        }
    }
    @Test
    public void BBT_TC1_BVA() {
        try {
            Intrebare i = new Intrebare("", "1) a", "2) b", "2", "Programare");
            ctrl.addNewIntrebare(i);
            Assert.assertTrue(ctrl.getIntrebari().size() == 0);
        }
        catch(Exception e){
            Assert.assertEquals("Enuntul este vid!", e.getMessage());
        }
    }
    @Test
    public void BBT_TC2_BVA() {
        try {
            Intrebare i = new Intrebare("Intrebare?", "1) a", "2) b", "2", "Programare");
            ctrl.addNewIntrebare(i);
            Assert.assertTrue(ctrl.getIntrebari().size() == 1);
        }
        catch(Exception e){
            Assert.assertEquals("", e.getMessage());
        }
    }
    @Test
    public void BBT_TC3_BVA() {
        try {
            Intrebare i = new Intrebare("Ce inseamna OOP?", "1) Object oriented programming", "2) raspuns gresit", "1", "Programare12345678901234567890123");
            ctrl.addNewIntrebare(i);
            Assert.assertTrue(ctrl.getIntrebari().size() == 0);
        }
        catch(Exception e){
            Assert.assertEquals("Lungimea domeniului depaseste 30 de caractere!", e.getMessage());
        }
    }
    @Test
    public void BBT_TC4_BVA() {
        try {
            Intrebare i = new Intrebare("Ce inseamna OOP?", "1) Object oriented programming", "2) raspuns gresit", "4", "Programare");
            ctrl.addNewIntrebare(i);
            Assert.assertTrue(ctrl.getIntrebari().size() == 0);
        }
        catch(Exception e){
            Assert.assertEquals("Varianta corecta nu este unul dintre caracterele {'1', '2', '3'}", e.getMessage());
        }
    }
    @Test
    public void BBT_TC5_BVA() {
        try {
            Intrebare i = new Intrebare("Ce inseamna OOP?", "1) Object oriented programming", "2) raspuns gresit1234567890123456789012345678901234567", "1", "Programare");
            ctrl.addNewIntrebare(i);
            Assert.assertTrue(ctrl.getIntrebari().size() == 0);
        }
        catch(Exception e){
            Assert.assertEquals("Lungimea variantei2 depaseste 50 de caractere!", e.getMessage());
        }
    }

    @Test
    public void WBT_TC1(){
        try{
            ctrl.addNewIntrebare(new Intrebare("In ce an suntem?", "1) 2018", "2) 2019", "1", "Istorie"));
            ctrl.addNewIntrebare(new Intrebare("Ce e OOP?", "1) object oriented programming", "2) nimic", "1", "Informatica"));
            ctrl.addNewIntrebare(new Intrebare("Cum te cheama?", "1) Alina", "2) Mihai", "1", "Social"));
            ctrl.addNewIntrebare(new Intrebare("In ce tara suntem?", "1) Franta", "2) Romania", "2", "Geografie"));
            evaluator.model.Test test = ctrl.createNewTest();
        }
        catch(Exception e){
            assertEquals("Nu exista suficiente domenii pentru crearea unui test!(5)",e.getMessage());
        }
    }

    @Test
    public void WBT_TC2(){
        try{
            ctrl.addNewIntrebare(new Intrebare("In ce an suntem?", "1) 2018", "2) 2019", "1", "Istorie"));
            ctrl.addNewIntrebare(new Intrebare("Ce e OOP?", "1) object oriented programming", "2) nimic", "1", "Informatica"));
            ctrl.addNewIntrebare(new Intrebare("Cum te cheama?", "1) Alina", "2) Mihai", "1", "Social"));
            ctrl.addNewIntrebare(new Intrebare("Ce e Windows?", "1) operating system", "2) game", "1", "Informatica"));
            evaluator.model.Test test = ctrl.createNewTest();
        }
        catch(Exception e){
            assertEquals("Nu exista suficiente domenii pentru crearea unui test!(5)",e.getMessage());
        }
    }

    @Test
    public void WBT_TC3(){
        try{
            ctrl.addNewIntrebare(new Intrebare("In ce an suntem?", "1) 2018", "2) 2019", "1", "Istorie"));
            ctrl.addNewIntrebare(new Intrebare("Ce e OOP?", "1) object oriented programming", "2) nimic", "1", "Informatica"));
            ctrl.addNewIntrebare(new Intrebare("Cum te cheama?", "1) Alina", "2) Mihai", "1", "Social"));
            ctrl.addNewIntrebare(new Intrebare("In ce tara suntem?", "1) Franta", "2) Romania", "2", "Geografie"));
            ctrl.addNewIntrebare(new Intrebare("Cat fac 2+2?", "1) 7", "2) 4", "2", "Matematica"));
            evaluator.model.Test test = ctrl.createNewTest();
            Assert.assertTrue(test.getIntrebari().size() == 5);
        }
        catch(Exception e){
            assertEquals("",e.getMessage());
        }
    }

    @Test
    public void WBT_TC4(){
        try{
            ctrl.addNewIntrebare(new Intrebare("In ce an suntem?", "1) 2018", "2) 2019", "1", "Istorie"));
            evaluator.model.Test test = ctrl.createNewTest();
        }
        catch(Exception e){
            assertEquals("Nu exista suficiente intrebari pentru crearea unui test!(5)", e.getMessage());
        }
    }

}