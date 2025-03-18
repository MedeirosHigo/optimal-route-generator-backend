package com.example.service;

import com.example.utils.Edge;
import com.example.utils.Graph;
import com.example.utils.Kruskal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoutingKruskalService {

    public List<Edge> computeMST(List<Edge> edges) {
        Graph g = new Graph(edges);
        Kruskal k = new Kruskal(g);
        return k.calcKruskal();
    }
}
