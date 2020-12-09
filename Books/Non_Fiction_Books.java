package Project10_Vlad.Books;

public class Non_Fiction_Books extends Books {
    private Categories categories;

    public Non_Fiction_Books(String name, String author,int amount) {
        super(name, author,amount);
        setBookID(bookIdGenerator() + 10000);
    }

    public Non_Fiction_Books(String name, int bookID, String author, int ammount) {
        super(name, bookID, author, ammount);
    }

   }

/*
   Non-Fiction Books:
      Non-Fiction Book ids start with 2 (For example: 20064)
      Non-Fiction books must have one of the four categories: MATH, SCIENCE, SOCIAL, HISTORICAL
      Any user can borrow a non-fiction book*/