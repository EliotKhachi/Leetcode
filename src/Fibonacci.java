import java.util.HashMap;

public class Fibonacci {
    static HashMap<String,Long> memo = new HashMap<>();
    public static void main (String[] args) {
        System.out.println(getFibonacci(5, memo));
        System.out.println(getFibonacci(6, memo));
        System.out.println(getFibonacci(8, memo));
        System.out.println(getFibonacci(100, memo));
    }

    public static long getFibonacci(int n, HashMap<String,Long> memo) {
        String key = String.valueOf(n);
        if (memo.containsKey(key)) return memo.get(key);
        if (n == 1 || n == 2) return 1;
        memo.put(key, getFibonacci(n - 1, memo) + getFibonacci(n - 2, memo));
        return memo.get(key);
    }
}
