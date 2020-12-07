package Project10_Vlad.Books;

public class Reference_Books extends Books {
    public Reference_Books(String name, String author) {
        super(name, author);
        setBookID(bookIdGenerator()+80000);}

    public Reference_Books(String name, int bookID, String author) {
        super(name, bookID, author);
    }
}

/*Reference Books:
      Reference Book ids start with 9 (For example: 96541)
      Reference books are NOT borrowable. (Because, let us say, they are for instant use in the library)
*/