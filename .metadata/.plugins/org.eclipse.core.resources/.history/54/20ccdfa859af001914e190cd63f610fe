package GraphAdapt;

import java.util.Iterator;

import Graph.GraphClass;
import Graph.GraphClass.EdgeInfo;
import Graph.GraphClass.Vertex;

public class DFS implements GraphAdapt {
	@Override
	public void run(GraphClass graph) {
		Vertex vertex = graph.getVertex().getFirst();
		Iterator<EdgeInfo> iterator;
		vertex.visitVertex();
		System.out.println(vertex.getNumber());
		iterator = vertex.getEdge().iterator();
		while(iterator.hasNext())
		{
			vertex = iterator.next().getVertexafter();
			re_Process(vertex);
		}
		return;
	}
	private void re_Process(Vertex vertex)
	{
		if(vertex.getVisit()) return;
		Iterator<EdgeInfo> iterator;
		vertex.visitVertex();
		System.out.println(vertex.getNumber());
		iterator = vertex.getEdge().iterator();
		while(iterator.hasNext())
		{
			vertex = iterator.next().getVertexafter();
			re_Process(vertex);
		}
	}
}
