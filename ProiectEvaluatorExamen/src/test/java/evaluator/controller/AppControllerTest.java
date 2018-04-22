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

}