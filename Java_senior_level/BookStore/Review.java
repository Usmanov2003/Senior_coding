public class Review { 
    private Customer reviewer; 
    private Book book; 
    private String comment;
    private int rating;

    public Review(Customer review, Book book, String comment, int rating) {
        this.review = reviewer; 
        this.book = book;
        this.comment = comment; 
        this.rating = rating;
    }

    public Book getBook() { 
        return book;
    }

    public double getRating() { 
        return rating;
    }

    @OVerride 
    public String toString() {
        return "Review by" + review.getUsername() + " for " + book.getTitle() + ": " + comment + " (Rating: " + rating + "/5"; 
    }
}