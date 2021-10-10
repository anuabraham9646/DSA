package graph;

import java.util.*;

public class TopologicalSort {

	public static void main(String args[]) {
		TopologicalSort t = new TopologicalSort();
		t.indegreeSort();
	}

	public static void indegreeSort() {
		VertexIndegree v1 = new VertexIndegree("1");
		VertexIndegree v2 = new VertexIndegree("2");
		VertexIndegree v3 = new VertexIndegree("3");
		VertexIndegree v4 = new VertexIndegree("4");
		VertexIndegree v5 = new VertexIndegree("5");
		VertexIndegree v6 = new VertexIndegree("6");

		v1.addNeighbour(v2);
		v1.addNeighbour(v4);
		v1.addNeighbour(v6);
		v3.addNeighbour(v1);
		v3.addNeighbour(v4);
		v4.addNeighbour(v2);
		v4.addNeighbour(v5);
		v6.addNeighbour(v5);

		List<VertexIndegree> graph = new ArrayList<>();
		graph.add(v1);
		graph.add(v2);
		graph.add(v3);
		graph.add(v4);
		graph.add(v5);
		graph.add(v6);

		//for (int i = 0; i < graph.size(); i++)
			//System.out.println(graph.get(i).toString() + " " + graph.get(i).getInDegree());
		Queue<VertexIndegree> zeroIndegree = new LinkedList<>();
		List<VertexIndegree> topSort = new ArrayList<>();

		for (VertexIndegree v : graph) {
			if (v.getInDegree() == 0) {
				zeroIndegree.add(v);
			}
		}

		while (!zeroIndegree.isEmpty()) {
			VertexIndegree current = zeroIndegree.poll();

		}

	}

	/*
	 * VertexIndegree vG= new VertexIndegree("G"); VertexIndegree vH= new
	 * VertexIndegree("H");
	 */

}
