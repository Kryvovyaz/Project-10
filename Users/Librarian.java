package Project10_Vlad.Users;

import Project10_Vlad.Books.Books;
import Project10_Vlad.Books.Fiction_Books;
import Project10_Vlad.Books.Non_Fiction_Books;
import Project10_Vlad.Books.Reference_Books;
import Project10_Vlad.LibraryDATA;

import java.util.Scanner;

/*Librarian:
        Librarians' userId always starts with 1. (For example: 1000)
        Borrowing book: A librarian can borrow at most 10 books AT A TIME for himself/herself
        A librarian can borrow any book for at most for 30 days.
        Librarian has also three extra functionalities:
        Create a user (teacher, student and/or another librarian)
        Create a book (fiction, non-fiction or reference)
        Give(check out) a book to a user*/
public class Librarian extends Users {

    public Librarian(String user_name, String user_lastName, int userID) {
        super(user_name, user_lastName, userID);
    }

    public Librarian(String user_name, String user_lastName) {
        super(user_name, user_lastName);
    }


    ///////////////////   Creating of a new User  ////////////////////////////////////////////
    public static void createNewUser() throws RuntimeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What type of user do you want to create: 1-Admin 2-Techer 3- Student");

        String user = scanner.nextLine();
        System.out.println("User's name");
        String name = scanner.nextLine();
        System.out.println("User's last name");
        String lastname = scanner.nextLine();

        switch (user) {
            case "1":
                Librarian librarian = new Librarian(name, lastname);
                LibraryDATA.addUser(librarian);
                break;

            case "2":
                Teacher teacher = new Teacher(name, lastname);
                LibraryDATA.addUser(teacher);
                break;

            case "3":
                Student student = new Student(name, lastname);
                LibraryDATA.addUser(student);
                break;
            default:
                throw new RuntimeException("You have to enter 1 or 2 or 3 only");
        }
    }

    /******************************************************************************************************/
    ///////////////// Creating new Book ////////////////////////////////////////////////////////////
    public static void createBook() throws RuntimeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What type of book do you have: 1-Fiction Books 2-Non-Fiction Books 3- Reference Books");
        //TODO:loop or trycatch
        String type = scanner.nextLine();
        ///////////////////////////////
        System.out.println("Enter Book's name");
        String name = scanner.nextLine();
        System.out.println("Enter Author");
        String author = scanner.nextLine();
        switch (type) {
            case "1":
                Fiction_Books fiction_books = new Fiction_Books(name, author);
                LibraryDATA.addBook(fiction_books);
                break;
            case "2":
                Non_Fiction_Books non_fiction_books = new Non_Fiction_Books(name, author);
                LibraryDATA.addBook(non_fiction_books);
                break;
            case "3":
                Reference_Books reference_books = new Reference_Books(name, author);
                LibraryDATA.addBook(reference_books);
                break;
            default:
                throw new RuntimeException("You have to enter 1 or 2 or 3 only");
        }

    }
/***********************************************************************************************************************/

}