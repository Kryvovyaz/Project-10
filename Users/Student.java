package Project10_Vlad.Users;

import Project10_Vlad.Books.Books;
import Project10_Vlad.LibraryDATA;

/*Student:
      Students' userID always starts with 3. (For example: 3999)
      A student can borrow at most 3 books AT A TIME
      A student can borrow any book for at most for 14 days.*/
public class Student extends Users{


    public Student(String user_name, String user_lastName, int userID) {
        super(user_name, user_lastName, userID);
    }

    public Student(String user_name, String user_lastName) {
        super(user_name, user_lastName);
        setUserID(idGenerator()+2000);
    }


}
