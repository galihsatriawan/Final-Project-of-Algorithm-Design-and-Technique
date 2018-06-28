/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;

/**
 *
 * @author root
 */
public class AlgorithmStrategy {

    /**
     * @param args the command line arguments
     */
    /*
        Dictionary Node :
        - dictionary disini digunakan untuk mempermudah mencari suatu node 
        dengan menggunakan string atau nama dari node tersebut
    */ 
    
    public static HashMap<String,GraphNode> dict_node = new HashMap();
    static HashMap<GraphEdge,Boolean> edge_visited = new HashMap<>();
    
    static ArrayList<GraphEdge> list_edge = new ArrayList<>();
    //Kumpulan Node
    public static ArrayList<GraphNode> kump_node = new ArrayList<>();
    
    // insert node
    static void insertKump_Node(GraphNode new_node){
        kump_node.add(new_node);
        insertDict_Node(new_node.getNama(), new_node);
    }
    
    static void insertDict_Node(String new_key, GraphNode new_node){
        dict_node.put(new_key, new_node);
    }
    
    static void insertEdgeDuaArah(String node1,String node2,double length){
        // Cari node nya terlebih dahulu
        GraphNode node_1 = dict_node.get(node1);
        GraphNode node_2 = dict_node.get(node2);
        
        //Buat edge nya
        GraphEdge edge_baru1 = new GraphEdge(node_1, node_2, length);
        GraphEdge edge_baru2 = new GraphEdge(node_2, node_1, length);
        
        // Tambahkan ke daftar tetangga
        node_1.getKump_tetangga().add(edge_baru1);
        node_2.getKump_tetangga().add(edge_baru2);
        
        //tambahkan ke dictionary
        dict_edge.put(new Pair(node1,node2), edge_baru1);
        dict_edge.put(new Pair(node2,node1), edge_baru2);
        //Tambahkan ke list , karena dua arah maka yang dipakai 2 nya
        list_edge.add(edge_baru1);
        list_edge.add(edge_baru2);
    }
    //Mereset seluruh penanda edge
    static void reset_visited(){
        for(GraphEdge cur: list_edge){
            edge_visited.replace(cur, Boolean.FALSE);
        }
    }
    
    static HashMap< Pair<String,String>,GraphEdge> dict_edge = new HashMap<>();
    
    //Mendapatkan edge
    static GraphEdge get_edge(String src,String dst){
        return dict_edge.get(new Pair(src,dst));
    }
    //tandai berdasarkan source dan tujuan
    static void tandai_visited(GraphEdge edge){
        edge_visited.replace(edge, Boolean.TRUE);
    }
    //apakah sudah dikunjungi
    static boolean visited(GraphEdge edge){
        return edge_visited.get(edge);
    }

    // ArrayList yang menyimpan track terbaik
    static Pair< ArrayList<GraphEdge>,Double > best_route = new Pair(new ArrayList<>(),0);
    
    static void getListEdge (ArrayList<GraphEdge> listEdge, ArrayList<GraphNode> listNode ){
        for(int i=0;i<listEdge.size();i++){
            GraphNode current = listNode.get(i);
            for(GraphEdge edge : current.getKump_tetangga())
                System.out.println("< "+edge.getSrc().getNama()+"-->"+edge.getDst().getNama()+" > jarak : "+edge.getDistance());
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        //Sample Insert Node 
        
        GraphNode a = new GraphNode(0, "Malang");
        insertKump_Node(a);
        
        GraphNode b = new GraphNode(1, "Batu");
        insertKump_Node(b);
        
        GraphNode c = new GraphNode(2, "Kab Malang");
        insertKump_Node(c);
        
        GraphNode d = new GraphNode(3, "Kepanjen");
        insertKump_Node(d);
        
        
        
        //sample insert edge
        insertEdgeDuaArah("Batu", "Kepanjen", 1);
        
        getListEdge(list_edge,kump_node);
        
    }
    
    
    
}
