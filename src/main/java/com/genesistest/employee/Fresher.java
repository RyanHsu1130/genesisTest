package com.genesistest.employee;

import java.util.List;

public class Fresher extends Employee {

  public Fresher(String name, List<Integer> skills) {
    this.employeeType = EmployeeType.FRESHER;
    this.name = name;
    this.skills = skills;
  }


}
