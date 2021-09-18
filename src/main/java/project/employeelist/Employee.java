package project.employeelist;

/**
 *
 * @author vansh
 */

public class Employee implements Comparable<Employee> {

     private String empName;
     private double rate;
     private double hoursWorked;

     public Employee(){
         this.empName = "noName";
         this.rate = 0;
         this.hoursWorked = 0;
     }

     public Employee(String empName, double rate, double hoursWorked) {
        this.empName = empName;
        this.rate = rate;
        this.hoursWorked = hoursWorked;
    }

    public String getEmpName() {
        return empName;
    }

    public String toString(){
                 return empName+","+rate+","+hoursWorked;
             }


    @Override
    public int compareTo(Employee o) {
        int namecom = empName.compareToIgnoreCase(o.empName);
        return namecom;

    }
}
