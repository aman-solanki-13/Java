package Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Department implements Comparable<Department>{
    String deptName;

    Department(String deptName){
        this.deptName = deptName;
    }

    @Override
    public int compareTo(Department d) {
        return deptName.compareTo(d.deptName);
    }

    @Override
    public String toString() {
        return deptName;
    }
}

public class _2SortingDepartmentNamesUsingComparatorInterface {
    public static void main(String[] args) {
        ArrayList<Department> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of departments. Enter 'done' when done adding the department names.");
        //Adding department objects to the arrayList
        while (true){
            String deptName = scanner.nextLine().toLowerCase();
            if(deptName.equals("done")){
                break;
            }else {
            Department department = new Department(deptName);
            arrayList.add(department);
            }
        }
        Collections.sort(arrayList);
        arrayList.forEach((element) -> System.out.printf("%s\t",element.deptName.substring(0,1).toUpperCase() + element.deptName.substring(1).toLowerCase()));


    }
}
