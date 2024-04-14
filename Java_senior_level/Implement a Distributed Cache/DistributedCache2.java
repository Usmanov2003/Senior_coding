import java.net.*;
import java.io.*;

public class CacheClient {
    public static void main(String[] args) 
    {
        try (
            Socket socket = new Socket("Localhost", 5000);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) { 
            System.out.println("Enter two numbers separated by comma: ");
            String input = userInput.readerLine();
            out.println(input);
            String response = in.readLine();
            System.out.println("Sum receive from server: " + response);
        } catch (IOException e) { 
            e.printStackTrace();
        }
    }
}