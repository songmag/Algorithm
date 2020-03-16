package com.company;

import java.awt.Point;
import java.util.*;

class Solution {
    static final int[][] vector = new int[][]{{0,-1},{0,1},{-1,0},{1,0}}; //Left, Right, Top , Bottom
    public int[] solution(int m, int n, int[][] picture) {
        RectBox box = new RectBox(m,n);
        box.setPicture(picture);
        int[] answer= new int[2];
        answer[0]=box.getAreaSplit();
        answer[1]=box.getAreaOfBestArea();

        return answer;
    }
    final class RectBox{
        private int width,height;
        private Node[][] map;
        Map<Integer,Integer> area;
        private Queue<Node> tempNode;
        private int maxArea;
        private int areaOfBestArea;
        RectBox(int pictureHeight,int pictureWidth)
        {
            width = pictureWidth;
            height= pictureHeight;
            map = new Node[height][width];
            maxArea = 0;
            areaOfBestArea = 0;
            area = new HashMap<Integer,Integer>();
        }
        public boolean containCheck(int[] point)
        {
            if(point[1] < 0 || point[1] >= width || point[0] < 0 || point[0] >= height) return false;
            return true;
        }
        public void setPicture(int[][] picture)
        {
            tempNode = new LinkedList<Node>();
          for(int i = 0 ; i < height ; i++)
          {
              for(int j = 0 ; j< width ;j++)
              {
                  if(picture[i][j] == 0) map[i][j] = null;
                  else {
                      map[i][j] = new Node(j, i, picture[i][j]);
                      tempNode.offer(map[i][j]);
                  }
              }
          }
        }
        /**
         *
         * @return maxArea
         */
        public int getAreaSplit() {
            maxArea = 0;
            Queue<Node> bfsQueue = new LinkedList<Node>();
            while(!tempNode.isEmpty()) {
                Node newAreaNode = tempNode.poll();
                if(newAreaNode.local == 0) {
                    maxArea += 1;
                }
                else continue;
                bfsQueue.offer(newAreaNode);
                while (!bfsQueue.isEmpty()) {
                    Node node = bfsQueue.poll();
                    if(node.local != 0) continue;
                    node.local = maxArea;
                    if(!area.containsKey(node.local)) area.put(node.getLocal(),1);
                    else area.put(node.getLocal(),area.get(node.getLocal())+1);
                    for (int i = 0; i < 4; i++) //Left, Right, Top , Bottom
                    {
                        Node friend = null;
                        if (containCheck(new int[]{node.y + vector[i][0], node.x + vector[i][1]}))
                            friend = map[node.y + vector[i][0]][node.x + vector[i][1]];
                        //left, right, top, bottom 의 Node를 가져온다 이때, null이면 없는것이거나, 아니면 벽이라 제외한다.
                        if (friend == null) continue;
                        if (friend.local != 0)
                            continue;
                        else if (friend.color != node.color && friend.local == 0) {
                            continue;
                        }
                        //color 가 같고, local 이 0 이면
                        else {
                            bfsQueue.offer(friend);
                        }
                    }
                }
            }
            return maxArea;
        }
        public int getAreaOfBestArea()
        {
            Set<Map.Entry<Integer, Integer>> entries = area.entrySet();
            for(Map.Entry<Integer,Integer> e: entries)
            {
                areaOfBestArea = Math.max(e.getValue(),areaOfBestArea);
            }
            return areaOfBestArea;
        }
    }
    class Node{
        static final int LEFT=0,RIGHT=1,TOP=2,BOTTOM=3;
        int color;
        int x,y;
        int local;
        Node(int x, int y, int color)
        {
            this.x = x;
            this.y = y;
            local = 0;
            this.color = color;
        }
        public boolean isInArea() {if(local == 0) return false; return true; }
        public int getLocal() {
            return local;
        }
        public void setLocal(int local) {
            this.local = local;
        }
        public int getColor() {
            return color;
        }
    }
}
/**
 * 출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다.\
 * 여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 \
 * 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)
 *
 * 그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.
 * 영역 : 상하 좌우 연결되어있는 색상이 같으면 영역에 속한다.
 *
 */
public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    solution.solution(6,4,new int[][]{{1,1,1,0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
        solution.solution(13,16,new int[][]{{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0}, {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}});
    }
}
