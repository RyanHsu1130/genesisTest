# genesisTest

題目描述


Imagine you have a call center with three levels of employees: fresher, technical lead (TL), product manager (PM). There can be multiple employees, but only one TL or PM. An incoming telephone call must be allocated to a fresher who is free. If no freshers are free, or if the current fresher is unable to solve the caller's problem (determined by a simple dice roll), he or she must escalate the call to technical lead. If the TL is not free or not able to handle it, then the call should be escalated to the PM.

What we would like to see:

1. Create an object-oriented design for this problem. The flexible design which can be extended is preferred.

2. Do this in an object-oriented programming language that you're comfortable with.

3. Compliable runnable and testable code.

4. Document your code.

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

