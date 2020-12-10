package Project10_Vlad;

import Project10_Vlad.Books.*;
import Project10_Vlad.Users.Librarian;
import Project10_Vlad.Users.Student;
import Project10_Vlad.Users.Teacher;
import Project10_Vlad.Users.Users;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.nio.channels.ScatteringByteChannel;
import java.util.*;

public class LibraryDATA {

    private static LinkedHashMap<Integer, Users> usersID = new LinkedHashMap<>();

    private static LinkedHashMap<Integer, Books> inventory = new LinkedHashMap<>();

    private static LinkedHashMap<Integer, HashMap<Integer, Books>> usersInventory = new LinkedHashMap<>();

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


        addBook(new Fiction_Books("War and Peace", 10001, "Tolstoy", 1, Categories.NOVELS));
        addBook(new Fiction_Books("Idiot", 10002, "Dostoyevskiy", 6,Categories.NOVELS));
        addBook(new Fiction_Books("Master and Margarita", 10003, "Bulgakov", 2,Categories.LITERATURE));
        addBook(new Fiction_Books("Yevgeny Onegin", 10004, "Pushkin", 0,Categories.LITERATURE));
        addBook(new Fiction_Books("Romeo and Julietta", 10005, "Shekspir", 12,Categories.NOVELS));
        addBook(new Fiction_Books("Monte Kristo", 10006, "Dyuma", 4,Categories.NOVELS));
        addBook(new Fiction_Books("Ayvengo", 10007, "Sccott", 3,Categories.NOVELS));


        addBook(new Non_Fiction_Books("Java Fundamental", 20001, "Oracle", 15,Categories.SCIENCE));
        addBook(new Non_Fiction_Books("Java For Beginers", 20002, "Oracle", 11,Categories.SCIENCE));
        addBook(new Non_Fiction_Books("Java Script", 20003, "Oracle", 0,Categories.SCIENCE));
        addBook(new Non_Fiction_Books("Advanced Math", 20004, "Conaway", 4,Categories.MATH));


        addBook(new Reference_Books("Marriage Catalog", 90001, "City", 6,Categories.REFFERANCE));
        addBook(new Reference_Books("Reference Books 1", 90002, "Author1", 4,Categories.REFFERANCE));
        addBook(new Reference_Books("Reference Books 2", 90003, "Author2", 0,Categories.REFFERANCE));

    }

    ///////////////////////////////  LOOKUP THE USER  ////////////////////////////////

    public static void UserLookUP(int userID) {

        if (userStatus(userID)) {
            if (usersInventory.get(userID) != null) {
                if (!usersInventory.get(userID).isEmpty()) {


                    Collection<Books> list = usersInventory.get(userID).values();
                    for (Books books : list) {
                        System.out.println("Yor current inventory:"+"\n"+"| BookID: " + books.getBookID() + " | Book Name: " + books.getName() + " | Author: " + books.getAuthor() + " | DueDate: " + books.getDueDate()+"\n");
                    }


                } else {
                    System.out.println("NO books has been borrowed by this user");
                }
            } else {System.out.println("NO books has been borrowed by this user");

            }

        }else System.out.println("Not registered user");
    }
    //manual input for test
        public static void addBook(Books book) {
        inventory.put(book.getBookID(), book);
        }

    /********************************************************************************/

    //manual input for test
       public static void addUser(Users user) {
           usersID.put(user.getUserID(), user);
            }

    /********************************************************************************/

    //////////////   Print Library's  Inventory  /////////////////////////////////////
    public static String printinventory() {
        String s = "";
        Set<Integer> set = inventory.keySet();
        System.out.println("Collection of books:");
        for (Integer key : set) {
            s += "| BookID: " + getInventory().get(key).getBookID() + "| Name: " + getInventory().get(key).getName() + "| Author: " + getInventory().get(key).getAuthor() +" | Categories: " +getInventory().get(key).getCategories()+ " | Available : " + getInventory().get(key).getAmmount() + "\n";
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

    //////////////////////////    Start   ///////////////////////////////////

    public static void START() {
        do {
            System.out.println("Welcome to Vlad's  Library");
            System.out.println("Please identify your self:| 1:Librerian | 2:Teacher / Student |");
            Scanner scanner = new Scanner(System.in);
            //String answer = scanner.nextLine();
            int answer;
            try {
                answer = Integer.parseInt(scanner.nextLine());
                //Admin
                switch (answer) {
                    case 1:
                        adminaccess(scanner);
                        break;

                    case 2:
                        Usersaccess(scanner);
                }

            } catch (NumberFormatException ignored) {
            }

        } while (1 != 2);
    }

    /***********************************************************************************/

   // static private int id2;
    /////////////////////  Users Access   ///////////////////////////////////////////

    private static void Usersaccess(Scanner scanner) {
int id2=0;
        boolean access = false;
        while (!access) {
            System.out.println("Enter your IDNumber");
            id2 = Integer.parseInt(scanner.nextLine());
            try {
                if (getUsersID().containsKey(id2)) {
                    access = true;
                    System.out.println("What do you want to do " + getUsersID().get(id2).getUser_name() + " ?");

                } else {
                    System.out.println("You have no access");
                }
            } catch (NumberFormatException ignored) {
            }
        }
        String answer2;
        try {
            do {
                printUsersmenu();
                answer2 = scanner.nextLine();
                switch (answer2) {
                    case "1":
                        System.out.println(printinventory());
                        break;
                    case "2":
                        UserLookUP(id2);
                        break;
                    case "3":
                        checkinBook();
                        break;
                    case "4":
                        CheckOut(id2);
                        break;
                    case "c":
                    default:break;
                }
            } while (!answer2.equals("c"));
        } catch (NumberFormatException  ignored) {
        }
    }

    /******************************************************************************************/

    ///////////////////////// Admin Accsess  ///////////////////////////////////
    private static void adminaccess(Scanner scanner) {

        boolean access = false;
        while (!access) {
            System.out.println("Enter your IDNumber");

            int id = Integer.parseInt(scanner.nextLine());
            try {
                if (userStatus(id)) {
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
                        System.out.println(printinventory());
                        break;
                    case "3":
                        System.out.println("Enter UserID");
                        try{int a= Integer.parseInt(scanner.nextLine());
                            if(userStatus(a)){
                                UserLookUP(a); }
                            else System.out.println("Not registered User");}
                        catch (NumberFormatException ignored) { System.out.println("Incorrect input");}
                           break;
                    case "2":
                        System.out.println(printUsers());
                        break;
                    case "4":
                        createNewUser();
                        break;
                    case "5":
                        createBook();

                        break;
                    case "6":
                        checkinBook();
                        break;
                    case "7":
                           System.out.println("Please enter borrower's UserID");
                            int UserId = 0;
                            try {
                                UserId = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException ignored) {
                            }
                            if (!userStatus(UserId)) {
                                System.out.println("User is not registered");
                                 break;}
                        CheckOut(UserId);
                        break;
                    case "c":break;
                }
            } while (!answer1.equals("c"));
        } catch (NumberFormatException ignored) {
        }

    }

    /*************************************************************************************/

    //////////////////////////// Book Ckeckin  ////////////////////////////////////////
    public static void checkinBook() {
       boolean q =true;
        while (q) {
            System.out.println("Enter User'sId returning the book");

            Scanner scanner = new Scanner(System.in);
            int userId = 0;
            try {
                userId = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {
                System.out.println("Not correct input");
            }
            if (!userStatus(userId)) {
                System.out.println("User is not registered");
                q = false;
                break;
            }

            System.out.println("Enter bookId to be returned");

            int bookId = 0;
            try {
                bookId = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {
                System.out.println("Incorect input");
            }
            if (!inventory.containsKey(bookId)) {
                System.out.println("Book is not from this library");
                q = false;


            } else if (((usersInventory.get(userId) == null) || (usersInventory.get(userId).isEmpty()))) {
                System.out.println("This book is not belong to this user");
                q = false;


            } else {
                usersInventory.get(userId).remove(bookId);
                inventory.get(bookId).setAmmount(inventory.get(bookId).getAmmount() + 1);
                q = false;
            }

        }

    }

    /******************************************************************************************/

    /////////////////////////////////   CHEKOUT A BOOK  //////////////////////////////
    public static void CheckOut(int UserId) {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("MM/dd/uuuu");
        Scanner scanner = new Scanner(System.in);
        boolean q = true;
        do {

            System.out.println("Please enter BookID");
            int BookID = 0;
            try {
                BookID = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {
            }

            if (userStatus(UserId)) {

                if (inventory.containsKey(BookID)) {
                    if (inventory.get(BookID).getAmmount() != 0) {

//
                        if (!(inventory.get(BookID) instanceof Reference_Books)) {
                            if (usersInventory.get(UserId)== null) {
                                HashMap<Integer,Books>userList = new HashMap<>();

                                usersInventory.put(UserId, userList);}

                            if (((usersID.get(UserId) instanceof Teacher) && (usersInventory.get(UserId).size() < 5)) ||

                                    ((usersID.get(UserId) instanceof Student) && (usersInventory.get(UserId).size() <3)) ||
                                    ((usersID.get(UserId) instanceof Librarian) && (usersInventory.get(UserId).size() < 10))) {

                                usersInventory.get(UserId).put(BookID, inventory.get(BookID));
                                usersInventory.get(UserId).get(BookID).setDueDate(dueDate(UserId));
                               inventory.get(BookID).setAmmount(inventory.get(BookID).getAmmount() - 1);
                                System.out.println("Thank you for using this Library.Dont forget to return this book by: "+ dueDate(UserId).format(formater).toString() );
                            }else {
                            System.out.println("You can't exceed you limit.");
                            break;
                        }

                    } else {
                            System.out.println("Reference books are NOT borrowable.");
                        break;
                    }


                } else System.out.println("Library does not have this book available at this time.");
            } else {
                System.out.println("Can't find a book");
                break;
            }

        } else{ System.out.println("Not registered user");}
       }  while (!q) ;}
    /********************************************************************************/
    //////////////////////////////// check if active user  //////////////////////////////
    public static boolean userStatus(int Userid){
      boolean status;
        if (usersID.containsKey(Userid)) {
            status =true;
        }else status=false;
        return status;
    }
   /***************************************************************************************/
   ///////////////////   Creating of a new User  ////////////////////////////////////////////
   public static void createNewUser()  {
       Scanner scanner = new Scanner(System.in);
       System.out.println("What type of user do you want to create: 1-Admin 2-Techer 3- Student");
       int user=0;
       do{
      try{
       user = Integer.parseInt(scanner.nextLine());}
       catch (NumberFormatException ignored) {
      System.out.println("You can only select 1,  2 or 3 ");
}
       }while (!(user ==1||user==2||user==3));

       System.out.println("User's name");
       String name = scanner.nextLine();
       System.out.println("User's last name");
       String lastname = scanner.nextLine();


       switch (user) {
           case 1:
               Librarian librarian = new Librarian(name, lastname);
               addUser(librarian);
               break;

           case 2:
               Teacher teacher = new Teacher(name, lastname);
              addUser(teacher);
               break;

           case 3:
               Student student = new Student(name, lastname);
               addUser(student);
               break;
                }
       System.out.println("Welcome to a new user "+name+" "+ lastname);
   }
/*******************************************************************************************************/

///////////////// Creating new Book ////////////////////////////////////////////////////////////
public static void createBook() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("What type of book do you have: 1-Fiction Books 2-Non-Fiction Books 3- Reference Books");
    int  type=0;
    do{
        try{
            type = Integer.parseInt(scanner.nextLine());}
        catch (NumberFormatException ignored) {
            System.out.println("You can only select 1,  2 or 3 ");
        }
    }while (!(type ==1||type==2||type==3));
String name="";
do {
    System.out.println("Enter Book's name");

    name = scanner.nextLine();
} while(name.length()==0);
   String author="";
   do {
       System.out.println("Enter Author");
       author = scanner.nextLine();
   }while (author.length()==0);
    System.out.println("Enter ammount of books");
    int amount=0;

        try{
            amount= Integer.parseInt(scanner.nextLine());
      }
        catch (NumberFormatException ignored) {
              }

    switch (type) {
        case 1:
            System.out.println("Please choose category:"+"\n"+"| 1: WORLD_CLASSICS | 2: NOVELS | 3: LITERATURE | 4: EARLY_AGE | 5: GENERAL |");
            int b=0;

            try{
                b= Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException ignored) {
            }
            Fiction_Books fiction_books = null;
            if(b == 1){
                 fiction_books = new Fiction_Books(name,author,amount,Categories.WORLD_CLASSICS);
            }else if (b==2){
               fiction_books = new Fiction_Books(name,author,amount,Categories.NOVELS);

            }else if (b==3){
                 fiction_books = new Fiction_Books(name,author,amount,Categories.LITERATURE);
            }
            else if (b==4){
                 fiction_books = new Fiction_Books(name,author,amount,Categories.LITERATURE);

            }else if (b==5){
                fiction_books = new Fiction_Books(name,author,amount,Categories.GENERAL);
            }
            else {
                System.out.println("Incorect input");
                break;
            }
            addBook(fiction_books);
            System.out.println("New book Added to the library.");
            break;
        case 2:

            System.out.println("Please choose category:"+"\n"+"| 1: WORLD_CLASSICS | 2: NOVELS | 3: LITERATURE | 4: EARLY_AGE | 5: GENERAL |");
            int c=0;

            try{
                c= Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException ignored) {
            }
            Non_Fiction_Books non_fiction_books = null;

            System.out.println("Please choose category:"+"\n"+"| 1:MATH | 2: SCIENCE | 3: SOCIAL | 4: HISTORICAL | ");

            if(c == 1){
                fiction_books = new Fiction_Books(name,author,amount,Categories.MATH);
            }else if (c==2){
                fiction_books = new Fiction_Books(name,author,amount,Categories.SCIENCE);

            }else if (c==3){
                fiction_books = new Fiction_Books(name,author,amount,Categories.SOCIAL);
            }
            else if (c==4){
                fiction_books = new Fiction_Books(name,author,amount,Categories.HISTORICAL);}
            else {
                System.out.println("Incorect input");
                break;
            }



          addBook(non_fiction_books);
                System.out.println("New book Added to the library.");
            break;

        case 3:
            Reference_Books reference_books = new Reference_Books(name, author,amount,Categories.REFFERANCE);
            addBook(reference_books);
            System.out.println("New book Added to the library.");
            break;
    }

}
    /***********************************************************************************************************************/
     ////////////////////////  Due date /////////////////////////////////////////////////
    public static  LocalDate dueDate(int userId){
        int howManyDays=0;
        if(getUsersID().get(userId) instanceof Librarian){
            howManyDays=30;
        }
        if(getUsersID().get(userId) instanceof Teacher){
            howManyDays=21;
        }
        if(getUsersID().get(userId) instanceof Student){
            howManyDays=14;
        }
        LocalDate now = LocalDate.now();

        LocalDate dueDate = now.plusDays(howManyDays);
       // DateTimeFormatter formater = DateTimeFormatter.ofPattern("MM/dd/uuuu");


        return dueDate;
    }

//////////////////////////////  Serch by categoties ////////////////////////////
    public static HashMap<Integer,Categories> CategoriesSearch(){
        HashMap<Integer,Categories>map = new HashMap<>();




        return map;
    }


   /****************************************************************************************/
    public static void main(String[] args)  {



    }
}