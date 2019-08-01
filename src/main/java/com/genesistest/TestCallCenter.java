package com.genesistest;

import java.util.Arrays;
import com.genesistest.callcenter.ICallCenter;
import com.genesistest.callcenter.QueueCallCenter;
import com.genesistest.employee.Fresher;
import com.genesistest.employee.ProductManager;
import com.genesistest.employee.TechLeader;

public class TestCallCenter {

  public static void main(String[] args) {
    ICallCenter callCenter = QueueCallCenter.getCallCenterInstance();
    callCenter.putEmployee(new Fresher("0001", Arrays.asList(1, 2)));
    callCenter.putEmployee(new Fresher("0002", Arrays.asList(1, 2)));
    callCenter.putEmployee(new TechLeader("0003", Arrays.asList(1, 2, 3, 4)));
    callCenter.putEmployee(new ProductManager("0004", Arrays.asList(1, 2, 3, 4, 5, 6)));
    System.out.println("---------------");
    // 亂數問題
    callCenter.callForRandomProblem();
    System.out.println("---------------");
    // fresh 解決問題
    callCenter.callForProblem(1);
    System.out.println("---------------");
    // fresh 無法解決問題，傳遞到techleader
    callCenter.callForProblem(3);
    System.out.println("---------------");
    // techleader 無法解決問題，傳遞到Product Manager
    callCenter.callForProblem(5);
  }

}
