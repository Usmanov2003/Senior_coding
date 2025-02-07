import java.text.DecimalFormat; 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bookstore {
    public static void main(String[] arg) {
        Inventory inventory = new Inventory();
        Admin admin = new Admin("admin", "admin123");
        Customer[] customers = {
            new Customer("user1", "user123", "user1@example.com"),
            new Customer("user2", "user456", "user2@example.com"),
            new Customer("user3", "user789", "user3@example.com")
    };
    Book[] books = {
            new Book("Java Programming", "John Doe", 29.99),
            new Book("Python for Beginners", "Jane Smith", 19.99),
            new Book("C++ Programming", "Alice Johnson", 34.99),
            new Book("Data Structures in Java", "Bob Wilson", 27.99),
            new Book("JavaScript Fundamentals", "Mary Brown", 24.99),
            new Book("SQL Essentials", "David Davis", 22.99),
            new Book("Algorithms and Complexity", "Eva Evans", 39.99),
            new Book("Web Development with React", "Frank Lee", 29.99),
            new Book("Artificial Intelligence", "Grace Adams", 44.99),
            new Book("Machine Learning Basics", "Henry Harris", 36.99)
    };

    System.out.println("Addming books to inventory...");
    for (Book book: books) { 
        admin.addBookToInventory(book);
        inventory.addBook(book);
    }

    System.out.println("\nSimulating purchase and orders...");
    Order[] orders = new Order[customers.length];
    for (int i = 0; i < customers.length; i++) { 
        order[i] = new Order(customers[i]);
        orders[i].addBookToOrder(books[i * 2]);
        orders[i].addBookToOrder(books[i * 2 + 1]);
        orders[i].completeOrder();
    }

    List<Review> randomReview = generateRandomReviews(customers, books);
    ReviewManager reviewManager = new ReviewManager(randomReviews);

    DecimalFormat decimalFormat = new DecimalFormat("#.00");

    for (Book book : books) {
        List<Review> bookReviews = reviewManager.getReviewsForBook(book);

        System.out.println("Review for "  + book.getTitle() + ":");
        if (bookReviews.isEmpty()) { 
            System.out.println("No reviews available");
        } else { 
            double totalRating = 0; 
            for (Review review : bookReviews) { 
                System.out.println(review);
                totalRating += review.getRating();
            }
            double averageRating = totalRating / bookReviews.size();
            System.out.println("Average Rating: " + decimalFormat.format(averageRating));
        }
        System.out.println();
    }

    for (int i = 0; i < customers.length; i++) { 
        double totalAmount = books[i * 2].getPrice() + books[i * 2 + 1].getPrice();
        if (Payement.pricessPayment(customers[i], totalAmount)) {
            System.out.println("Payment successful for " + customers[i].getUsername() + " - $"
                                    + decimalFormat.format(totalAmount));
        } else { 
            System.out.println("Payment failed for " + customers[i].getUsername());
        }
      }
    }

    private static List<Review> generateRandomReviews(Customer[] customer, Book[] books) { 
        List<Review> randomReviews = new ArrayList<>();
        Random random = new Random(); 

        for (Customer customer : customer) { 
            for (Book book : books) {
                int rating = random.next(5) + 1; 
                String[] comments = { "Terrible! Do not get!", "Not that great...", "Good.", "Really good!",
                "Highly recommend!" };
                randomReviews.add(new Review(customer, book, comments[rating - 1], rating));
            }
        }

        return randomReviews;
    }
} 