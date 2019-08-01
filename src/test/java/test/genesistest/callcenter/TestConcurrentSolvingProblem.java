package test.genesistest.callcenter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.anarsoft.vmlens.concurrent.junit.ThreadCount;
import com.genesistest.callcenter.ICallCenter;
import com.genesistest.callcenter.QueueCallCenter;
import com.genesistest.employee.Employee;
import com.genesistest.employee.TechLeader;

@RunWith(ConcurrentTestRunner.class)
public class TestConcurrentSolvingProblem {

  private final static int THREAD_COUNT = 2;

  List<Boolean> result = new ArrayList<Boolean>();

  @BeforeClass
  public static void initCallCenter() {
    ICallCenter cc = QueueCallCenter.initialize();
    Employee techleader = new TechLeader("0001", Arrays.asList(1, 2));
    cc.putEmployee(techleader);
  }

  @Test
  @ThreadCount(THREAD_COUNT)
  public void mutiThreadSolvingProblem() {
    ICallCenter cc = QueueCallCenter.getCallCenterInstance();
    result.add(cc.callForProblem(1));
  }


  @After
  public void testSolvingProblemResult() {
    // 同時呼叫Techleader，只能有一個呼叫成功
    assertTrue(result.get(0) || result.get(1));
    assertFalse(result.get(0) && result.get(1));
  }
}
