import org.jsoup.Jsoup;
import org.jsoup.nodes.Document; 
import org.jsoup.nodes.Element; 
import org.jsoup.select.Elements;
import java.io.IOException; 
import java.util.HashSet; 
import java.util.Set; 

public class WebCrawler { 

    private static final int MAX_DEPTH = 5; 
    private Set<String> visitedUrls = new HashSet<>();

    public void crawl(String url, int depth) { 
        if (depth <= MAX_DEPTH) {
            try{ 
                Document document = Jsoup.connect(url).get();
                Element links = document.select("a[href]");

                for (Element link : Links) { 
                    String nextUrl = link.absUrl("href");
                    if (!visitedUrls.contains(nextUrl)) { 
                        System.out.println(nextUrl);
                        visitedUrls.add(nextUrl);
                        crawl(nextUrl, depth + 1); 
                    }
                }
            } catch (IOException e) { 
                System.err.println("Error while connecting to URL: " + url);
            }
        }
    }

    public static void main(String[] args) {
        String seedUrl = "https://example.com";
        WebCrawler crawler = nwe WebCrawler();
        crawler.crawl(seedUrl, 0);
    }
}