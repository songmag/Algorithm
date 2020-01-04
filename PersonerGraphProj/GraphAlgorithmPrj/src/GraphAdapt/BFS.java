package GraphAdapt;

import java.util.LinkedList;
import java.util.Queue;

import Graph.GraphClass;
import Graph.GraphClass.EdgeInfo;
import Graph.GraphClass.Vertex;

public class BFS implements GraphAdapt {
	Queue<Vertex> queue;
	
	@Override
	public void run(GraphClass graph) {
		// TODO Auto-generated method stub
		queue = new LinkedList<Vertex>();
		queue.add(graph.getVertex().get(0));
		re_process();
	}
	private void re_process()
	{
		if(queue.isEmpty()) return;
		Vertex vertex = queue.remove();
		if(vertex.getVisit()) {re_process(); return;}
		vertex.visitVertex();
		System.out.println(vertex.getNumber());
		for(EdgeInfo edge : vertex.getEdge())
		{
			queue.add(edge.getVertexafter());
		}
		re_process();
	}
}
