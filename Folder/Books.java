public class Books {
        
    private String title;
    private Genre genre;

    Books(String title, Genre genre){
        this.title = title;
        this.genre = genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public String toString(){
        return "Book Title: "+ title;
    }
}


