package Graph;

import java.util.LinkedList;

import GraphAdapt.GraphAdapt;

public class GraphClass {
	LinkedList<Vertex> vertex;
	public static class EdgeInfo
	{
		private final Vertex vertexafter;
		private int edge_value;
		public EdgeInfo(Vertex vertexafter, int edge_value) {
			this.vertexafter = vertexafter;
			this.edge_value = edge_value;
		}
		public Vertex getVertexafter() {
			return vertexafter;
		}
		public int getEdge_value() {
			return edge_value;
		}
		public void change_EdgeValue(int value) {this.edge_value = value;}
	}
	public static class Vertex
	{
		private final int number;
		private boolean visit;
		private LinkedList<EdgeInfo> edge;
		public Vertex(int number) {
			this.number = number;
			edge = new LinkedList<EdgeInfo>();
			visit = false;
		}
		public int getNumber() {
			return number;
		}
		public LinkedList<EdgeInfo> getEdge() {
			return edge;
		}
		public EdgeInfo getLastEdge()
		{
			return this.edge.getLast();
		}
		public void addEdge(EdgeInfo edge) {
			this.edge.add(edge);
		}
		public boolean getVisit() {return visit;}
		public void visitVertex() {this.visit = true;}
		
	}
	public GraphClass() {
		vertex = new LinkedList<Vertex>();
	}
	public GraphClass(LinkedList<Vertex> vertex) {
		this.vertex = vertex;
	}
	public LinkedList<Vertex> getVertex() {
		return vertex;
	}
	public void addVertex(Vertex vertex) {
		this.vertex.add(vertex);
	}
	public void run(GraphAdapt adapt) {
		adapt.run(this);
	}
	public void connect_Vertex(Vertex after,Vertex before, int edge_value)
	{
		after.addEdge(new EdgeInfo(before,edge_value));
		before.addEdge(new EdgeInfo(after,edge_value));
	}
}