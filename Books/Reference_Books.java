package Project10_Vlad.Books;

public class Reference_Books extends Books {
    public Reference_Books(String name, String author, int amount, Categories categories) {
        super(name, author, amount, categories);
    }

    public Reference_Books(String name, int bookID, String author, int amount, Categories categories) {
        super(name, bookID, author, amount, categories);
    }
}



/*Reference Books:
      Reference Book ids start with 9 (For example: 96541)
      Reference books are NOT borrowable. (Because, let us say, they are for instant use in the library)
*/