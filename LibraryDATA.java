package Project10_Vlad;

import Project10_Vlad.Books.Books;
import Project10_Vlad.Books.Fiction_Books;
import Project10_Vlad.Books.Non_Fiction_Books;
import Project10_Vlad.Books.Reference_Books;
import Project10_Vlad.Users.Librarian;
import Project10_Vlad.Users.Student;
import Project10_Vlad.Users.Teacher;
import Project10_Vlad.Users.Users;

import java.util.*;

public class LibraryDATA {

    private static LinkedHashMap<Integer, Users> usersID = new LinkedHashMap<>();

    private static LinkedHashMap<Integer, Books> inventory = new LinkedHashMap<>();

    public static LinkedHashMap<Integer, ArrayList<Books>>usersInventory = new LinkedHashMap<>();

    public static HashMap<Integer, Users> getUsersID() {
        return usersID;
    }

    public static HashMap<Integer, Books> getInventory() {
        return inventory;
    }


    static {
        addUser(new Librarian("Muharrem", "Admin", 1001));
        addUser(new Librarian("Sarah", "Perry", 1002));
        addUser(new Teacher("Brian", "Cummins", 2001));
        addUser(new Teacher("Vlad", "Kryv", 2002));
        addUser(new Student("Nataly", "Student", 3001));
        addUser(new Student("Dzemal", "Crnkic", 3002));
        addUser(new Student("Turkana", "Mammadova", 3003));


        addBook(new Fiction_Books("War and Peace", 10001, "Tolstoy"));
        addBook(new Fiction_Books("Idiot", 10002, "Dostoyevskiy"));
        addBook(new Fiction_Books("Master and Margarita", 10003, "Bulgakov"));
        addBook(new Fiction_Books("Yevgeny Onegin", 10004, "Pushkin"));
        addBook(new Fiction_Books("Romeo and Julietta", 10005, "Shekspir"));
        addBook(new Fiction_Books("Monte Kristo", 10006, "Dyuma"));
        addBook(new Fiction_Books("Ayvengo", 10007, "Sccott"));


        addBook(new Non_Fiction_Books("Java Fundamental", 20001, "Oracle"));
        addBook(new Non_Fiction_Books("Java For Beginers", 20002, "Oracle"));
        addBook(new Non_Fiction_Books("Java Script", 20003, "Oracle"));
        addBook(new Non_Fiction_Books("Advanced Math", 20004, "Conaway"));


        addBook(new Reference_Books("Marriage Catalog", 30002, "City"));
        addBook(new Reference_Books("Reference Books 1", 30002, "Author1"));
        addBook(new Reference_Books("Reference Books 2", 30003, "Author2"));

    }

    ///////////////////////////////  LOOKUP THE USER  ////////////////////////////////
    public static void UserLookUP(int userID) {
        if (!usersID.containsKey(userID)) {
            System.out.println("User is not registered");
        } else {

            if(usersInventory.get(userID)!=null){
                System.out.println(usersInventory.get(userID));}
            else {
                System.out.println("NO books has been borrowed");
            }
        }

    }

    /////////////////////////////////   CHEKOUT A BOOK  //////////////////////////////

   public static void CheckOut(int UserId,int BookID) {
       if (!inventory.entrySet().isEmpty()) {
           if(!((usersID.get(usersID) instanceof Teacher)&&(usersInventory.get(usersID).size()<=5))||((usersID.get(usersID) instanceof Student)&&(usersInventory.get(usersID).size()<=3))||((usersID.get(usersID) instanceof Librarian)&&(usersInventory.get(usersID).size()<=10))){

             if (!(inventory.get(BookID) instanceof Reference_Books)) {

               ArrayList<Books> userList = usersInventory.get(UserId);
               if (userList == null) {
                   userList = new ArrayList<>();
                   usersInventory.put(UserId, userList);
               }
               userList.add(inventory.get(BookID));
               inventory.remove(BookID);

           } else System.out.println("Reference books are NOT borrowable");
       }else System.out.println("You exceeded your limit");
   }else System.out.println("Labrary has no book to borrow.The are Reference books only");


    }
    /********************************************************************************/

    /////////////////////// ADD/RETURN BOOK TO THE LIBRARY   /////////////////////////
    public static void addBook(Books book) {
        inventory.put(book.getBookID(), book);
    }
    /********************************************************************************/

    /////////////////////   Add User to the Library //////////////////////////////////
    public static void addUser(Users user) {
        if(!usersID.containsKey(user.getUserID())){

        usersID.put(user.getUserID(), user);
    }
        else System.out.println("User already Exist");}
    /********************************************************************************/

    //////////////   Print Library's  Inventory  /////////////////////////////////////

    public static String printinventory() {
        String s = "";
        Set<Integer> set = inventory.keySet();
        System.out.println("Collection of books:");
        for (Integer key : set) {
            s += "| BookID: " + getInventory().get(key).getBookID() + "| Name: " + getInventory().get(key).getName() + "| Author: " + getInventory().get(key).getAuthor() + "\n";
        }
        return s;
    }

    //********************************************************************************//
    ///////////////////////////  Print Library's Users  ////////////////////////////////
    public static String printUsers() {
        String s = "";
        Set<Integer> set = usersID.keySet();
        System.out.println("Available users:");
        for (Integer key : set) {
            s += "UserID: " + getUsersID().get(key).getUserID() + "| Name: " + getUsersID().get(key).getUser_name() + "| LastName: " + getUsersID().get(key).getUser_lastName() + "\n";
        }

        return s;
    }

    /***********************************************************************************/
    public static void main(String[] args) {

        System.out.println(printinventory());
        System.out.println(printUsers());
    }
}