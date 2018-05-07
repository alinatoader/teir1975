package evaluator;

import evaluator.model.Intrebare;
import evaluator.model.Statistica;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alina on 5/6/2018.
 */
public class TopDown {
    AppController ctrl;

    @Before
    public void setUp() throws Exception {
        ctrl = new AppController();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void cerinta1() {
        try {
            ctrl.addNewIntrebare(new Intrebare("In ce an suntem?", "1) 2018", "2) 2019", "1", "Istorie"));
            ctrl.addNewIntrebare(new Intrebare("Ce e OOP?", "1) object oriented programming", "2) nimic", "1", "Informatica"));

            Assert.assertTrue(ctrl.getIntrebari().size() == 2);
        }
        catch(Exception e){
            Assert.assertEquals("", e.getMessage());
        }
    }

    @Test
    public void cerinta12() {
        try {
            ctrl.addNewIntrebare(new Intrebare("In ce an esti?", "1) 2018", "2) 2019", "1", "Istorie"));
            Assert.assertTrue(ctrl.getIntrebari().size() == 1);

            ctrl.addNewIntrebare(new Intrebare("Ce este OOP?", "1) object oriented programming", "2) nimic", "1", "Informatica"));
            Assert.assertTrue(ctrl.getIntrebari().size() == 2);

            ctrl.addNewIntrebare(new Intrebare("Cum te cheama?", "1) Alina", "2) Mihai", "1", "Social"));
            Assert.assertTrue(ctrl.getIntrebari().size() == 3);

            ctrl.addNewIntrebare(new Intrebare("In ce tara suntem?", "1) Franta", "2) Romania", "2", "Geografie"));
            Assert.assertTrue(ctrl.getIntrebari().size() == 4);

            ctrl.addNewIntrebare(new Intrebare("Cat fac 2+2?", "1) 7", "2) 4", "2", "Matematica"));
            Assert.assertTrue(ctrl.getIntrebari().size() == 5);

            evaluator.model.Test test = ctrl.createNewTest();
            Assert.assertTrue(test.getIntrebari().size() == 5);
        }
        catch(Exception e){
            Assert.assertEquals("", e.getMessage());
        }
    }

    @Test
    public void integrare(){
        try {
            ctrl.addNewIntrebare(new Intrebare("In ce an suntem?", "1) 2018", "2) 2019", "1", "Istorie"));
            Assert.assertTrue(ctrl.getIntrebari().size() == 1);
            ctrl.addNewIntrebare(new Intrebare("Ce e OOP?", "1) object oriented programming", "2) nimic", "1", "Informatica"));
            Assert.assertTrue(ctrl.getIntrebari().size() == 2);
            ctrl.addNewIntrebare(new Intrebare("Cum te cheama?", "1) Alina", "2) Mihai", "1", "Social"));
            Assert.assertTrue(ctrl.getIntrebari().size() == 3);
            ctrl.addNewIntrebare(new Intrebare("In ce tara suntem?", "1) Franta", "2) Romania", "2", "Geografie"));
            Assert.assertTrue(ctrl.getIntrebari().size() == 4);
            ctrl.addNewIntrebare(new Intrebare("Cat fac 2+2?", "1) 7", "2) 4", "2", "Matematica"));
            Assert.assertTrue(ctrl.getIntrebari().size() == 5);
            evaluator.model.Test test = ctrl.createNewTest();
            Assert.assertTrue(test.getIntrebari().size() == 5);
            Statistica s = ctrl.getStatistica();
            assertEquals(5,s.getIntrebariDomenii().size());
        }
        catch(Exception e){
            Assert.assertEquals("", e.getMessage());
        }
    }
}
