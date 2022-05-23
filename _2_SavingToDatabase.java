package com.example.springjdbcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
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

@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {


    private final JdbcTemplate jdbcTemplate;

    public SpringJdbcDemoApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcDemoApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        int id = 0;
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
                String deptNames = department.deptName;
                String query1 = "INSERT INTO department_table VALUES (?,?)";
                id++;
                jdbcTemplate.update(query1,id, department.deptName);
                arrayList.add(department);
            }
        }
        Collections.sort(arrayList);
        arrayList.forEach((element) -> System.out.printf("%s\t",element.deptName.substring(0,1).toUpperCase() + element.deptName.substring(1).toLowerCase()));

    }

    }


