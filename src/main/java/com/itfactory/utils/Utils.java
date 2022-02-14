package com.itfactory.utils;

import java.util.Scanner;

import com.itfactory.model.Course;
import com.itfactory.model.Student;


public class Utils {
    private static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void printHeader() {
        System.out.println("*--------------------------*");
        System.out.println("|    Bine ați venit în     |");
        System.out.println("|        aplicație         |");
        System.out.println("*--------------------------*");
    }

    public static void printMenu() {
        System.out.println("    MENIU: \n" +
                "0 - Ieșire din program.\n" +
                "1 - Afișează cursuri.\n" +
                "2 - Introduceți un curs nou.\n" +
                "3 - Inrolati un student nou la curs.\n");

    }

    public static int getInput() {
        int optiune = -1;
        //bucla while care se aplica atunci cand userul selecteaza o optiune din afara meniului
        while (optiune < 0 || optiune > 4) {
            try {
                System.out.print("Introduceti optiunea: ");
                optiune = Integer.parseInt(scanner.nextLine());
                if (optiune < 0 || optiune > 3) {
                    System.out.println("Numarul introdus trebuie sa fie un intreg de la 0 la 3\n");
                    printMenu();
                }
            } catch (NumberFormatException e) {
                System.out.println("Optiune invalida. Incercati din nou.\n");
                printMenu();
            }
        }
        return optiune;
    }

    public static Course citesteCurs() throws NumberFormatException {
        System.out.print("ID curs: ");
        int courseId = Integer.parseInt(scanner.nextLine());

        System.out.print("NUME curs: ");
        String courseName = scanner.nextLine();

        System.out.print("PRET curs: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.println("**********************\nDatele cursului introdus sunt:\n" +
                "Curs ID: " + courseId +
                ", Nume curs: " + courseName + ", Pret($): " + price + "\n");
        //Se poate folosi secventa de mai jos in loc de return new etc.????
        //Course course = citesteDateCurs();
        //return course;
        return new Course(courseId, courseName, price);
    }

    public static Student citesteDateCursant() {
        System.out.print("ID student: ");
        int studentId = Integer.parseInt(scanner.nextLine());

        System.out.print("NUME student: ");
        String studentName = scanner.nextLine();

        System.out.print("BUGET student: ");
        double budget = Double.parseDouble(scanner.nextLine());

        System.out.println("Ati introdus datele studentului: " + studentName +
                ", " + studentId + ", " + budget);
        //Student student = citesteDateCursant();
        //return student;
        return new Student(studentId, studentName, budget);

    }

}
