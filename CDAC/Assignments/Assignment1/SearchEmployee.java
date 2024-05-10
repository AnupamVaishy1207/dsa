package CDAC.Assignments.Assignment1;
class Employee {
    int id;
    String name;
    double salary;
    Employee(int id,String name,double salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }

}
public class SearchEmployee {
    public static int searchEmployeeById(Employee emp[],int size,int key){
        for(int i=0;i<size;i++){
            if(key==emp[i].id){
                return i;
            }
        }
        return -1;
    }
    public static int searchEmployeeByName(Employee emp[],int size,String key){
        for(int i=0;i<size;i++){
            if(key==emp[i].name){
                return i;
            }
        }
        return -1;
    }
    public static int searchEmployeeBySalary(Employee emp[],int size,double key){
        for(int i=0;i<size;i++){
            if(key==emp[i].salary){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
       Employee emp[]=new Employee[5];
    emp[0]=new Employee(1,"Anupam",10000.00);
    emp[1]=new Employee(2,"OM",30000.00);
    emp[2]=new Employee(3,"Mousam",40000.00);
    emp[3]=new Employee(4,"Akshit",60000.00);
    emp[4]=new Employee(5,"Vivek",80000.00);
    int key=4;
    int index=searchEmployeeById(emp, emp.length, key);
    if(index!=-1)
    System.out.println("Employee Found at index number "+index);
    else
    System.out.println("Employee not found");
    //========================NAME=====================================
    String name="Vivek";
     index=searchEmployeeByName(emp, emp.length, name);
    if(index!=-1)
    System.out.println("Employee Found at index number "+index);
    else
    System.out.println("Employee not found");
    //=======================SALARY======================================
    Double sal=30000.00;
     index=searchEmployeeBySalary(emp, emp.length, sal);
    if(index!=-1)
    System.out.println("Employee Found at index number "+index);
    else
    System.out.println("Employee not found");

   
        
    }
}
