package com.genesistest.employee;

public enum EmployeeType {

  PM(1, 1),
  TL(2, 1),
  FRESHER(3, Integer.MAX_VALUE);
  
  // 階層 數字越大階級越低
  private Integer level;
  // 人數限制
  private Integer limit;

  private EmployeeType(Integer level, Integer limit) {
    this.level = level;
    this.limit = limit;
  }

  public Integer getLevel() {
    return this.level;
  }

  public Integer getLimit() {
    return this.limit;
  }
}
