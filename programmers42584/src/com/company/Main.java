package com.company;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0 ; i < prices.length;i++)
        {
            int time=0;
            for(int j = i+1;j < prices.length ; j++)
            {
                if(prices[i] <= prices[j])
                {
                    time++;
                }
                else {
                    time++;
                    break;
                }
            }
            answer[i] = time;
        }
        return answer;
    }
}
/**
 * 42584
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,\
 * 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 * 입출력 예시
 * [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0] -> 결 \
 * 1이 [2,3,2,3] 을 보며 1보다 작은 값이 나오는 것을 확인 4
 * 2이 [3,2,3] 을 보며 2보다 작은 값이 나오는 것을 확인 3
 * 3이 [2,3] 을 보며 3보다 작은 값이 나오는 것을 확인 1
 * 2이 [3] 을 보며 2보다 작은 값이 나오는 것을 확인 1
 * 3이 [] 을 보며 3보다 작은 값이 나오는 것을 확인 0
 * stack/큐 문제이다... 근데 왜 그냥 풀면 풀리지..
 */

public class Main {
    public static void main(String[] args) {
	    Solution solution=new Solution();
	    Arrays.stream(solution.solution(new int[]{1,2,3,2,3})).forEach(System.out::println);
    }
}
