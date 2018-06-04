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
    private GraphNode src;
    private GraphNode dst;
    private double distance;

    public GraphEdge(GraphNode new_src, GraphNode new_dst, double new_distance) {
        this.src = new_src;
        this.dst = new_dst;
        this.distance = new_distance;
    }

    public GraphNode getSrc() {
        return src;
    }

    public void setSrc(GraphNode src) {
        this.src = src;
    }

    public GraphNode getDst() {
        return dst;
    }

    public void setDst(GraphNode dst) {
        this.dst = dst;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    
    
}
