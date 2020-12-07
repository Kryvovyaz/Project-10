package Project10_Vlad.Users;

import Project10_Vlad.Books.Books;
import Project10_Vlad.LibraryDATA;

/* Teacher:
      Teachers' userID always starts with 2. (For example: 2541)
      A teacher can borrow at most 5 books AT A TIME
      A teacher can borrow any book for at most for 21 days.*/
public class Teacher extends Users {

    public Teacher(String user_name, String user_lastName, int userID) {
        super(user_name, user_lastName, userID);

    }

    public Teacher(String user_name, String user_lastName) {
        super(user_name, user_lastName);
        setUserID(idGenerator()+1000);
    }

}


