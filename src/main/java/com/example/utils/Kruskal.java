package com.example.utils;

import java.util.*;

public class Kruskal {
   private final Graph graph;
   private final Map<String, String> map;

   public Kruskal(Graph graph) {
       this.graph = graph;
       map = new HashMap<>();
   }

   public void sortByWeight() {
       graph.getNodes().sort(Comparator.comparingDouble(Edge::getWeight));
   }

   public void vertex(){
       Set<String> vertex = new HashSet<>();
       for (Edge node : graph.getNodes()) {
           vertex.add(node.getX());
           vertex.add(node.getY());
       }
       for(String v : vertex){
            map.put(v, v);
       }
   }

    public String find(String vertex) {
        while (!map.get(vertex).equals(vertex)) {
            vertex = map.get(vertex);
        }
        return vertex;
    }

    public void union(String v1, String v2) {
        String root1 = find(v1);
        String root2 = find(v2);
        if (!root1.equals(root2)) {
            map.put(root2, root1);
        }
    }

    public List<Edge> calcKruskal() {
       List<Edge> mst = new ArrayList<>();
       sortByWeight();
       vertex();

        for (Edge edge : graph.getNodes()) {
            String rootX = find(edge.getX());
            String rootY = find(edge.getY());
            if (!rootX.equals(rootY)) {
                mst.add(edge);
                union(rootX, rootY);
            }
        }
       return mst;
    }

}
