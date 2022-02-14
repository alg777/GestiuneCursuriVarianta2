package com.itfactory;

import com.itfactory.data.DataLoader;
import com.itfactory.model.*;
import com.itfactory.utils.DataLoaderUtils;
import com.itfactory.utils.Utils;

import java.util.*;

import static com.itfactory.utils.DataLoaderUtils.mapCursuri;
import static com.itfactory.utils.Utils.*;

public class Main {
    DataLoader dataLoader = new DataLoader();
    //aici vreau sa apelez metoda loadData() din DataLoader
    // si nu imi merge. Exemplu:
    //dataLoader.loadData()


    //initializam un HashMap gol
    //initializam cu un ArrayList gol
    //apelam metoda LoadData() din clasa DataLoader




    //CONSOLA INTERACTIVA
    public static void main(String[] args) {
        printHeader();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            performActions(scanner);
        }
    }

    private static void performActions(Scanner scanner) {
        printMenu();
        int optiune = getInput();
        switch (optiune) {
            case 0: {
                System.out.println("Salvezi datele?");
                System.out.println("Ati iesit din program. Va multumim ca ati folosit aplicatia noastra");
                System.exit(0);
            }
            break;
            case 1: {
                if (mapCursuri.isEmpty()) {
                    System.out.println("- La aceasta data nu aveti cursuri in lista.\n");
                } else {
                    System.out.println("\nCURSURI IN LISTA");
                    afiseazaCursuri(mapCursuri);
                    System.out.println("");
                }
            }
            break;
            case 2: {
                introducetiCursNou(mapCursuri);
            }
            break;
            case 3: {
                inrolatiStudent(mapCursuri, scanner);
            }
//            break;
//            case 4: {
//                printMenu();
//            }
            break;
            default:
                System.out.println("Eroare necunoscuta");
        }

    }

    private static void afiseazaCursuri(Map<Course, List<Student>> map) {
        Set<Course> listaDeCursuri = map.keySet();
        for (Course course : listaDeCursuri) {
            System.out.println(": " + course);
        }
    }

    private static void introducetiCursNou(Map<Course, List<Student>> map) {
        System.out.println("Ati ales introducerea unui curs nou");
        Course courseNou = Utils.citesteCurs();
        map.put(courseNou, new ArrayList<>());
    }

    private static void inrolatiStudent(Map<Course, List<Student>> mapCursuri, Scanner scanner) {
        System.out.println("Ati ales inrolarea unui student nou la curs.");
        //Aici verificam si AFISAM cursurile DISPONIBILE
        int cursuriDisponibile = 0; //mai jos, citeste FIECARE curs cu lista lui de studenti
        // ca pe un entry, si verifica cati studenti sunt inrolati
        //apoi creste nrCursDisponibile cu 1, daca nrStudenti<7.
        System.out.println("CURSURI DISPONIBILE");
        for (Map.Entry<Course, List<Student>> entry : mapCursuri.entrySet()) {
            if (entry.getValue().size() < 7) { //if pt buget
                System.out.println(entry.getKey());
                cursuriDisponibile++;//aici sus, continua bucla for pana termina toate cursurile+listele asociate.

            } else {
                System.out.println("Cursul de " + entry.getKey().getCourseName() + " NU mai este disponibil.");
                //vrem sa-l stergem din map Cum???
                //mapCursuri.remove(entry.getKey());
                //vreau sa fac o lista cu cursuri indisponibile
            }
        }

        System.out.print("\nIntroduceti id curs solicitat: ");
        int idCourseDorit = Integer.parseInt(scanner.nextLine());
        Course cursDorit = null;

        Set<Course> courseSet = mapCursuri.keySet();//aici parcurge setul de cursuri si verifica daca cursul dorit e in lista
        //cand l-a gasit iese din bucla, deci nu mai verifica
        for (Course course : courseSet) {
            if (idCourseDorit == course.getCourseId()) {
                cursDorit = course;
                System.out.println("Cursul solicitat este: " + cursDorit.getCourseName());
                break;
            }
        }


        if (cursDorit != null) {

            //aici, jos, a terminat de numarat si verifica daca avem cursuri disponibile
            if (cursuriDisponibile == 0) {
                System.out.println("Nu este nici un curs disponibil");
            } else {
                Student student = Utils.citesteDateCursant();
                mapCursuri.get(cursDorit).add(student);
                double a = student.getBudget() - cursDorit.getPrice();
                System.out.print("-->> Studentul " + student.getStudentName() +
                        " a fost inrolat cu succes la cursul de " + cursDorit.getCourseName() + "!\n");

                student.setBudget(a);
                System.out.print("-->> Studentul " + student.getStudentName() + " mai dispune de " + a + " lei\n");
//                for (Map.Entry<Course, List<Student>> entry : mapCursuri.entrySet()) {
//                    System.out.println(entry.getKey()+ "   "
//                            +entry.getValue());
//                }
            }
        }
    }
}

