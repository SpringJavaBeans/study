import java.util.*;

public class 타겟넘버 {

    private static int result = 0;
    public static void dfs(int[] numbers, int target, int level, int sum) {
        if(level == numbers.length) {
            if(sum ==target) {
                result++;
            }
            return;
        }
        dfs(numbers, target, level + 1, sum +numbers[level]);
        dfs(numbers, target, level + 1, sum - numbers[level]);
    }

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        dfs(numbers, target, 0, 0);
        System.out.println("result" + result);
    }
}
