import java.net.*;
import java.io.*;

public class CacheServer 
{
    public static void main(String[] args) 
    {
        try (ServerSocket serverSocket = new ServerSocket(5000)) 
        {
            System.out.println("Cache server running...");
            while (true) {
                Socket socket = serverSocket.accept();
                new CacheServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class CacheServerThread extends Thread 
{
    private Socket socket; 

    public CacheServerThread(Socket socket) 
    {
        this.socket = socket; 
    }

    public void run() {
         try {
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         } { 
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String[] numbers = inputLine.split(", ");
                if (numbers.length == 2) {
                    int num1 = Integer.parseInt(numbers[0]);
                    int num2 = Integer.parseInt(numbers[1]);
                    int sum = num1 + num2; 
                    out.println(sum);
                } else 
                {
                    out.println("Invalid input. Please provide two numbers separated by comma");
                }
            }
        } catch (IOException e) { 
            e.printstackTrace();
        } 
    } 
}