public class Payment {
    public static boolean processPayment(Customer customer, double amount) {

        System.out.println("Processed payment of $" + String.format("%.2f", amount) + " for " + customer.getUserName());
        return true;
    }
}