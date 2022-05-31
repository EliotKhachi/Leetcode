import java.util.HashMap;
import static java.lang.Math.max;

public class GoldCollector {
    static int MAX = 10;
    static int MIN = 0;
    static int ROW = 100;
    static int COL = 100;
    public static void main (String[] args) {
        HashMap<String,Long> memo = new HashMap<>();
        int[][] grid = new int[ROW][COL];
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0 ; j < grid[i].length; j++) {
                grid[i][j] = (int) (Math.random() * (MAX - MIN));
            }
        }
        printArray(grid);
        System.out.println(goldCollector(grid, 0, 0, memo));
    }
    public static long goldCollector(int[][] grid, int m, int n, HashMap<String, Long> memo) {
        String key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);
        if (m == ROW || n == COL) return 0;
        if (m == ROW - 1 && n == COL - 1) return grid[m][n];
        memo.put(key, max(grid[m][n] + goldCollector(grid, m + 1, n, memo), grid[m][n] + goldCollector(grid, m, n + 1, memo)));
        return memo.get(key);
    }
    public static void printArray(int[][] array) {
        System.out.println("[");
        for (int i = 0; i < array.length; i ++) {
            System.out.print("[");
            for (int j = 0 ; j < array[i].length; j++) {
                System.out.print(array[i][j] + ",");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}