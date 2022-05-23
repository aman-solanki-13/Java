package GivenByRajSir;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/*
Given a list of integers, sort all the values present in it in descending order using Stream functions?
10,15,8,49,25,98,98,32,15


 */
public class _1_SortIntegerListUsingStream {
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
        System.out.println("The sorted values are: ");
        integerList.stream()
                .sorted((a,b) -> b.compareTo(a))
                .forEach(i -> System.out.println(i));


    }
}
