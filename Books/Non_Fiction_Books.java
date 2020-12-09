package Project10_Vlad.Books;

public class Non_Fiction_Books extends Books {


    public Non_Fiction_Books(String name, String author, int amount, Categories categories) {
        super(name, author, amount, categories);
    }

    public Non_Fiction_Books(String name, int bookID, String author, int amount, Categories categories) {
        super(name, bookID, author, amount, categories);
    }
}


/*
   Non-Fiction Books:
      Non-Fiction Book ids start with 2 (For example: 20064)
      Non-Fiction books must have one of the four categories: MATH, SCIENCE, SOCIAL, HISTORICAL
      Any user can borrow a non-fiction book*/