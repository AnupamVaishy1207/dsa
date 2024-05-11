package CDAC.Assignments.Assignment2;

class Employee {
    private int id;
    private String name;
    private double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }


}

public class SortEmployeeBySalary {
    public static void sortEmployeeBySalary(Employee emp[], int size) {
        for (int i = 1; i < size; i++) {
            double temp = emp[i].getSalary();
            int j = i - 1;
            if (j >= 0 && emp[j].getSalary() > temp) {
                emp[j + 1].setSalary(emp[j].getSalary());
                j--;
            }
            emp[j+1].setSalary(temp);
        }
    }

    public static void main(String args[]) {
        Employee emp[] = new Employee[5];
        emp[0] = new Employee(1, "Anupam", 90000.00);
        emp[1] = new Employee(2, "OM", 30000.00);
        emp[2] = new Employee(3, "Mousam", 20000.00);
        emp[3] = new Employee(4, "Akshit", 60000.00);
        emp[4] = new Employee(5, "Vivek", 50000.00);
        
        for (int i=0;i<emp.length;i++){
            System.out.println("Employee before Sorted "+emp[i]);
          
        }
            
        for (int i=0;i<emp.length;i++){
            sortEmployeeBySalary(emp, emp.length);
            System.out.println("Employee After Sorted "+emp[i]);
        }
        

    }
}
