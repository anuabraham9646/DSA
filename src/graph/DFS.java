package graph;
import java.util.*;
public class DFS {
	
	public static void dfsStack(Vertex v) {
		Stack<Vertex> stack = new Stack<>();	
		v.setVisited(true);
		stack.push(v);
		
		while(!stack.isEmpty()) {
			Vertex currentV= stack.pop();
			System.out.println(currentV.toString());
			for(Vertex v1 : currentV.getNeighbours()) {
				if(!v1.isVisited()) {
					v1.setVisited(true);
					stack.push(v1);
				}
			}
		}
		
	}
	
	public static void dfsRecursion(Vertex v) {
		v.setVisited(true);
		System.out.println(v.toString());
		
		for(Vertex v1 : v.getNeighbours()) {
			if(!v1.isVisited())
				dfsRecursion(v1);
		}
	}

}
