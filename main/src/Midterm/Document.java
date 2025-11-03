import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public abstract class Document implements Analyzable {
    private final String author;
    private final String text;
    private final LocalDate date; // ISO‑8601

    protected Document(String author, String text, String date) throws InvalidDocumentException {
        if (author == null || author.isBlank()) {
            throw new InvalidDocumentException("Author must be non‑blank");
        }
        if (text == null) {
            throw new InvalidDocumentException("Text must be non‑null");
        }
        try {
            this.date = LocalDate.parse(Objects.requireNonNull(date, "date"));
        } catch (DateTimeParseException e) {
            throw new InvalidDocumentException("Date must be ISO‑8601, e.g. 2024-05-01", e);
        }
        this.author = author;
        this.text = text;
    }

    public String getAuthor() { return author; }
    public String getText() { return text; }
    public LocalDate getDate() { return date; }

    // Each subtype defines its own validation rules
    public abstract boolean validate();

    public abstract String getSummary();

    // Utility for safe truncation with ellipsis
    protected static String truncate(String s, int max) {
        if (s == null) return "";
        if (s.length() <= max) return s;
        return s.substring(0, Math.max(0, max)).trim() + "…";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(author, document.author) &&
               Objects.equals(text, document.text) &&
               Objects.equals(date, document.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, text, date);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "author='" + author + '\'' +
                ", date=" + date +
                '}';
    }
}
