package com.company;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6,new int[]{10,7}));
    }
}
class LongObject  implements Comparable<LongObject>
{
    Long item;
    Long time;
    LongObject(int aLong)
    {
        this.item = Long.valueOf(0);
        this.time = Long.valueOf(aLong);
    }
    public void addTime(Long time)
    {
        this.item += time;
    }
    @Override
    public int compareTo(LongObject longObject) {
        if(this.item > longObject.item) return 1;
        else return -1;
    }
}
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Queue<LongObject> queue= new PriorityQueue<LongObject>();
        int length = times.length;
        for(int i = 0 ; i < length;i++)
        {
            queue.offer(new LongObject(times[i]));
        }
        for(int i = n; i >= 0 ; i--)
        {
            LongObject item = queue.poll();
            item.addTime(item.time);
            queue.offer(item);
        }
        while(queue.size() == 1)
        {
            queue.poll();
        }
        return queue.poll().item;
    }
}