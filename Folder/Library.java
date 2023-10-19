import java.util.*;
public class Library {
    private List<Books> books; 
    private Map<String,Genre> genres;

public Library(){
    books = new ArrayList<>();
    genres = new HashMap<>();
}

public void addBook(Books book){
    books.add(book);
    Genre genre = book.getGenre();
    //this if statement checks if a genre with the same name is associated with a book 
    //if it already exists, if it doesn't, it adds the book to the genres map
    // 
    if(!genres.containsKey(genre.getName())){
        genres.put(genre.getName(), genre);
    }
}

//removes books from the list
public void removeBook(Books book){
    books.remove(book);
}

public List<Books> getAllBooks(){
    return books;
}

//this method implements a parameter String in which we look for the books in a genre 
public List<Books> getBooksByGenre(String genreName){
    //initializes a list to store the books in which we are looking for that belong to a specified genre 
    List<Books> genreBooks = new ArrayList<>();

    //iterates through the books list (list of all the books in the library)
    for(Books book : books){
        //for each book in the library it checks if the name of the genre is associated with the book
        if(book.getGenre().getName().equals(genreName)){
            //if match is found, adds the book to the genreBooks list
            genreBooks.add(book);
        }
    }
    //returns all the books specified in that genre
    return genreBooks;
}
//creates a parameter in which you input a genre
public void addGenre(Genre genre){
    //inputs the genre in the genre map 
    genres.put(genre.getName(), genre);
    }

public Genre getGenre(String name){
    return genres.get(name);
}

public List<Genre> getAllGenres(){
    return new ArrayList<>(genres.values());
}

public Genre findGenresWithMostBooks(Library library){
    Genre maxGenre = null;

    int maxBookCount = 0;

    for(Genre genre : library.getAllGenres()){
        int genreBookCount = 0;
        for(Books book : library.getAllBooks()){
            if(book.getGenre().equals(genre)){
                genreBookCount++;
            }
        }
        if(genreBookCount > maxBookCount){
            maxBookCount = genreBookCount;
            maxGenre = genre;
        }
    }
    return maxGenre;
}
    public Genre findGenresWithLeastBooks(Library library){
        Genre minGenre = null;
        int minBookCount = 99999999;

        for(Genre genre : library.getAllGenres()){
            int genreBookCount = 0;
            for(Books book : library.getAllBooks()){
                if(book.getGenre().equals(genre)){
                    genreBookCount++;
                }
            }
            if(genreBookCount < minBookCount){
                minBookCount = genreBookCount;
                minGenre = genre;
            }
        }
         return minGenre;
    }

    //bubble sort method to sort the books by its title in the genre
    public List<Books> sortBooksByTitleInGenre(Library library, String genreName){
        //creates a list and initializes all the books in the genre to it
        List<Books> genreBooks = library.getBooksByGenre(genreName);
        //number of books if the genreBooks list
        int n = genreBooks.size();
        boolean swapped;
        
        do{
            swapped = false;
            //we use "-1" in the for loop because we are using bubble sort, we compare the adjacent elements in an array or list and swap them if necessary
            //this essentially means continue the loop as long as i is less than one less than the total number of elements, in this example lets say n = 5,
            //we compare each element with each other, we stop one element before the end one because we do not need to compare the last element with anything
            for(int i = 0; i < n - 1; i++){
                Books book1 = genreBooks.get(i);
                Books book2 = genreBooks.get(i + 1);
                if(book1.getTitle().compareToIgnoreCase(book2.getTitle()) > 0){
                    //swap books if they are out of order
                    genreBooks.set(i, book2);
                    genreBooks.set(i + 1, book1);
                    swapped = true;
                }
            }

        }while(swapped);
        
        return genreBooks;
    }
}