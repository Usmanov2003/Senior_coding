import java.util.ArrayList; 
import java.util.List;

public class Inventory {
    private List<Book> books; 

    public Inventory() { 
        books = new ArrayList<>();
    }

    public void addBook(Book book) { 
        book.add(book);
    }

    public List<Book> gotAllBooks() { 
        return books; 
    }
}