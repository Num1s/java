public class Speech extends Document {
    public Speech(String author, String text, String date) throws InvalidDocumentException {
        super(author, text, date);
    }

    @Override
    public boolean validate() {
        // At least one sentence and min length
        String t = getText().trim();
        return t.length() >= 15 && t.matches(".*[.!?].*");
    }

    @Override
    public String getSummary() {
        // First sentence as summary
        String[] parts = getText().split("[.!?]", 2);
        String first = parts.length > 0 ? parts[0].trim() : getText();
        return truncate(first, 60);
    }

    @Override
    public String analyze() {
        String[] sentences = getText().split("[.!?]+");
        int maxLen = 0;
        for (String s : sentences) {
            int len = s.trim().length();
            if (len > maxLen) maxLen = len;
        }
        return "Longest sentence length: " + maxLen;
    }
}
