package TEST;

import java.io.*;
import java.util.Scanner;

public class MainApp {
    static class Contact {
        private String name;
        private int yearOfMeeting;
        private String city;

        Contact(String name, int yearOfMeeting, String city){
            this.name = name;
            this.yearOfMeeting = yearOfMeeting;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public int getYearOfMeeting() {
            return yearOfMeeting;
        }


        public String getCity() {
            return city;
        }

        void printDetails(){
            System.out.printf("Name: %s, Year of meeting: %d, City: %s", getName(),getYearOfMeeting(), getCity());
        }
    }



    public static void main(String[] args) throws IOException {
        String name;
        int yearOfMeet;
        String city;

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the file name that has friends' info");
        String fileName = scanner.nextLine();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName + ".txt"));

        while ((name = bufferedReader.readLine()) != null){
            yearOfMeet = Integer.parseInt(bufferedReader.readLine());

            System.out.println("--------");
            System.out.println(name);
            System.out.println(yearOfMeet);
            System.out.println("----------");

            System.out.println("Do you want to add " + name + " to the list ?");
            String input = scanner.nextLine();
            if (input.equals("y")){
                System.out.println("Enter address of " + name);
                city = scanner.nextLine();

                Contact contact = new Contact(name, yearOfMeet, city);

                if ((yearOfMeet <= 2000)){
                    File file = new File("OldFriendReport.txt");

//                    FileWriter fileWriter = new FileWriter(file, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                    bufferedWriter.write("The friend name is " + contact.getName() + " I met him/her in " + contact.getYearOfMeeting() + ". He/She is now in " + contact.getCity() + "\n");
                    bufferedWriter.close();

                }else{
                    File file = new File("NewFriendReport.txt");

//                    FileWriter fileWriter = new FileWriter(file, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                    bufferedWriter.write("The friend name is " + contact.getName() + " I met him/her in " + contact.getYearOfMeeting() + ". He/She is now in " + contact.getCity() + "\n");
                    bufferedWriter.close();
                }

            }else{
                continue;
            }

            System.out.println();
        }
        bufferedReader.close();

    }
}
