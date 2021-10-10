package leetcodeMay30Day;

import java.util.ArrayList;

public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = new int[][] { { 1, 0 }};
		int pre = 2;
		System.out.println(canFinish(pre, arr));

	}

	public static boolean canFinish(int numCourses, int[][] pre) {
		
		int [] visited= new int[numCourses];
		ArrayList<Integer>[] edges= new ArrayList[numCourses];
		for(int i=0; i< numCourses;i++) {
			edges[i]= new ArrayList<>();
		}
		for(int i=0;i< pre.length;i++) {
			edges[pre[i][0]].add(pre[i][1]);
		}
		
		for(int i=0; i< visited.length;i++) {
			if(visited[i]==2)
				continue;
			else {
				boolean success = bfs(edges,visited,i);
				
				if(!success )
					return false;
			}
		}
		return true;

	}

	private static  boolean bfs(ArrayList<Integer>[] edges, int[] visited, int i) {
		
		if(visited[i] == 2)
			return true;
		else if(visited[i]==1)
			return false;
		else {
			visited[i]=1;
			for(int j : edges[i]) {
				boolean result =bfs(edges,visited,j);
				if(!result)
					return false;
			}
			visited[i]=2;
			return true;
		}
		
	}

}
