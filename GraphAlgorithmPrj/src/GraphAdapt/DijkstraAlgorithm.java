package GraphAdapt;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import Graph.GraphClass;
import Graph.GraphClass.EdgeInfo;
import Graph.GraphClass.Vertex;

public class DijkstraAlgorithm implements GraphAdapt {
	private int[] dist;
	@Override
	public void run(GraphClass graph) {
		
		// TODO Auto-generated method stub
		dist = new int[graph.getVertex().size()];
		Vertex start_vertex;
		for(int i = 0 ; i <dist.length ; i++)
		{
			dist[i] = Integer.MAX_VALUE;
		}
		{
			System.out.print("In Start Vertex >>");
			int start = new Scanner(System.in).nextInt();
			start_vertex = graph.getVertex().get(start-1);
			dist[start-1] = 0;
		}
		process(start_vertex);
	}
	private void process(Vertex start)
	{
		Vertex now_vertex;
		now_vertex = start;
		Iterator<EdgeInfo> iterator;
		Queue<Vertex> queue  = new LinkedList<Vertex>();
		while(!now_vertex.getVisit()) {
			iterator = now_vertex.getEdge().iterator();
			while(iterator.hasNext())
			{
				EdgeInfo edge = (EdgeInfo)iterator.next();
				queue.add(edge.getVertexafter());
				dist[edge.getVertexafter().getNumber()] = (dist[edge.getVertexafter().getNumber()] > edge.getEdge_value()+dist[now_vertex.getNumber()])? 
						edge.getEdge_value()+dist[now_vertex.getNumber()]:dist[edge.getVertexafter().getNumber()];
			}
			if(queue.isEmpty())
			{
				break;
			}
			Vertex afterVisitVertex = queue.remove();
			int stack_size = queue.size();
			for(int i = 0 ; i <stack_size;i++)
			{
				Vertex if_min = queue.remove();
				if(dist[afterVisitVertex.getNumber()] > dist[if_min.getNumber()])
				{
					afterVisitVertex = if_min;
				}
				else if(dist[afterVisitVertex.getNumber()] == dist[if_min.getNumber()]
						&& afterVisitVertex.getKey() > if_min.getKey() )
				{
					afterVisitVertex = if_min;
				}
				else{
					queue.add(if_min);
				}
			}
		System.out.println("Table===============================");
		for(Integer number: dist)
		{
			System.out.print(number+"  ");
		}
		System.out.println("");
		now_vertex.visitVertex();
		now_vertex = afterVisitVertex;
		}
	}
}