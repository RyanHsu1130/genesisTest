package test.genesistest.callcenter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import com.genesistest.callcenter.ICallCenter;
import com.genesistest.callcenter.QueueCallCenter;
import com.genesistest.employee.Employee;
import com.genesistest.employee.Fresher;
import com.genesistest.employee.ProductManager;
import com.genesistest.employee.TechLeader;

public class TestQueueCallCenter {

  @Before
  public void initialCount() {
    QueueCallCenter.initialize();
  }

  @Test
  public void putEmployeeNullTest() {
    ICallCenter cc = QueueCallCenter.getCallCenterInstance();
    boolean result = cc.putEmployee(null);
    assertFalse(result);
  }

  @Test
  public void putFresherOneTest() {
    ICallCenter cc = QueueCallCenter.getCallCenterInstance();
    Employee em = new Fresher("0001", Arrays.asList(1, 2));
    boolean result = cc.putEmployee(em);
    assertTrue(result);
  }

  @Test
  public void putTechLeaderTwoTest() {
    ICallCenter cc = QueueCallCenter.getCallCenterInstance();
    Employee tl1 = new TechLeader("0001", Arrays.asList(1, 2));
    Employee tl2 = new TechLeader("0002", Arrays.asList(1, 2));
    boolean result = cc.putEmployee(tl1);
    assertTrue(result);
    result = cc.putEmployee(tl2);
    assertFalse(result);
  }

  @Test
  public void callForProblemTest() {
    ICallCenter cc = QueueCallCenter.getCallCenterInstance();
    Employee fresh1 = new Fresher("0001", Arrays.asList(1));
    Employee fresh2 = new Fresher("0002", Arrays.asList(2));
    cc.putEmployee(fresh1);
    cc.putEmployee(fresh2);
    // 僅有fresh1，且僅能解決1 or 2
    boolean result = cc.callForProblem(1);
    assertTrue(result);
    // 測試是不是呼叫下一個Fresher
    result = cc.callForProblem(2);
    assertTrue(result);
    // 測試Fresh不能解決問題
    result = cc.callForProblem(3);
    assertFalse(result);
    System.out.println("------------------------------------------------");
    Employee techlead = new TechLeader("0003", Arrays.asList(1, 2, 3, 4));
    cc.putEmployee(techlead);
    // 測試呼叫tech leader解決問題
    result = cc.callForProblem(3);
    assertTrue(result);
    // 測試呼叫tech leader無法解決問題
    result = cc.callForProblem(5);
    assertFalse(result);
    System.out.println("------------------------------------------------");
    Employee pm = new ProductManager("0004", Arrays.asList(1, 2, 3, 4, 5, 6));
    cc.putEmployee(pm);
    // 測試呼叫ProductManager無法解決問題
    result = cc.callForProblem(5);
    assertTrue(result);
    System.out.println("------------------------------------------------");
    // 亂數測試
    result = cc.callForRandomProblem();
    assertTrue(result);
    result = cc.callForRandomProblem();
    assertTrue(result);
  }
}
