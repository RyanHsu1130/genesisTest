package com.genesistest.employee;

import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Logger;

public abstract class Employee {

  private static Logger logger = Logger.getLogger(Employee.class.getName());
  String name;
  // 職員的技能(數字1 ~ 6)
  List<Integer> skills;
  EmployeeType employeeType;

  public boolean solvingProblem(Integer question) {
    if (skills.contains(question)) {
      logger.info(MessageFormat.format("您的問題為 {0}  專員{1} 已幫您解決問題。", question, this.name));
      return true;
    }
    logger.info(MessageFormat.format("您的問題 {0}  專員{1}我無法解決，幫您轉接專人。", question, this.name));
    return false;
  }

  public Integer getLevel() {
    return this.employeeType.getLevel();
  }

  public Integer getLimit() {
    return this.employeeType.getLimit();
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setSkills(List<Integer> skills) {
    this.skills = skills;
  }

  public List<Integer> getSkills() {
    return this.skills;
  }
}
