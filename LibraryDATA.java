package Project10_Vlad;

import Project10_Vlad.Books.Books;
import Project10_Vlad.Books.Fiction_Books;
import Project10_Vlad.Books.Non_Fiction_Books;
import Project10_Vlad.Books.Reference_Books;
import Project10_Vlad.Users.Librarian;
import Project10_Vlad.Users.Student;
import Project10_Vlad.Users.Teacher;
import Project10_Vlad.Users.Users;

import java.nio.channels.ScatteringByteChannel;
import java.util.*;

public class LibraryDATA {

    private static LinkedHashMap<Integer, Users> usersID = new LinkedHashMap<>();

    private static LinkedHashMap<Integer, Books> inventory = new LinkedHashMap<>();

    private static LinkedHashMap<Integer,ArrayList<Integer>>usersInventory = new LinkedHashMap<>();

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


        addBook(new Fiction_Books("War and Peace", 10001, "Tolstoy",10));
        addBook(new Fiction_Books("Idiot", 10002, "Dostoyevskiy",6));
        addBook(new Fiction_Books("Master and Margarita", 10003, "Bulgakov",2));
        addBook(new Fiction_Books("Yevgeny Onegin", 10004, "Pushkin",0));
        addBook(new Fiction_Books("Romeo and Julietta", 10005, "Shekspir",12));
        addBook(new Fiction_Books("Monte Kristo", 10006, "Dyuma",4));
        addBook(new Fiction_Books("Ayvengo", 10007, "Sccott",3));


        addBook(new Non_Fiction_Books("Java Fundamental", 20001, "Oracle",15));
        addBook(new Non_Fiction_Books("Java For Beginers", 20002, "Oracle",11));
        addBook(new Non_Fiction_Books("Java Script", 20003, "Oracle",0));
        addBook(new Non_Fiction_Books("Advanced Math", 20004, "Conaway",4));


        addBook(new Reference_Books("Marriage Catalog", 30002, "City",6));
        addBook(new Reference_Books("Reference Books 1", 30002, "Author1",4));
        addBook(new Reference_Books("Reference Books 2", 30003, "Author2",0));

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

   public static void CheckOut() {
       Scanner scanner=new Scanner(System.in);
       System.out.println("Please enter borrower's UserID");
       int UserId=0;
       try{
       UserId = Integer.parseInt(scanner.nextLine());
       }catch (NumberFormatException ignored){}

       System.out.println("Please enter BookID");
       int BookID=0;
       try {
            BookID= Integer.parseInt(scanner.nextLine());
       }catch (NumberFormatException ignored){}

       if (inventory.get(BookID).getAmmount()!=0) {
           if(!((usersID.get(usersID) instanceof Teacher)&&(usersInventory.get(usersID).size()<=5))||((usersID.get(usersID) instanceof Student)&&(usersInventory.get(usersID).size()<=3))||((usersID.get(usersID) instanceof Librarian)&&(usersInventory.get(usersID).size()<=10))){

             if (!(inventory.get(BookID) instanceof Reference_Books)) {

               ArrayList<Integer> userList = usersInventory.get(UserId);
               if (userList == null) {
                   userList = new ArrayList<>();
                   usersInventory.put(UserId, userList);
               }
               userList.add(inventory.get(BookID).getBookID());

               inventory.get(BookID).setAmmount(inventory.get(BookID).getAmmount()-1);

           } else System.out.println("Reference books are NOT borrowable");
       }else System.out.println("You exceeded your limit");
   }else System.out.println("Labrary does not have this book at this time.Choose another book.");


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
            s += "| BookID: " + getInventory().get(key).getBookID() + "| Name: " + getInventory().get(key).getName() + "| Author: " + getInventory().get(key).getAuthor() +" | Available : "+getInventory().get(key).getAmmount() +"\n";
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
            s += "UserID: " + getUsersID().get(key).getUserID() + "| Name: " + getUsersID().get(key).getUser_name() + "| LastName: " + getUsersID().get(key).getUser_lastName() ;
        }

        return s;
    }

    /***********************************************************************************/
    ////////////////    Librarian Menu    /////////////////////////////////////////////
    public static void printLibrarianmenu() {
        System.out.println("Enter" + "\n" + "|1: To see Library's inventory| " + "2:  To see active Users| " +
                "|3: To look up a user| " + "\n" + "|4: To add new user | " + "5: To add new book| " +
                "6: To Check in a book| " + "7: To check out a book|" + "\n" + "|C to Main Menu");

    }

    /*************************************************************************************/

/////////////////////  Users Menu    /////////////////////////////////////////////////
    public static void printUsersmenu() {

        System.out.println("Enter" + "\n" + "| 1: To see Library's inventory | " +
                "| 2: To see your inventory | " + "|3: To Check-in a book | " + "|4: To Check-out a book |" + "\n" + "c to Main Menu");
    }

    /*************************************************************************************************/

    //////////////////////////    Acces Menu   ///////////////////////////////////
    public static void START() {
        do {
            System.out.println("Welcome to Vlad's  Library");
            System.out.println("Please identify your self:| 1:Librerian | 2:Teacher | 3:Student");
            Scanner scanner = new Scanner(System.in);
            //String answer = scanner.nextLine();
            int  answer;
            try{
                answer= Integer.parseInt(scanner.nextLine());
                //Admin
                switch (answer){
                    case 1: adminaccess(scanner);break;
                    case 2:
                    case 3: Usersaccess(scanner);}

             }catch (NumberFormatException ignored){}

        } while (1 != 2);
    }
    /***********************************************************************************/

    static  int id2;
    /////////////////////  Users Access   ///////////////////////////////////////////
    private static void Usersaccess(Scanner scanner) {

        boolean access = false;
        while (!access) {
            System.out.println("Enter your IDNumber");
            id2 = Integer.parseInt(scanner.nextLine());
            try{
            if (LibraryDATA.getUsersID().containsKey(id2)) {
                access=true;
                System.out.println("What do you want to do " + LibraryDATA.getUsersID().get(id2).getUser_name() + " ?");

            } else {System.out.println("You have no access");}
        }catch (NumberFormatException ignored){}}
        String answer2;
        try{
            do {
                printUsersmenu();
                answer2 = scanner.nextLine();
                switch (answer2) {
                    case "1":System.out.println(LibraryDATA.printinventory());break;
                    case "2":UserLookUP(id2);break;
                    case "3": checkinBook();break;
                    case "4":CheckOut();break;
                    case "c":}
            } while (!answer2.equals("c"));
        }catch (NumberFormatException ignored){}
    }
    /******************************************************************************************/

    ///////////////////////// Admin Accsess  ///////////////////////////////////
    private static void adminaccess(Scanner scanner) {

        boolean access = false;
        while (!access) {
            System.out.println("Enter your IDNumber");

            int id = Integer.parseInt(scanner.nextLine());
            try {
                if (getUsersID().containsKey(id)) {
                    if (getUsersID().get(id) instanceof Librarian) {
                        System.out.println("What do you want to do " + getUsersID().get(id).getUser_name() + " ?");
                        break;
                    }
                    System.out.println("You are not an admin");
                } else {
                    System.out.println("You have not registered");
                }
            } catch (NumberFormatException ignored) {
            }
        }

        String answer1;
        try {
            do {
                printLibrarianmenu();
                answer1 = scanner.nextLine();
                switch (answer1) {

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
                        checkinBook();
                        break;
                    case "7":CheckOut();
                        break;
                    case "c":
                }
            } while (!answer1.equals("c"));
        } catch (NumberFormatException ignored) {}

    }
        /*************************************************************************************/

        //////////////////////////// Book Ckeckin  ////////////////////////////////////////

    private static void checkinBook () {
        boolean q=true;
        do {
            System.out.println("Enter bookId to be ruturned");
            Scanner scanner = new Scanner(System.in);
            int bookId = 0;
            try {
                bookId = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {
            }
            if (!inventory.containsKey(bookId)) {
                System.out.println("This book is not belong to this library");
                break;
            } else {
                System.out.println("Enter UserId returning the book");
            }
            int userId = 0;
            try {
                userId = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {
            }
            if (!usersID.containsKey(userId)) {
                System.out.println("This user is not registerd.See admin for help");
                break;
            }
            try{
                   q=false;
                    usersInventory.get(userId).remove(usersInventory.get(userId).indexOf(bookId));}
            catch (NullPointerException e){
                System.out.println("This book is not belong to that user.See admin for help");
                inventory.get(bookId).setAmmount(inventory.get(bookId).getAmmount() + 1);


            }break;

        }while(!q);
    }
   /******************************************************************************************/
    public static void main(String[] args) {

        System.out.println(printinventory());
        System.out.println(printUsers());
    }
}