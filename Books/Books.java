package Project10_Vlad.Books;

import Project10_Vlad.LibraryDATA;

import java.time.LocalDate;
import java.util.Random;

public abstract class Books  {
    private   String name;
    private   Integer bookID;
    private  String author;
    private  int ammount=1;
    private LocalDate pastdue;
    private Categories categories;

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public  int getbookID() {
        return bookID;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public  void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public  String getAuthor() {
        return author;
    }

    public LocalDate getPastdue() {
        return pastdue;
    }

    public void setPastdue(LocalDate pastdue) {
        this.pastdue = pastdue;
    }

    public  String getName() {
        return name;
    }



    public Books(String name, String author,int ammount) {
        this.name = name;
        this.author = author;
        this.bookID = bookIdGenerator();
        this.ammount = ammount;
        this.categories=categories;
    }

    public Books(String name, int bookID, String author,int ammount) {
        this.name = name;
        this.bookID = bookID;
        this.author = author;
        this.ammount = ammount;
       // this.categories=categories;
        this.ammount=ammount;
    }
//////////////////////  Book ID Genrator ///////////////////////////////
    public  int bookIdGenerator() {
        int id=0;
        Random random = new Random();
        while(!LibraryDATA.getInventory().containsKey(id)){
            id = random.nextInt(10000)+10000;
            break; }
        return  id;
    }
////////////////////////////////////////////////////////////////////////


    public Categories getCategories() {
        return categories;
    }

    @Override
    public String toString(){
        String s="BookID: "+getBookID()+" BookName: "+getName()+" Author "+getAuthor()+" Amount: "+ getAmmount();
       return s;
   }

    public Integer getBookID() {
        return bookID;
    }
}
/*Books:
   Each book has a name, a author, a five-digit bookId and a status(checkedIn or not)
   It may have more identifiers if needed.
   bookIds cannot be the the same as any other book's
   There are three types of books: Fiction, Non-Fiction and Reference
*/

