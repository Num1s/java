package LeetCode;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String reversed = new StringBuilder(String.valueOf(x)).reverse().toString();
        String normal = String.valueOf(x);
        return normal.equals(reversed);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(11));
    }
}
