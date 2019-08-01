package com.genesistest.callcenter;

import com.genesistest.employee.Employee;

public interface ICallCenter {

  /**
   * 新增員工
   * @param employee
   * @return
   */
  boolean putEmployee(Employee employee);

  /**
   * 呼叫call center解決問題(問題為亂數1~6)
   * @return 結果
   */
  boolean callForRandomProblem();

  /**
   * 呼叫call center解決問題
   * @param problem
   * @return 結果
   */
  boolean callForProblem(Integer problem);
  
  /**
   * 查詢目前特定階層有多少員工在call center
   * @param level
   * @return
   */
  Integer employeeNumner(Integer level);

}
