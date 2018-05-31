/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.strategy;

/**
 *
 * @author root
 */
public class GraphEdge {
    GraphNode src;
    GraphNode dst;
    GraphNode distance;

    public GraphEdge(GraphNode new_src, GraphNode new_dst, GraphNode new_distance) {
        this.src = new_src;
        this.dst = new_dst;
        this.distance = new_distance;
    }
    
    
}
