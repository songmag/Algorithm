# Language
  Java
# Algorithm
  Graph DFS,BFS 구현
  최단경로 알고리즘 구현
# First Commit
  Graph Class , DFS , BFS
# Graph Package
  - Graph Class
    - member
      - LinkedList<Vertex> vetex
    - method
      - addVertex(Vertex) :void
      - getVertex() :LinkedList<Vertex>
      - run(GraphAdapt) :void; //GraphAdapt.run(this)
      - connect_Vertex(Vertex,Vertex,int) :void; //vertex 연결
    - inner Class : Main used Static
      - public static class Vertex
        - member
          - LinkedList<EdgeInfo> edge
          - int number
          - boolean visit
          - getter, setter
        - method
          - getLastEdge():void
          - addEdge(EdgeInfo edge):void
          - getVisit():boolean
          - visitVertex() :void
       - public static class EdgeInfo
        - member
          - private final Vertex afterVertex
          - private int edge_value
          - getter, setter
          - constructor(Vertex,int)
# GraphAdapt Package
  - Interface : GraphAdapt : run(Graph) 
  - BFS Class implements GraphAdapt
    - run(Graph):void
    - (-re_process()):void
  - DFS Class implements GraphAdapt
    - run(Graph):void
    - (-re_process(Vertex)):void
  
