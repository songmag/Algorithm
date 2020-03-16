package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    Arrays.stream(solution.solution(new int[]{6,9,5,7,4})).forEach(Main::print);
	    System.out.println();
	    Arrays.stream(solution.solution(new int[]{3,9,9,3,5,7,2})).forEach(Main::print);
        System.out.println();
	    Arrays.stream(solution.solution(new int[]{1,5,3,6,7,6,5})).forEach(Main::print);
    }
    public static void print(int e)
    {
        System.out.print(e+",");
    }
}
class Solution {
    Stack<int[]> stack= new Stack<int[]>();
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        int length = heights.length;
        stack.push(new int[]{0,heights[0]});
        answer[0] = 0;
        int[] max;
        for(int i = 1 ; i < length ; i++) {
            stack.clear();
            max = stack.peek();
            if(max[1] > heights[i])
            {
                answer[i] = max[0]+1;
            }
            else {
                while(!stack.isEmpty())
                {
                    max = stack.peek();
                    if(max[1] <= heights[i]) stack.pop();
                    else {
                        answer[i] = max[0] + 1;
                        break;
                    }
                }
                if(stack.isEmpty())
                {
                    answer[i] = 0;
                }
            }
            stack.push(new int[]{i,heights[i]});
        }

        return answer;
    }
}