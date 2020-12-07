package Project10_Vlad.Users;
import Project10_Vlad.LibraryDATA;
import java.util.*;
public abstract class Users {

    private  String user_name;
    private  String user_lastName;
    private  int userID;
   // private boolean access ;
    private boolean pastdue;


    ///////////////////// Users Constructor for manual input //////////////////////////////////
    public Users(String user_name, String user_lastName,int userID) {
        this.user_name = user_name;
        this.user_lastName = user_lastName;
       // this.access = true;
        this.pastdue = false;
        this.userID=userID;

    }
//*****************************************************************************//

       /////////////////////// Users Constructor   //////////////////////////////////
    public Users(String user_name, String user_lastName ) {
        this.user_name = user_name;
        this.user_lastName = user_lastName;
        this.userID = idGenerator();

        //this.access = true;
        this.pastdue = false;

        }
//**************************************************************************//

    ////////////////////////  Users  IdNumber  Generator /////////////////////////////////////
    public  int idGenerator(){
        int id=0;
        Random random = new Random();
        while(!LibraryDATA.getUsersID().containsKey(id)){
            id = random.nextInt(1000)+1000;
            break; }
        return  id;          }
//**************************************************************************************//

    public int getUserID() {
        return userID;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_lastName() {
        return user_lastName;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }



    /*Users:
   Each user has a name, a lastname and a four-digit userID (may have more identifiers if needed)
   userIds cannot be the the same as any other user's
   User functionalities: Each user can borrow (self check out) a book and return (check in) a book
   There are mainly three types of users: Librarian, Teacher and Student*/

}