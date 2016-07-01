package enterprise.module_1;

import enterprise.module_1.Evaluator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class EvaluatorTest {

    @Test
    public void getSizeResultForArrayListTest() throws Exception {
        Evaluator evaluator = new Evaluator();
        evaluator.evaluate(10000);
        int actual = evaluator.getResultForArrayList().size();
        assertEquals(8, actual);

    }

    @Test
    public void checkElementIsNotNullFromResultForLinkedListTest() throws Exception {
        Evaluator evaluator = new Evaluator();
        evaluator.evaluate(10000);
        String actual = evaluator.getResultForArrayList().get(1);
        System.out.println(actual);
        assertNotNull(actual);

    }
}