import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class DocumentStorage<T extends Document> {
    private final List<T> docs = new ArrayList<>();

    public void add(T doc) throws InvalidDocumentException {
        if (doc == null) throw new InvalidDocumentException("Document is null");
        if (!doc.validate()) throw new InvalidDocumentException("Invalid document: " + doc);
        docs.add(doc);
    }

    public List<T> getAll() { return Collections.unmodifiableList(docs); }

    public List<T> filterByAuthor(String author) {
        if (author == null) return List.of();
        return docs.stream()
                .filter(d -> d.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<T> filterByDateRange(LocalDate fromInclusive, LocalDate toInclusive) {
        return docs.stream()
                .filter(d -> (fromInclusive == null || !d.getDate().isBefore(fromInclusive)) &&
                             (toInclusive == null || !d.getDate().isAfter(toInclusive)))
                .collect(Collectors.toList());
    }

    public List<T> sortByAuthorThenDate() {
        return docs.stream()
                .sorted(Comparator
                        .comparing(Document::getAuthor, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Document::getDate))
                .collect(Collectors.toList());
    }

    public List<T> sortByDate(boolean ascending) {
        Comparator<T> cmp = Comparator.comparing(Document::getDate);
        if (!ascending) cmp = cmp.reversed();
        return docs.stream().sorted(cmp).collect(Collectors.toList());
    }

    public List<String> analyzeAll() {
        return docs.stream().map(Document::analyze).collect(Collectors.toList());
    }
}
