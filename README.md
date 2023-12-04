GZHU grade 11 Java experiments personal backup.
=====
This repository is created for personal backup.  
Highly NOT recommand using codes in this repo to submit homework.  

experiment 1  
---
* 1.1 编写一个 Java 应用程序，在主类的 main 方法中实现下列功能。  
程序随机分配给用户一个 1 至 100 之间的整数   
用户通过键盘输人自己的猜测   
程序返回提示信息，提示信息分别是:“猜大了”、“猜小了”和“猜对了”   
用户可根据提示信息再次输入猜测，直到提示信息是“猜对了”   
用户猜对以后，显示猜测次数，并提供“重新开始”和“退出”功能   
* 1.2 假定要为某个公司编写雇员工资支付程序，这个公司有各种类型的雇员(Employee)，不同类型的雇员按不同的方式支付工资:  
经理(Manager):每月获得一份固定的工资   
销售人员(Salesman):在基本工资的基础上每月还有销售提成  
工人(Worker):按照每月工作的天数计算工资   

experiment 2  NOT DONE YET  
---
* 1.1 编写 Java 应用程序，实现以下登陆界面(需注意密码框输入的内容不显示明文):  
<img width="457" alt="image" src="https://github.com/Endermen359872/grade11Java/assets/78783001/5b8bf8f2-93a5-4f52-a5ea-bc884699731e"><br>
* 1.2 编写 Java 应用程序，实现以下界面:  
<img width="457" alt="image" src="https://github.com/Endermen359872/grade11Java/assets/78783001/71265a87-c2cb-4e8e-ba17-e19b8d683213"><br>
* 1.3 编写一个 Java 多线程应用程序，完成三个售票窗口同时出售 20 张票。具体要求如下:  
票数要使用同一个静态值，为保证不会出现卖出同一个票数，要 java 多线程同步锁。  
设计思路:  
创建一个站台类 Station，继承 Thread，重写 run 方法，在 run 方法里面执行售票操作。  
售票要使用同步锁:即有一个站台卖这张票时，其他站台要等这张票卖完，创建主方法调用类。
运行效果如下图：
![image](https://github.com/Endermen359872/grade11Java/assets/78783001/4484dbec-de44-4986-bbc8-816a749435d2)<br>

experiment 3  
---
编写一个 Java 应用程序，实现图形界面多人聊天室(多线程实现)，要求聊天室窗口标题是 “欢迎使用 XXX 聊天室应用”，其中 XXX 是自己的班级姓名学号，如“软件 171 张三 1234”。
