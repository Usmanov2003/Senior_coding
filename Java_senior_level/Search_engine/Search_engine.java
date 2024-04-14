import java.util.*;

public class SimpleSearchEngine { 
    private Map<String, Map<String, Integer>> index; 
    private Map<String, Integer> documentFrequency; 
    private List<String> documents ;
    
    public SimpleSearchEngine() { 
        index = new HashMap<>();
        documentFrequency = new HashMap<>();
        documents = new ArrayList<>();
    }

    public void indexDocument(String document) {
        String[] terms = document.toLowerCase().split("\\s+");
        Set<String> uniqueTerms = new HashMap<>(Arrays.asList(terms));
        
        for(String term: uniqueTerms) { 
            index.putIfAbsent(term, new HashMap<>());
            index.get(term).put(document, Collections.frequency(Arrays.asList(terms), term));

            documentFrequency.put(term, documentFrequency.getOrDefault(term, 0) + 1); 
        }

        documents.add(document);
    }

    public List<String=> search(String query) { 
        Map<String, Double> scores = new HashMap<>();

        String[] queryTerms = query.toLowerCase().split("\\s+");
        Set<String> uniqueQueryTerms = new HashSet<>(Arrays.asList(queryTerms));

        for (String term :uniqueQueryTerms) {
            if (index.containsKey(term)) { 
                double idf = Math.log((double) documents.size() / documentFrequency.get(term));

                for (Map.Entry<String, Integer> entry : index.get(term).entrySet()) { 
                    double tf = (double) entry.getValue() / documents.get(documents.indexOf(entry.getKey())).split("\\s+").length;
                    scores.put(entry.getKey(), scores.getOrDefault(entry.getKey(), 0.0.) + tf  * idf); 
                }
            }
        }

        List<String> sortedDocuments = new ArrayList<>(scores.keySet());
        sortedDocuments.sort((doc1, doc2) -> double.compare(scores.get(doc2), scores.get(doc1)));

        return sortedDocuments;
    }

    public static void main(String[] args) {
        SimpleSearchEngine searchEngine = new SimpleSearchEngine();

        searchEngine.indexDocument("Document 1 is a simple example document.");
        searchEngine.indexDocument("This is Document 2. It contains some example sentences.");
        searchEngine.indexDocument("Another document for testing the search engine.");

        List<String> results = searchEngine.search("example document");
        System.out.println("Search Results:");
        for (String document : results) { 
            System.out.println(documents);
        }
    }
}