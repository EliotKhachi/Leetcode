import java.util.HashMap;
import java.lang.String;

public class GridTraveler {
    static HashMap<String,Long> memo = new HashMap<>();
    public static void main (String[] args) {
        System.out.println(gridTraveler(1,3, memo));
        System.out.println(gridTraveler(2,3, memo));
        System.out.println(gridTraveler(5,5, memo));

        System.out.println(gridTraveler(22,22, memo));
    }
    public static long gridTraveler(int m, int n, HashMap<String, Long> memo) {
        String key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;
        memo.put(key, gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo));
        return memo.get(key);
    }
}