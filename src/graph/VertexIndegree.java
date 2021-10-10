package graph;

import java.util.ArrayList;
import java.util.List;

public class VertexIndegree {
	
	private String value;
	private int inDegree;
	private boolean visited;
	private List<VertexIndegree> neighbours;
	
	
	
	public VertexIndegree(String value) {
		super();
		this.value = value;
		this.inDegree=0;
		this.neighbours= new ArrayList<VertexIndegree>();
	}
	
	
	public int getInDegree() {
		return inDegree;
	}
	public void setInDegree(int inDegree) {
		this.inDegree = inDegree;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public List<VertexIndegree> getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(List<VertexIndegree> neighbours) {
		this.neighbours = neighbours;
	}
	public void addNeighbour(VertexIndegree v) {
		this.neighbours.add(v);
		v.setInDegree(v.getInDegree()+1);
	}
	@Override
	public String toString() {
		return " "+this.value;
	}
}
