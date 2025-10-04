package LeetCode;
import java.util.Dictionary;
import java.util.Hashtable;

public class RomanToInteger {
    public static int romanToInt(String s) {
        Dictionary<String, Integer> symbols = new Hashtable<>();
        symbols.put("I", 1);
        symbols.put("V", 5);
        symbols.put("X", 10);
        symbols.put("L", 50);
        symbols.put("C", 100);
        symbols.put("D", 500);
        symbols.put("M", 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            String l = String.valueOf(s.charAt(i));
            String r = " ";

            if (i != 0) {
                String m = String.valueOf(s.charAt(i-1));
                if (symbols.get(l) > symbols.get(m)) {continue;}
            }

            if ((i + 1) < s.length()) {
                r = String.valueOf(s.charAt(i+1));
            }

            try {
                if (symbols.get(l) >= symbols.get(r)) {
                    result += symbols.get(l);
                } else if (symbols.get(l) < symbols.get(r)) {
                    result += (symbols.get(r) - symbols.get(l));
                }
            } catch (Exception e) {
                result += symbols.get(l);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.print(romanToInt("MCMXCIV"));
    }
}
