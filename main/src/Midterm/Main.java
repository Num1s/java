import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            DocumentStorage<Document> storage = new DocumentStorage<>();

            // Sample data chosen to match example outputs shape
            storage.add(new News(
                    "John",
                    "BREAKING market Rally Today After Strong Jobs Report.",
                    "2024-04-12"));

            storage.add(new Tweet(
                    "Anna",
                    "Hello #world! Loving #java",
                    "2024-05-01",
                    123));

            storage.add(new Speech(
                    "Mike",
                    "Friends and colleagues, thank you for coming today. Our mission is clear: build, learn, and improve together. The future belongs to persistent teams.",
                    "2024-06-15"));

            // Analyses
            System.out.println("=== ANALYSIS ===");
            for (String line : storage.analyzeAll()) {
                System.out.println(line);
            }

            // Reports
            ReportGenerator rg = new ReportGenerator(storage.getAll());
            System.out.println("=== REPORT (JSON) ===");
            System.out.println(rg.exportToJson());
            System.out.println("=== REPORT (CSV) ===");
            System.out.print(rg.exportToCsv());

            // Examples of sorting and filtering
            // List<Document> byAuthor = storage.filterByAuthor("Anna");
            // List<Document> byDate = storage.sortByDate(true);
            // List<Document> byAuthorThenDate = storage.sortByAuthorThenDate();
        } catch (InvalidDocumentException e) {
            System.err.println("Failed to add document: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
