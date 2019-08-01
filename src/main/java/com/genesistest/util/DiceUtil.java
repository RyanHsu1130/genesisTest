package com.genesistest.util;

public class DiceUtil {

  /**
   * @return 1~6 number
   */
  public static int roll() {
    return (int) (Math.random() * 6) + 1;
  }
}
