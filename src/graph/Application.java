package graph;

public class Application {

	public static void main(String[] args) {


		DFS d= new DFS();
		Vertex vA= new Vertex("A");
		Vertex vB= new Vertex("B");
		Vertex vC= new Vertex("C");
		Vertex vD= new Vertex("D");
		Vertex vE= new Vertex("E");
		Vertex vF= new Vertex("F");
		Vertex vG= new Vertex("G");
		Vertex vH= new Vertex("H");
		
		vA.addNeighbour(vB);
		vA.addNeighbour(vF);
		vA.addNeighbour(vG);
		vB.addNeighbour(vC);
		vB.addNeighbour(vD);
		vD.addNeighbour(vE);
		vG.addNeighbour(vH);
		
		d.dfsStack(vA);
		
		System.out.println("\n Next recursion \n");
		vA.setVisited(false);
		vB.setVisited(false);
		vC.setVisited(false);
		vD.setVisited(false);
		vE.setVisited(false);
		vF.setVisited(false);
		vG.setVisited(false);
		vH.setVisited(false);
		
		d.dfsRecursion(vA);

	}

}
