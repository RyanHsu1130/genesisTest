# genesisTest
專案依賴

1. java 1.8
2. maven
3. junit

開發環境

1. eclipse

## Run

 run com.genesistest.TestCallCenter main()

## Test

在src/test/java上，run as Junit test。

測試包含single thread 和 muti thread。

## Class Diagram

#### Call Center

![CallCenter](https://github.com/RyanHsu1130/genesisTest/blob/master/src/main/java/classDiagram/CallCenter.png)

#### Employee

![Employee](https://github.com/RyanHsu1130/genesisTest/blob/master/src/main/java/classDiagram/Employee.png)

## 擴充

要新增員工種類，只要在EmployeeType新增一種員工，並新增類別繼承Employee。

要新增Call Center的實作方式，只需要實作ICallCenter即可。

