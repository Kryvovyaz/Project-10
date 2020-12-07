package Project10_Vlad.Books;

import Project10_Vlad.LibraryDATA;

import java.util.Random;

public abstract class Books {
    private   String name;



    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    private   int bookID;
    private  String author;
    private  int ammount;
    private  boolean pastdue;


    public  int getbookID() {
        return bookID;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public  void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public  void setAuthor(String author) {
        this.author = author;
    }



    public  void setPastdue(boolean pastdue) {
        this.pastdue = pastdue;
    }

    public  String getAuthor() {
        return author;
    }

    public  boolean isPastdue() {
        return pastdue;
    }

    public  String getName() {
        return name;
    }
    public int getBookID() {
        return bookID;
    }

    public Books(String name, String author) {
        this.name = name;
        this.author = author;
        this.bookID = bookIdGenerator();
        this.ammount = 10;
        this.pastdue = false;

    }



    public  String  getStatus() {
        String s ="";
        if(!this.pastdue){
          s= "Active" ;}
        else s= "Past Due";
        return s;
    }

    public Books(String name, int bookID, String author) {
        this.name = name;
        this.bookID = bookID;
        this.author = author;
        this.ammount = 10;
        this.pastdue = false;
    }

    public  int bookIdGenerator() {
        int id=0;
        Random random = new Random();
        while(!LibraryDATA.getInventory().containsKey(id)){
            id = random.nextInt(10000)+10000;
            break; }
        return  id;
    }



   @Override
    public String toString(){
        String s="BookID: "+getBookID()+" BookName: "+getName();
       return s;
   }

}
/*Books:
   Each book has a name, a author, a five-digit bookId and a status(checkedIn or not)
   It may have more identifiers if needed.
   bookIds cannot be the the same as any other book's
   There are three types of books: Fiction, Non-Fiction and Reference
*/

