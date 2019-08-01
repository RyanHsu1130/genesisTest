package test.genesistest.callcenter;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.anarsoft.vmlens.concurrent.junit.ThreadCount;
import com.genesistest.callcenter.ICallCenter;
import com.genesistest.callcenter.QueueCallCenter;
import com.genesistest.employee.Employee;
import com.genesistest.employee.EmployeeType;
import com.genesistest.employee.TechLeader;

@RunWith(ConcurrentTestRunner.class)
public class TestConcurrentPutEmployee {

  private final static int THREAD_COUNT = 5;

  @BeforeClass
  public static void initCallCenter() {
    QueueCallCenter.initialize();
  }

  @Test
  @ThreadCount(THREAD_COUNT)
  public void putTechLeaderTest() {
    ICallCenter cc = QueueCallCenter.getCallCenterInstance();
    Employee techleader = new TechLeader("0001", Arrays.asList(1, 2));
    cc.putEmployee(techleader);
  }


  @After
  public void testEmployeeNumner() {
    ICallCenter cc = QueueCallCenter.getCallCenterInstance();
    // 只能有一個tech leader
    assertEquals(Integer.valueOf(1), cc.employeeNumner(EmployeeType.TL.getLevel()));
  }
}
