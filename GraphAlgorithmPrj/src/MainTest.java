import Graph.GraphClass;
import GraphAdapt.BFS;
import GraphAdapt.DFS;
import GraphAdapt.DijkstraAlgorithm;
public class MainTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphClass graph;
		graph = new GraphClass();
		graph.addVertex(new GraphClass.Vertex(0));
		graph.addVertex(new GraphClass.Vertex(1));
		graph.addVertex(new GraphClass.Vertex(2));
		graph.addVertex(new GraphClass.Vertex(3));
		graph.addVertex(new GraphClass.Vertex(4));
		
		graph.connect_Vertex_Once(graph.getVertex().get(0),graph.getVertex().get(2),6);
		graph.connect_Vertex_Once(graph.getVertex().get(1),graph.getVertex().get(0),3);
		graph.connect_Vertex_Once(graph.getVertex().get(0),graph.getVertex().get(3),3);
		graph.connect_Vertex_Once(graph.getVertex().get(2),graph.getVertex().get(3),2);
		graph.connect_Vertex_Once(graph.getVertex().get(3),graph.getVertex().get(2),1);
		graph.connect_Vertex_Once(graph.getVertex().get(3),graph.getVertex().get(1),1);
		graph.connect_Vertex_Once(graph.getVertex().get(4),graph.getVertex().get(1),4);
		graph.connect_Vertex_Once(graph.getVertex().get(4),graph.getVertex().get(3),2);
				
		graph.run(new DijkstraAlgorithm());
	}
}
