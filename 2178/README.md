2178
====
# Size get First Line
+ Scanner.nextInt() * 2 = get n,m
+ another lines Map
	<code>
		String[] line = new String[n];
		for(int i = 0 ; i<n;i++)
		{
			line[i] = scan.nextLine();
		}
	</code>
# DFS Ver
+ Time Over 
    + have boolean[][] map; lines = n, line = m (Make map)
        <pre>
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
        </pre> 
    + IDEA > DFS는 모든 루트를 돈다
    + 따라서 갈 수 있는 방향에 대해 정의를 내리고, 각각 돌았을때, 제일 적은 수만큼 돈 경로에 대해서만 유효하다고 정의한다.
    + 각각 Map 을 복사해서 모든 시작점에 대해 앞,뒤,좌,우를 보고 이동한다. 따라서 시간이 오래 걸린다. 무조건적으로 최단경로가 나온다고 장담할 수 없다는 것이 문제다.<br>
# BFS Ver
+ Correct Answer
    + have Class MapStruct
        <pre>
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
        </pre>
    + BFS Run
        <pre>
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
        </pre>
