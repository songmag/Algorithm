package com.company;

import java.util.*;

class Solution {
    Queue<Node> queue = new LinkedList<Node>();
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int order=0;
        for(int i : progresses)
        {
            queue.offer(new Node(i,order++));
        }
        int length = speeds.length;
        int count = 0;
        List<Integer> rs = new ArrayList<Integer>();
        Queue<Node> stack = new LinkedList();
        while(!queue.isEmpty())
        {
            while(!queue.isEmpty())
            {
                Node node = queue.poll();
                stack.offer(node.setProgresses(speeds[node.order]));
            }
            while(!stack.isEmpty())
            {
                queue.offer(stack.poll());
            }
            Node node = queue.peek();
            if(node.complete())
            {
                queue.poll();
                count++;
                while(!queue.isEmpty() && queue.peek().complete())
                {
                    queue.poll();
                    count++;
                }
                rs.add(count);
                count = 0;
            }
        }
        answer = new int[rs.size()];
        for(int i =0;i<rs.size();i++)
        {
            answer[i] = rs.get(i);
        }
        return answer;
    }
    class Node {
        int order;
        int progresses;

        Node(int progresses, int order) {
            this.progresses = progresses;
            this.order = order;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getProgresses() {
            return progresses;
        }

        public Node setProgresses(int speed) {
            this.progresses += speed;
            return this;
        }

        public boolean complete(){
            if(progresses < 100) return false;
            return true;
        }
    }
}

/**
 * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 *
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,\
 * 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 *
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 \
 * progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때\
 * 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Arrays.stream(solution.solution(new int[]{93,30,55} ,
                new int[]{1,30,5})).forEach(System.out::println);
    }
}
