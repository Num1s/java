import java.util.regex.Pattern;

public class News extends Document {
    public News(String author, String text, String date) throws InvalidDocumentException {
        super(author, text, date);
    }

    @Override
    public boolean validate() {
        String t = getText().trim();
        return t.length() >= 10; // basic sanity check
    }

    @Override
    public String getSummary() {
        return truncate(getText(), 30);
    }

    @Override
    public String analyze() {
        // Count words that start with an uppercase letter (simple heuristic)
        String[] words = getText().split("\\W+");
        int capitalized = 0;
        for (String w : words) {
            if (w.isEmpty()) continue;
            char c = w.charAt(0);
            if (Character.isLetter(c) && Character.isUpperCase(c)) capitalized++;
        }
        return "Capitalized words: " + capitalized;
    }
}
