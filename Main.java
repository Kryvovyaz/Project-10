package Project10_Vlad;

import Project10_Vlad.Books.Books;
import Project10_Vlad.Users.Librarian;
import Project10_Vlad.Users.Teacher;
import Project10_Vlad.Users.Users;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main extends LibraryDATA {


    ////////////////    Librarian Menu    /////////////////////////////////////////////
    public static void printLibrarianmenu() {
        System.out.println("Enter" + "\n" + "|1: To see Library's inventory| " + "2:  To see active Users| " +
                "|3: to look up a user| " + "\n" + "|4: To add new user | " + "5: To add new book| " +
                "6: To Check in a book| " + "7: To check a out book|" + "\n" + "|C to Main Menu");

    }

    /*************************************************************************************/

/////////////////////  Users Menu    /////////////////////////////////////////////////
    public static void printUsersmenu() {

        System.out.println("Enter" + "\n" + "| 1: To see Library's inventory | " +
                "| 2: to see your inventory | " + "|3: to Check-in a book | " + "|4: To Check-out a book |" + "\n" + "C to Main Menu");
    }

    /*************************************************************************************************/

    //////////////////////////    Acces Menu   ///////////////////////////////////
    public static void START() {


        do {
            System.out.println("Welcome to Vlad's  Library");
            System.out.println("Please identify your self:| 1:Librerian | 2:Teacher | 3:Student");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            //Admin
            if (answer.equals("1")) {

                adminaccess(scanner);
//Teacher
            } else if (answer.equals("2")) {

                Usersaccess(scanner);
//Student
            } else if (answer.equals("3")) {
                Usersaccess(scanner);

            } else throw new RuntimeException("You can only enter 1,2,or 3");

        } while (1 != 2);
    }


    /***********************************************************************************/

    /////////////////////  Users Access   ///////////////////////////////////////////
    private static void Usersaccess(Scanner scanner) {
        System.out.println("Enter your IDNumber");
        int id2 = Integer.parseInt(scanner.nextLine());
        if(!LibraryDATA.getUsersID().containsKey(id2)){
            System.out.println("Not registered User");
        }else
        System.out.println("What do you want to do " + LibraryDATA.getUsersID().get(id2).getUser_name() + " ?");
        String answer2;
        do {
            printUsersmenu();
            answer2 = scanner.nextLine();
            switch (answer2) {
                default:
                    throw new RuntimeException("You must enter 1,2,3 or 4 ONLY");
                case "1":
                    System.out.println(LibraryDATA.printinventory());
                    break;
                case "2":
                    LibraryDATA.UserLookUP(id2);
                    break;
                case "3":
                    Librarian.createBook();
                    break;
                case "4":
                    System.out.println("Enter BookID");
                    LibraryDATA.CheckOut(id2, Integer.parseInt(scanner.nextLine()));
                    break;
                case "C":
                                }
        } while (!answer2.equals("C"));
    }
    /******************************************************************************************/

    ///////////////////////// Admin Accsess  ///////////////////////////////////
    private static void adminaccess(Scanner scanner) {
        System.out.println("Enter your IDNumber");
        int id = Integer.parseInt(scanner.nextLine());
        if(!LibraryDATA.getUsersID().containsKey(id)){
            System.out.println("Not registered User");
        }else
        System.out.println("What do you want to do " + LibraryDATA.getUsersID().get(id).getUser_name() + " ?");
        String answer1;
        do {
            printLibrarianmenu();
            answer1 = scanner.nextLine();
            switch (answer1) {
                default:  throw new RuntimeException("Enter valid input");
                case "1":
                    System.out.println(LibraryDATA.printinventory());
                    break;
                case "3":
                    System.out.println("Enter UserID");
                    LibraryDATA.UserLookUP(Integer.parseInt(scanner.nextLine()));
                    break;
                case "2":
                    System.out.println(LibraryDATA.printUsers());
                    break;
                case "4":
                    Librarian.createNewUser();
                    break;
                case "5":
                    Librarian.createBook();
                    System.out.println("New book stored");
                    break;
                case "6":
                    Librarian.createBook();
                    System.out.println("Book successfuly returned");
                    break;
                case "7":
                    System.out.println("Please enter UserID");
                    int answer3 = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please enter BookID");
                    int answer4 = Integer.parseInt(scanner.nextLine());
                    LibraryDATA.CheckOut(answer3, answer4);
                    break;
                case "C":

            }

        } while (!answer1.equals("C"));
    }
    }
    /********************************************************************/

