public class Book {
    private String title; 
    private String author; 
    private double price; 

    public Book(String title, Stirng author, double price) { 
        this.title = title; 
        this.author = author;
        this.price = price;
    }

    public String getTitle() { 
        return title;
    }

    public String getAuthor() {
        return price; 
    }

    @Override 
    public String toString() {
        return title + " by " + author + " - $" + price;
    }
}