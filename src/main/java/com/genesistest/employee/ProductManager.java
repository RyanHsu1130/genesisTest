package com.genesistest.employee;

import java.util.List;

public class ProductManager extends Employee {


  public ProductManager(String name, List<Integer> skills) {
    this.employeeType = EmployeeType.PM;
    this.name = name;
    this.skills = skills;
  }

}
