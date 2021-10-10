package graph;

import java.util.*;
public class Vertex {
	private String value;
	private boolean visited;
	private List<Vertex> neighbours;
	
	
	
	public Vertex(String value) {
		super();
		this.value = value;
		this.neighbours= new ArrayList<Vertex>();
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
	public List<Vertex> getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(List<Vertex> neighbours) {
		this.neighbours = neighbours;
	}
	public void addNeighbour(Vertex v) {
		this.neighbours.add(v);
	}
	@Override
	public String toString() {
		return " "+this.value;
	}

}
