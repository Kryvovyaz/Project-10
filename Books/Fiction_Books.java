package Project10_Vlad.Books;

public class Fiction_Books extends Books {

private Categories categories;

    public Fiction_Books(String name, String author,int ammount) {
        super(name, author,ammount);
        setBookID(bookIdGenerator());
    }

    public Fiction_Books(String name, int bookID, String author, int ammount) {
        super(name, bookID, author, ammount);
    }


    enum Categories{
    WORLD_CLASSICS, NOVELS, LITERATURE, EARLY_AGE, GENERAL


}
}
/*Fiction Books:
      Fiction Book ids start with 1 (For example: 15087)
      Fiction books must have one of the five categories: WORLD_CLASSICS, NOVELS, LITERATURE, EARLY_AGE or GENERAL
      Any user can borrow a fiction book*/