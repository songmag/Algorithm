import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			int m = scan.nextInt();
			scan.nextLine(); // Buffer ����		
			String[] line = new String[n];
			for(int i = 0 ; i<n;i++)
			{
				line[i] = scan.nextLine();
			}
			scan.close();
			BFSClass runclass = new BFSClass(n,m);
			runclass.makeRun(line);
			System.out.println(runclass.runMin(n, m));
		}
	}
class DFSClass{
		public boolean[][] map;
		public DFSClass(int n, int m)
		{
			map = new boolean[n][m];
		}
		public void makeRun(String[] lines) {
			for(int i = 0 ; i< lines.length; i++)
			{
				String line = lines[i];
				for(int j = 0 ; j < line.length() ; j++)
				{
					if(line.charAt(j) == '0')
					{
						map[i][j] = true;
						continue;
					}
					map[i][j] = false;
				}
			}
		}
		public int getCount(int n,int m)
		{
			map[0][0] = true;
			int down = r_getCount(n,m,1,0,0,copyMap(this.map));
			int right = r_getCount(n,m,0,1,0,copyMap(this.map));
			int min = (down > right)? right : down;
			return min;
		}
		private boolean[][] copyMap(boolean[][] map) {
			boolean[][] temp_map;
			temp_map = new boolean[map.length][map[0].length];
			for(int i = 0 ; i < map.length ; i++)
			{
				for(int j = 0 ; j<map[0].length ; j++)
				{
					temp_map[i][j] = map[i][j];
				}
			}
			return temp_map;
		}
		private int r_getCount(int n, int m,int x,int y,int count,boolean[][] map)
		{
			if(x < 0 || y <0 || x >= n || y >= m)
			{
				return Integer.MAX_VALUE;
			}
			if(map[x][y]==true)
				return Integer.MAX_VALUE;
			if(map[x][y] == false)
			{
				map[x][y] = true;
				count += 1;
				if(x+1 == n && y+1 ==m)
				{
					return count + 1;
				}
			}
			int top =  r_getCount(n,m,x,y-1,count,copyMap(map));
			int bottom = r_getCount(n,m,x,y+1,count,copyMap(map));
			int left = r_getCount(n,m,x-1,y,count,copyMap(map));
			int right = r_getCount(n,m,x+1,y,count,copyMap(map));
			return min(top,bottom,left,right);
		}
		public int min(int x,int y, int z, int w)
		{
			int min = 0;
			min = x;
			min = (min != 0 && min < y)? min:y;
			min = (min != 0 && min < z)? min:z;
			min = (min != 0 && min < w)? min:w;
			return min;
		}
}
class BFSClass{
		MapStruct[][] map;
		class MapStruct{
			int[] index;
			public boolean visit;
			public int label;
			public MapStruct(boolean value,int[] index)
			{	
				visit = value;
				label = Integer.MAX_VALUE;
				this.index = index;
			}
			public boolean visit(int count)
			{
				if(visit)
				{
					return false;
				}
				label = count;
				visit = true;
				return true;
			}
			public int[] bottom()
			{
				return new int[]{index[0]+1,index[1]}; 
			}
			public int[] right()
			{
				return new int[] {index[0],index[1]+1};
			}
			public int[] top()
			{
				return new int[] {index[0]-1,index[1]};
			}
			public int[] left()
			{
				return new int[] {index[0],index[1]-1};
			}
		}
		public BFSClass(int n, int m)
		{
			map = new MapStruct[n][m];
		}
		public void makeRun(String[] lines) {
			for(int i = 0 ; i< lines.length; i++)
			{
				String line = lines[i];
				for(int j = 0 ; j < line.length() ; j++)
				{
					if(line.charAt(j) == '0')
					{
						map[i][j] = new MapStruct(true,new int[] {i,j});
						continue;
					}
					map[i][j] = new MapStruct(false,new int[] {i,j});
				}
			}
		}
		public int runMin(int n, int m) {
			Queue<MapStruct> q;
			q = new LinkedList<MapStruct>();
			MapStruct point= map[0][0];
			point.visit(1);
			q.add(point);
			while(!q.isEmpty()){
				MapStruct temp,temp_right,temp_bottom,temp_left,temp_top;
				temp=q.poll();
				int[] right_index = temp.right(),bottom_index = temp.bottom()
						,left_index = temp.left(), top_index = temp.top();
				if(right_index[0] < n && right_index[1] < m) {
					temp_right = map[right_index[0]][right_index[1]];
					if(temp_right.visit(temp.label+1))
					{
						q.add(temp_right);
					}
				}
				if(bottom_index[0] < n && bottom_index[1] < m) {
					temp_bottom = map[bottom_index[0]][bottom_index[1]];
					if(temp_bottom.visit(temp.label+1))
					{
						q.add(temp_bottom);
					}	
				}
				if(left_index[1] >=0)
				{
					temp_left = map[left_index[0]][left_index[1]];
					if(temp_left.visit(temp.label+1))
					{
						q.add(temp_left);
					}	
					
				}
				if(top_index[0] >= 0)
				{
					temp_top = map[top_index[0]][top_index[1]];
					if(temp_top.visit(temp.label+1))
					{
						q.add(temp_top);
					}	
					
				}
			}
			return map[n-1][m-1].label;
		}
}

