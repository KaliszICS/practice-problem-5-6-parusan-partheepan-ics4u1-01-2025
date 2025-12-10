import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    
    public Library() {
        books = new ArrayList<>();
    }
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public boolean removeBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            
            if (books.get(i).getISBN().equals(isbn)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public Book[] searchBook(String title) {
        ArrayList<Book> matches = new ArrayList<>();
        
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                matches.add(book);
            }
        }
        
        return matches.toArray(new Book[0]);
    }
    
    public Book[] displayBooks() {
        return books.toArray(new Book[0]);
    }
}