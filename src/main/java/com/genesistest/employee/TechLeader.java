package com.genesistest.employee;

import java.util.List;

public class TechLeader extends Employee {

  public TechLeader(String name, List<Integer> skills) {
    this.employeeType = EmployeeType.TL;
    this.name = name;
    this.skills = skills;
  }

}
