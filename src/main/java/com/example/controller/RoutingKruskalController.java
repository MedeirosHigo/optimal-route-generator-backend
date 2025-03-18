package com.example.controller;

import com.example.requestDTO.KruskalRequest;
import com.example.responseDTO.KruskalResponse;
import com.example.service.RoutingKruskalService;
import com.example.utils.Edge;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/kruskal/")
@CrossOrigin(origins = "*")
public class RoutingKruskalController {

    private final RoutingKruskalService routingKruskalService;

    @PostMapping("mst")
    public List<KruskalResponse> kruskalKruskal(@RequestBody List<KruskalRequest> edgesRequests) {

        List<Edge> edges = edgesRequests.stream().map( e -> new Edge(e.getX(),e.getY(),e.getDistance())).collect(Collectors.toList());

        List<Edge> result = routingKruskalService.computeMST(edges);

        return result.stream()
                .map(edge -> new KruskalResponse(edge.getX(), edge.getY(), edge.getWeight()))
                .collect(Collectors.toList());
    }
}
