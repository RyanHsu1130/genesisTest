package test.genesistest.employee;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.Test;
import com.genesistest.employee.Employee;
import com.genesistest.employee.Fresher;

public class TestEmployee {

  @Test
  public void testSolveProblem() {
    Employee em = new Fresher("0001", Arrays.asList(1, 2));
    boolean result = em.solvingProblem(1);
    assertTrue(result);
    result = em.solvingProblem(3);
    assertFalse(result);
  }

}
