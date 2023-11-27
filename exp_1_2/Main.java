abstract class Employee{
    abstract double ComputeSalary();
}
class Manager extends Employee{
    double ComputeSalary() {    //return static salary of Manager
        return 5000;
    }
}
class Salesman extends Employee{
    int itemSold;
    double ComputeSalary(){
        return 3000 + itemSold * 200;   //when Salesman sold 1 item, they get 200
    }
}
class Worker extends Employee{
    int dayWork;

    double ComputeSalary() {
        return dayWork*200; //when Worker work 1 day, they get 150
    }
}

public class Main {
    public static void main(String[] args) {
        Manager manager1 = new Manager();
        Salesman salesman1 = new Salesman();
        Worker worker1 = new Worker();
        salesman1.itemSold=7;
        worker1.dayWork=23;
        System.out.println("Salary of manager1 is " + manager1.ComputeSalary());
        System.out.println("Salary of salesman1 is " + salesman1.ComputeSalary());
        System.out.println("Salary of worker1 is " + worker1.ComputeSalary());
    }
}