package com.genesistest.callcenter;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;
import com.genesistest.employee.Employee;
import com.genesistest.employee.EmployeeType;
import com.genesistest.util.DiceUtil;

public class QueueCallCenter implements ICallCenter {

  private static Logger logger = Logger.getLogger(QueueCallCenter.class.getName());
  private static QueueCallCenter callCenter = new QueueCallCenter();
  private Map<Integer, Integer> emNumner = new HashMap<Integer, Integer>();
  private Map<Integer, Queue<Employee>> idleEm = new HashMap<Integer, Queue<Employee>>();

  private QueueCallCenter() {}

  public static ICallCenter getCallCenterInstance() {
    return callCenter;
  }

  public static ICallCenter initialize() {
    callCenter = new QueueCallCenter();
    return callCenter;
  }

  @Override
  public Integer employeeNumner(Integer level) {
    return emNumner.get(level);
  }

  @Override
  public boolean putEmployee(Employee employee) {
    boolean result = false;
    if (employee == null)
      return result;
    Integer limit = employee.getLimit(), level = employee.getLevel(),
        exist = emNumner.getOrDefault(level, 0);
    if (limit <= exist) {
      logger.info(MessageFormat.format("階層 {0} 的僱員已滿，無法再新增員工。", level));
    } else {
      synchronized (this) {
        exist = emNumner.getOrDefault(level, 0);
        if (limit > exist) {
          logger.info(MessageFormat.format("新增階層 {0} 員工。", level));
          Queue<Employee> idleQ = idleEm.get(level);
          if (idleQ == null) {
            idleQ = new ConcurrentLinkedQueue<Employee>();
            idleEm.put(level, idleQ);
          }
          idleQ.add(employee);
          emNumner.put(level, exist + 1);
          result = true;
        }
      }
    }
    return result;
  }

  @Override
  public boolean callForRandomProblem() {
    Integer problem = DiceUtil.roll();
    return callForProblem(problem);
  }

  @Override
  public boolean callForProblem(Integer problem) {
    int level = EmployeeType.FRESHER.getLevel();
    boolean status = false;
    while (!status && level > 0) {
      Employee em = getIdleEmployee(level);
      if (em != null) {
        status = em.solvingProblem(problem);
        returnEmployee(level, em);
      }
      level--;
    }
    if (!status) {
      logger.info("抱歉，專員都在忙線，或是您的問題我們暫時無法解決，請稍後再撥，謝謝。");
    }
    return status;
  }

  private Employee getIdleEmployee(Integer level) {
    Queue<Employee> idleQ = idleEm.get(level);
    if (idleQ != null) {
      return idleQ.poll();
    }
    logger.info(MessageFormat.format("階層 {0}沒有空閒員工", level));
    return null;
  }

  private void returnEmployee(Integer level, Employee em) {
    idleEm.get(level).add(em);
  }



}
