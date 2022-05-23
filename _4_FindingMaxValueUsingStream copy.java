package GivenByRajSir;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
Given a list of integers, find the maximum value element present in it using Stream functions?
10,15,8,49,25,98,98,32,15
 */
public class _2_FindingMaxValueUsingStream {
        public static void main(String[] args) {
            System.out.println("Please enter the number of elements for the array: ");
            Scanner scanner = new Scanner(System.in);
            int numberOfElements = scanner.nextInt();
            List<Integer> integerList = new ArrayList<>();
            System.out.println("Please enter the values:");
            while (numberOfElements > 0){
                int element = scanner.nextInt();
                integerList.add(element);

                numberOfElements -= 1;
            }

            System.out.println("The max value in the arrays is: " +
                    integerList.stream()
                            .max((a,b) -> a.compareTo(b))
                            .get()
            );


    }
}

