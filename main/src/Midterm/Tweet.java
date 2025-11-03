import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tweet extends Document {
    private final int likes;
    private static final int LIMIT = 280;

    public Tweet(String author, String text, String date, int likes) throws InvalidDocumentException {
        super(author, text, date);
        if (likes < 0) throw new InvalidDocumentException("Likes must be >= 0");
        this.likes = likes;
    }

    public int getLikes() { return likes; }

    @Override
    public boolean validate() {
        String t = getText();
        return t != null && t.length() > 0 && t.length() <= LIMIT;
    }

    @Override
    public String getSummary() {
        return "Tweet by " + getAuthor() + ": " + truncate(getText(), 50);
    }

    @Override
    public String analyze() {
        Pattern p = Pattern.compile("#\\w+");
        Matcher m = p.matcher(getText());
        int hashtags = 0;
        while (m.find()) hashtags++;
        return "Hashtags: " + hashtags + ", Likes: " + likes;
    }
}
