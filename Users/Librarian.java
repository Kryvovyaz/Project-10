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
public class Librarian extends Users implements Cloneable {

    public Librarian(String user_name, String user_lastName, int userID) {
        super(user_name, user_lastName, userID);
    }

    public Librarian(String user_name, String user_lastName) {
        super(user_name, user_lastName);
    }



    /******************************************************************************************************/

}