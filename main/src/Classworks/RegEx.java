package Classworks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public static void main(String[] args) {
        String str = """
            Встреча начнется 2025-10-14T23:43:43,
            закончится 2025-10-15T01:00:00, а следующая 2024-12-31T23:59:59.
            """;
        Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}");
        Matcher m = p.matcher(str);
//        2025-10-14T23:43:43
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
