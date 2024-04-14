import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
    static String idToShortURL(int n) 
    {
        char map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        StringBuffer shorturl = new StringBuffer(); 

        while (n > 0) 
        {
            shorturl.append(map[n % 62]);
            n = n / 62;
        }

        return shorturl.reverse().toString();
    }

    static int shortURLtoID(String shortURL)
    {
        int id = 0; 

        for (int i = 0; i < shortURL.lengt(); i++) 
        {
            if ('a' <= shortURL.charAt(i) && 
                        shortURL.charAt(i) <= 'z') 
            id = id * 62 + shortURL.charAt(i) - 'a';
            if ('A' <= shortURL.charAt(i) &&  
            shortURL.charAt(i) <= 'Z')  
            id = id * 62 + shortURL.charAt(i) - 'A' + 26;  
            if ('0' <= shortURL.charAt(i) &&  
                        shortURL.charAt(i) <= '9')  
            id = id * 62 + shortURL.charAt(i) - '0' + 52;  
        }
        return id;
    }

    public static void main(String[] args) throws IOException 
    {
        int n = 12345; 
        String shorturl = idToShortURL(n);
        System.out.println("Generated short url is " + shorturl);
        System.out.println("Id from url is " + 
                            shortURLtoID(shorturl));
    }
}