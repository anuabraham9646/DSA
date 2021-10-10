package graph;

public class Maze {
	private int[][] map;
	private boolean [][] visited;
	private int startrow,startcol;
	private int destRw,destCl;
	
	public Maze(int[][] map, int startrow, int startcol) {
		super();
		this.map = map;
		this.visited= new boolean [map.length][map[0].length];
		this.startrow = startrow;
		this.startcol = startcol;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++)
				System.out.print(" "+map[i][j]);
		}
		System.out.println(" ");
	}
	
	public void findWay() {
		
		try {
			dfs(startrow,startcol);
			System.out.println("No clear exit");
		}
		catch(RuntimeException e) {
			System.out.println("Found way out");
			/*System.out.println(destRw);
			System.out.println(destCl);*/
		}
		
	}

	private void dfs(int startrow2, int startcol2) {
		
		
		//exit found
		if(map[startrow2][startcol2]==3) {
			destRw=startrow2;
			destCl=startcol2;
			throw new RuntimeException();
		}
		
		
		
		//already visited
		if(visited[startrow2][startcol2])
			return;	
		
		// rows outside map
		else if(startrow2 <0 || startrow2 > map.length-1)
			return;
		
		//col outside map
		else if (startcol2 <0 || startcol2> map[startrow2].length-1)
			return;
				
		//wall found
		else if(map[startrow2][startcol2]==1)
			return;
		
		else {
			System.out.println("Visiting node"+map[startrow2][startcol2]+" row "+ startrow2+" column "+startcol2);
			visited[startrow2][startcol2]=true;
			dfs(startrow2-1,startcol2);
			dfs(startrow2+1,startcol2);
			dfs(startrow2,startcol2-1);
			dfs(startrow2,startcol2+1);
		}
		
	}
	
	
	

}
