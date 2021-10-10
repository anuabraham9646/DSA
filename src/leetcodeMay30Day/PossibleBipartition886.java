package leetcodeMay30Day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PossibleBipartition886 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N= 5;
		int[][] dislikes= new int[][] {{1,2},{1,3},{2,4}};
		System.out.println(possibleBipartition(N,dislikes));

	}

	public static boolean possibleBipartition(int N, int[][] dislikes) {

		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		// we create a graph as array of arraylist
		// each index starting from 1 means 1 node we go from 1 to N rather than 0 to
		// N-1
		// it will store which all other node is disliked by a node
		// like 1 dislikes both 2 &3 hence arr[1]= {2,3} likewise

		for (int i = 1; i <= N; ++i)
			graph[i] = new ArrayList();

		int[] col = new int[N + 1];
		// likewise we give each member a team or colour either colour 1 or 2 we go from
		// 1 to N rather than 0

		for (int temp[] : dislikes) {
			// [1,2] here 1 dislike 2 and vice versa hence arr[1]={2} && arr[2]= 1
			// kinda like creating edges.
			graph[temp[0]].add(temp[1]);
			graph[temp[1]].add(temp[0]);
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			// suppose a node is already assigned a team we skip it
			if (col[i] > 0)
				continue;

			// suppose it isnt assigned a colour we give 1 and add it to queue
			col[i] = 1;
			q.add(i);

			// do bfs
			boolean success = bfs(q, col, graph);

			// success means suppose if the BFS happend fully or not
			// suppose node 2 was assigned colour 1 but in BFS it says we should give it 1
			// itll break out and give false meaning a disagreement in colouring hence we
			// cannot bi partition it
			if (!success)
				return false;

		}

		return true;
	}

	public static boolean bfs(Queue<Integer> q, int[] col, ArrayList<Integer>[] graph) {

		while (!q.isEmpty()) {
			int current = q.poll();
			int colour = col[current];
			// we check the current node colour if its 1 give 2 or vice versa
			int alt_col = colour == 1 ? 2 : 1;

			// graph[current]is a node so effectively we are goingg thru all of its edges
			// which it dislikes and
			// who should not be in our current nodes team
			for (int val : graph[current]) {

				// suppose Node 1 is 1 and its disliked edge is also the same coulour then we
				// return false we cant
				// bi partition it
				if (col[val] == colour)
					return false;
				// if not coloured yet then we give a colour alternate to our current nodes
				// colour
				if (col[val] == 0) {
					col[val] = alt_col;
					q.add(val);
				}

				// suppose a guy is already coloured which is differnt from the current node
				// then no need of redoing it
				// continue it
			}
		}

		return true;
	}

}
