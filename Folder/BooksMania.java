import java.util.*;

public class BooksMania{

    public static void main(String[] args) {
        //creates the library
        Library lib = new Library();

        //creates genres of books
        Genre nonfiction = new Genre("nonfiction");
        Genre education = new Genre("Education");

        //creates books
        Books kids = new Books("Alphabet", education);
        Books sciBook = new Books("Science", education);
        Books cscBook = new Books("Data Structures", education);
        Books manga = new Books("DBZ", nonfiction);
        Books history = new Books("History", education); 

        lib.addBook(kids);
        lib.addBook(history);
        lib.addBook(manga);
        lib.addBook(sciBook);
        lib.addBook(cscBook);
        lib.addGenre(education);
        // System.out.println(lib.getBooksByGenre("Education"));
        // System.out.println(lib.getAllBooks());

        // System.out.println(lib.findGenresWithMostBooks(lib));
        // System.out.println(lib.findGenresWithLeastBooks(lib));

        // System.out.println(lib.getAllGenres());

        System.out.println(lib.sortBooksByTitleInGenre(lib, "Education"));
    }
}
