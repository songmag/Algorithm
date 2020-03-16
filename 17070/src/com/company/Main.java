package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		GameMap map = new GameMap();
		map.startGame();
	}
}

class GameMap{
	static int SIZE;
	private boolean[][] mapbt;
	static int count;
	//Line 개수 , 맵 상태 1이면 벽 0이면 아무것도 없는 바닥
	GameMap() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		SIZE = Integer.parseInt(reader.readLine());
		mapbt = new boolean[SIZE][SIZE];
		for(int i = 0 ;i < SIZE ;i++)
		{
			String line = reader.readLine().replace(" ","");
			for(int j = 0 ; j <SIZE;j++) {
				mapbt[i][j]= (line.charAt(j) == '0')? true : false;
			}
		}
	}
	public void run(int x,int y,int moveMent)
	{
		if( x >= SIZE || y >= SIZE )
		{
			return;
		} // 가는 곳에 false (즉 벽이면 false) x 가 size 보다 크거나 y 가 size보다 크면 return;
		if(mapbt[y][x] == false)
		{
			return;
		}
		if(moveMent == 2 )
		{
			if(mapbt[y][x-1] == false || mapbt[y-1][x] == false)
				return;
		}
		//대각선 이동시에 해당 비어있어야하는 구간 2군대 y-1, x-1 두군대 다 벽이면 return;
		if(x== SIZE-1 && y== SIZE-1) {
			GameMap.count++;
			return;
		}
		//위에 2가지 조건을 만족하지 않으면서 size-1[n] , size-1[n] 인경우 성공

		//0 right
		//1 down
		//2 cross

		if(moveMent == 0)
		{
			run(x+1,y,0);
		}
		else if(moveMent == 1)
		{
			run(x,y+1,1);
		}
		else
		{
			run(x+1,y,0);
			run(x,y+1,1);
		}
		run(x+1,y+1,2);
	}
	public void startGame()
	{
		count = 0;
		run(1,0,0);
		System.out.println(count);
	}
}