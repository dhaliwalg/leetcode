/**
 * LeetCode Problem: Daily Temperatures
 * 
 * Given a list of daily temperatures T, return a list such that, for each day in the input, 
 * tells you how many days you would have to wait until a warmer temperature. 
 * If there is no future day for which this is possible, put 0 instead.
 * 
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], 
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * Note: The length of temperatures will be in the range [1, 30000]. 
 * Each temperature will be an integer in the range [30, 100].
 */
import java.util.*;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperature) {
        Stack<Integer> tempStack = new Stack<>();
        int[] result = new int[temperature.length];

        for (int i = 0; i < temperature.length; i++) {
            while(!tempStack.isEmpty() && temperature[i] > temperature[tempStack.peek()]){
                int tmpIdx = tempStack.pop();
                result[tmpIdx] = i - tmpIdx;
            }
            tempStack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);
        for (int days : result) {
            System.out.print(days + " ");
        }
    }
}