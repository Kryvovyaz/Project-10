package Project10_Vlad.Books;

public class Fiction_Books extends Books {

private Categories categories;

    public Fiction_Books(String name, String author, int amount, Categories categories) {
        super(name, author, amount, categories);
    }

    public Fiction_Books(String name, int bookID, String author, int amount, Categories categories) {
        super(name, bookID, author, amount, categories);
    }


   }
/*Fiction Books:
      Fiction Book ids start with 1 (For example: 15087)
      Fiction books must have one of the five categories: WORLD_CLASSICS, NOVELS, LITERATURE, EARLY_AGE or GENERAL
      Any user can borrow a fiction book*/