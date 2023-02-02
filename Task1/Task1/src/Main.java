import java.util.Stack;

public class Main {

    private static boolean isPalindrome(int x) {
        String xString = String.valueOf(x);
        for (int i = 0; i < xString.length() / 2; i++) {
            if (xString.charAt(i) != xString.charAt(xString.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBracketsStringValid(String bracketsString) {
        Stack<Character> openBrackets = new Stack<>();
        for (char bracket: bracketsString.toCharArray()) {
            switch (bracket) {
                case '(':
                    openBrackets.push(')');
                    break;
                case '{':
                    openBrackets.push('}');
                    break;
                case '[':
                    openBrackets.push(']');
                    break;
                default:
                    if (openBrackets.isEmpty() || openBrackets.pop() != bracket) {
                        return false;
                    }
            }
        }
        return openBrackets.isEmpty();
    }

    public static void main(String[] args) {
        int[] isPalindromeTestValues = {121, 10, 0, -121, Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (int x: isPalindromeTestValues) {
            System.out.printf("isPalindrome for %d is %b%n", x, isPalindrome(x));
        }

        String[] isBracketsStringValidTestValues = {"()[]{}", "(]", "([{)]}", "())", "(()"};
        for (String x: isBracketsStringValidTestValues) {
            System.out.printf("isBracketsStringValid for %s is %b%n", x, isBracketsStringValid(x));
        }
    }
}