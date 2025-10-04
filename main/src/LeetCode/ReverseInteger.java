package LeetCode;

public class ReverseInteger {
    public static int reverse(int x) {
        String a = String.valueOf(x);
        String b = "";
        for (int i = 0; i < a.length(); i++) {
            b = a.charAt(i) + b;
        }

        if (b.indexOf('-') != -1) {
            b = b.replace('-', ' ');
            b = '-' + b;
        }

        try {
            return Integer.parseInt(b.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.print(reverse(123));
    }
}
