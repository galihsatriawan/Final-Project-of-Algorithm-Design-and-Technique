/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.strategy;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class GraphNode {

    private int id;
    private String nama;
    private ArrayList<GraphEdge> kump_tetangga;

    public GraphNode() {
        
    }
    
    public GraphNode(int id, String nama) {
        this.id = id;
        this.nama = nama;
        kump_tetangga = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<GraphEdge> getKump_tetangga() {
        return kump_tetangga;
    }

    public void setKump_tetangga(ArrayList<GraphEdge> kump_tetangga) {
        this.kump_tetangga = kump_tetangga;
    }
}
